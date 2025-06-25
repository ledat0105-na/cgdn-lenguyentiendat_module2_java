package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.Model.Entity.PhuongTien;
import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;
import quan_ly_phuong_tien.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class PhuongTienRepository implements IPhuongTienRepository {
    private static final String FILE = "src/quan_ly_phuong_tien/data/vehicle.csv";
    private static final boolean APPEND = true;

    @Override
    public List<PhuongTien> findAll() {
        List<PhuongTien> list = new ArrayList<>();
        List<String> lines = ReadAndWriteFile.readFileCSV(FILE);
        for (String line : lines) {
            String[] arr = line.split(",");
            switch (arr[0]) {
                case "XETAI":
                    list.add(new XeTaiEntity(arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], Double.parseDouble(arr[5])));
                    break;
                case "OTO":
                    list.add(new OtoEntity(arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5], Integer.parseInt(arr[6])));
                    break;
                case "XEMAY":
                    list.add(new XeMayEntity(arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], Integer.parseInt(arr[5])));
                    break;
            }
        }
        return list;
    }

    @Override
    public void add(PhuongTien pt) {
        List<String> newLine = new ArrayList<>();
        newLine.add(pt.getInfoToCSV());
        ReadAndWriteFile.writeListToCSV(FILE, newLine, APPEND);
    }

    @Override
    public boolean deleteByBienSo(String bienSo) {
        List<PhuongTien> list = findAll();
        boolean deleted = list.removeIf(p -> p.getBienKiemSoat().equalsIgnoreCase(bienSo));
        if (deleted) {
            List<String> output = new ArrayList<>();
            for (PhuongTien pt : list) {
                output.add(pt.getInfoToCSV());
            }
            ReadAndWriteFile.writeListToCSV(FILE, output, false);
        }
        return deleted;
    }
}
