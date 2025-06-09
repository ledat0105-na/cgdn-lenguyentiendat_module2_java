package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;
import quan_ly_phuong_tien.Model.Repository.PhuongTienRepository;

import java.util.Iterator;

public class ImplXeTaiService implements IXeTaiService {

    @Override
    public void addXeTai(XeTaiEntity xeTai) {
        PhuongTienRepository.XeTai.add(xeTai);
    }

    @Override
    public void displayXeTai() {
        if (PhuongTienRepository.XeTai.isEmpty()) {
            System.out.println("Không có xe tải nào để hiển thị.");
            return;
        }
        for (XeTaiEntity xeTai : PhuongTienRepository.XeTai) {
            System.out.println(xeTai);
        }
    }

    @Override
    public void deleteIdXeTai(String bienKiemSoatXeTai) {
        Iterator<XeTaiEntity> iterator = PhuongTienRepository.XeTai.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            XeTaiEntity xeTai = iterator.next();
            if (xeTai.getBienKiemSoat().equalsIgnoreCase(bienKiemSoatXeTai)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Đã xóa xe tải có BKS: " + bienKiemSoatXeTai);
        } else {
            System.out.println("Không tìm thấy xe tải với BKS: " + bienKiemSoatXeTai);
        }
    }
}