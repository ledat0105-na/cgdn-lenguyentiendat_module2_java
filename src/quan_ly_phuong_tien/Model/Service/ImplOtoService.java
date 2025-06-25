package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.Model.Entity.PhuongTien;
import quan_ly_phuong_tien.Model.Repository.PhuongTienRepository;

import java.util.List;

public class ImplOtoService implements IOtoService {

    private final PhuongTienRepository repository = new PhuongTienRepository();

    @Override
    public void addOto(OtoEntity oto) {
        repository.add(oto);
    }

    @Override
    public void displayOto() {
        List<PhuongTien> danhSach = repository.findAll();
        boolean found = false;
        for (PhuongTien pt : danhSach) {
            if (pt instanceof OtoEntity) {
                System.out.println(pt);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có ô tô nào để hiển thị.");
        }
    }

    @Override
    public void deleteOto(String bienKiemSoatOto) {
        List<PhuongTien> danhSach = repository.findAll();
        boolean deleted = false;

        for (PhuongTien pt : danhSach) {
            if (pt instanceof OtoEntity &&
                    pt.getBienKiemSoat().equalsIgnoreCase(bienKiemSoatOto)) {
                deleted = repository.deleteByBienSo(pt.getBienKiemSoat());
                break;
            }
        }

        if (deleted) {
            System.out.println("Đã xóa ô tô có BKS: " + bienKiemSoatOto);
        } else {
            System.out.println("Không tìm thấy ô tô với BKS: " + bienKiemSoatOto);
        }
    }
}