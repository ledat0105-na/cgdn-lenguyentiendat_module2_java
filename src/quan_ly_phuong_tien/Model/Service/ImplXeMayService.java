package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.Model.Repository.IXeMayRepository;
import quan_ly_phuong_tien.Model.Repository.XeMayRepository;

import java.util.Iterator;
import java.util.List;

public class ImplXeMayService implements IXeMayService {

    private final IXeMayRepository repository = new XeMayRepository();

    @Override
    public void addXeMay(XeMayEntity xe) {
        repository.add(xe);
    }

    @Override
    public void displayXeMay() {
        List<XeMayEntity> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("Không có xe máy nào để hiển thị.");
        } else {
            for (XeMayEntity xe : list) {
                System.out.println(xe);
            }
        }
    }

    @Override
    public boolean deleteXeMay(String bienSo) {
        List<XeMayEntity> danhSach = repository.findAll();
        boolean deleted = false;

        Iterator<XeMayEntity> iterator = danhSach.iterator();
        while (iterator.hasNext()) {
            XeMayEntity xe = iterator.next();
            if (xe.getBienKiemSoat().equalsIgnoreCase(bienSo)) {
                iterator.remove();
                deleted = true;
                break;
            }
        }

        if (deleted) {
            repository.updateAll(danhSach);
        }

        return deleted;
    }
}
