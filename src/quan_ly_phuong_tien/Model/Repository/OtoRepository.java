package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class OtoRepository implements IOtoRepository {
    private static final String FILE = "src/quan_ly_phuong_tien/data/Oto.csv";

    @Override
    public List<OtoEntity> findAll() {
        List<OtoEntity> list = new ArrayList<>();
        for (String line : ReadAndWriteFile.readFileCSV(FILE)) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",");
            if (arr.length < 6) {
                System.out.println("Lỗi: Dòng không hợp lệ - " + line);
                continue;
            }
            try {
                OtoEntity oto = new OtoEntity(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], arr[4], Integer.parseInt(arr[5]));
                list.add(oto);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Không thể chuyển đổi kiểu dữ liệu - " + line);
            }
        }
        return list;
    }

    @Override
    public void add(OtoEntity oto) {
        List<String> line = new ArrayList<>();
        line.add(oto.getInfoToCSV());
        ReadAndWriteFile.writeListToCSV(FILE, line, true);
    }

    @Override
    public void updateAll(List<OtoEntity> otoList) {
        List<String> lines = new ArrayList<>();
        for (OtoEntity xe : otoList) {
            lines.add(xe.getInfoToCSV());
        }
        ReadAndWriteFile.writeListToCSV(FILE, lines, false);
    }
}
