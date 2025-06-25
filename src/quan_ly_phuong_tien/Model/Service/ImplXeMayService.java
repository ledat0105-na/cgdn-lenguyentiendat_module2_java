package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.Model.Entity.PhuongTien;
import quan_ly_phuong_tien.Model.Repository.PhuongTienRepository;

import java.util.List;

public class ImplXeMayService implements IXeMayService {

    private final PhuongTienRepository repository = new PhuongTienRepository();

    @Override
    public void addXeMay(XeMayEntity xeMay) {
        repository.add(xeMay);
    }

    @Override
    public void displayXeMay() {
        List<PhuongTien> list = repository.findAll();
        boolean found = false;
        for (PhuongTien pt : list) {
            if (pt instanceof XeMayEntity) {
                System.out.println(pt);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có xe máy nào để hiển thị.");
        }
    }

    @Override
    public void deleteIdXeMay(String bienKiemSoatXeMay) {
        List<PhuongTien> list = repository.findAll();
        boolean deleted = false;

        for (PhuongTien pt : list) {
            if (pt instanceof XeMayEntity &&
                    pt.getBienKiemSoat().equalsIgnoreCase(bienKiemSoatXeMay)) {
                deleted = repository.deleteByBienSo(pt.getBienKiemSoat());
                break;
            }
        }

        if (deleted) {
            System.out.println("Đã xóa xe máy có BKS: " + bienKiemSoatXeMay);
        } else {
            System.out.println("Không tìm thấy xe máy với BKS: " + bienKiemSoatXeMay);
        }
    }
}