package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.Model.Repository.PhuongTienRepository;

import java.util.Iterator;

public class ImplXeMayService implements IXeMayService {

    @Override
    public void addXeMay(XeMayEntity xeMay) {
        PhuongTienRepository.XeMays.add(xeMay);
    }

    @Override
    public void displayXeMay() {
        if (PhuongTienRepository.XeMays.isEmpty()) {
            System.out.println("Không có xe máy nào để hiển thị.");
            return;
        }
        for (XeMayEntity xeMay : PhuongTienRepository.XeMays) {
            System.out.println(xeMay);
        }
    }

    @Override
    public void deleteIdXeMay(String bienKiemSoatXeMay) {
        Iterator<XeMayEntity> iterator = PhuongTienRepository.XeMays.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            XeMayEntity xeMay = iterator.next();
            if (xeMay.getBienKiemSoat().equalsIgnoreCase(bienKiemSoatXeMay)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Đã xóa xe máy có BKS: " + bienKiemSoatXeMay);
        } else {
            System.out.println("Không tìm thấy xe máy với BKS: " + bienKiemSoatXeMay);
        }
    }
}