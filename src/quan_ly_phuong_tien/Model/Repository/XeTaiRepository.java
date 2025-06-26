package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;
import quan_ly_phuong_tien.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class XeTaiRepository implements IXeTaiRepository {
    private static final String FILE = "src/quan_ly_phuong_tien/data/XeTai.csv";

    @Override
    public List<XeTaiEntity> findAll() {
        List<XeTaiEntity> list = new ArrayList<>();
        for (String line : ReadAndWriteFile.readFileCSV(FILE)) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",");
            if (arr.length < 5) {
                System.out.println("Lỗi: Dòng không hợp lệ - " + line);
                continue;
            }
            try {
                XeTaiEntity xeTai = new XeTaiEntity(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], Double.parseDouble(arr[4]));
                list.add(xeTai);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Không thể chuyển đổi kiểu dữ liệu - " + line);
            }
        }
        return list;
    }

    @Override
    public void add(XeTaiEntity xeTai) {
        List<String> line = new ArrayList<>();
        line.add(xeTai.getInfoToCSV());
        ReadAndWriteFile.writeListToCSV(FILE, line, true);
    }

    @Override
    public void updateAll(List<XeTaiEntity> xeTaiList) {
        List<String> lines = new ArrayList<>();
        for (XeTaiEntity xe : xeTaiList) {
            lines.add(xe.getInfoToCSV());
        }
        ReadAndWriteFile.writeListToCSV(FILE, lines, false);
    }
}
