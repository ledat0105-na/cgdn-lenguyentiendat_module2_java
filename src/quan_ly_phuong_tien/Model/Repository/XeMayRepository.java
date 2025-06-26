package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class XeMayRepository implements IXeMayRepository {
    private static final String FILE = "src/quan_ly_phuong_tien/data/XeMay.csv";

    @Override
    public List<XeMayEntity> findAll() {
        List<XeMayEntity> list = new ArrayList<>();
        for (String line : ReadAndWriteFile.readFileCSV(FILE)) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",");
            if (arr.length < 5) {
                System.out.println("Lỗi: Dòng không hợp lệ - " + line);
                continue;
            }
            try {
                XeMayEntity xe = new XeMayEntity(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], Integer.parseInt(arr[4]));
                list.add(xe);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Không thể chuyển đổi kiểu dữ liệu - " + line);
            }
        }
        return list;
    }

    @Override
    public void add(XeMayEntity xeMay) {
        List<String> line = new ArrayList<>();
        line.add(xeMay.getInfoToCSV());
        ReadAndWriteFile.writeListToCSV(FILE, line, true);
    }

    @Override
    public void updateAll(List<XeMayEntity> xeMayList) {
        List<String> lines = new ArrayList<>();
        for (XeMayEntity xe : xeMayList) {
            lines.add(xe.getInfoToCSV());
        }
        ReadAndWriteFile.writeListToCSV(FILE, lines, false);
    }
}