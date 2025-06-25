package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;
import quan_ly_phuong_tien.Model.Entity.PhuongTien;
import quan_ly_phuong_tien.Model.Repository.PhuongTienRepository;

import java.util.List;

public class ImplXeTaiService implements IXeTaiService {

    private final PhuongTienRepository repository = new PhuongTienRepository();

    @Override
    public void addXeTai(XeTaiEntity xeTai) {
        repository.add(xeTai);
    }

    @Override
    public void displayXeTai() {
        List<PhuongTien> danhSach = repository.findAll();
        boolean found = false;

        for (PhuongTien pt : danhSach) {
            if (pt instanceof XeTaiEntity) {
                System.out.println(pt);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có xe tải nào để hiển thị.");
        }
    }

    @Override
    public void deleteIdXeTai(String bienKiemSoatXeTai) {
        List<PhuongTien> danhSach = repository.findAll();
        boolean deleted = false;

        for (PhuongTien pt : danhSach) {
            if (pt instanceof XeTaiEntity &&
                    pt.getBienKiemSoat().equalsIgnoreCase(bienKiemSoatXeTai)) {
                deleted = repository.deleteByBienSo(pt.getBienKiemSoat());
                break;
            }
        }
    }
}