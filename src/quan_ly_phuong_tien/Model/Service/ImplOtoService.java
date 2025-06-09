package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.Model.Repository.PhuongTienRepository;

import java.util.Iterator;

public class ImplOtoService implements IOtoService {

    @Override
    public void addOto(OtoEntity oto) {
        PhuongTienRepository.Otos.add(oto);
    }

    @Override
    public void displayOto() {
        if (PhuongTienRepository.Otos.isEmpty()) {
            System.out.println("Không có ô tô nào để hiển thị.");
            return;
        }
        for (OtoEntity oto : PhuongTienRepository.Otos) {
            System.out.println(oto);
        }
    }

    @Override
    public void deleteOto(String bienKiemSoatOto) {
        Iterator<OtoEntity> iterator = PhuongTienRepository.Otos.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            OtoEntity oto = iterator.next();
            if (oto.getBienKiemSoat().equalsIgnoreCase(bienKiemSoatOto)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Đã xóa ô tô có BKS: " + bienKiemSoatOto);
        } else {
            System.out.println("Không tìm thấy ô tô với BKS: " + bienKiemSoatOto);
        }
    }
}
