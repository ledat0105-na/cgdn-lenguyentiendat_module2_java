package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;
import quan_ly_phuong_tien.Model.Repository.IXeTaiRepository;
import quan_ly_phuong_tien.Model.Repository.XeTaiRepository;

import java.util.Iterator;
import java.util.List;

public class ImplXeTaiService implements IXeTaiService {

    private final IXeTaiRepository repository = new XeTaiRepository();

    @Override
    public void addXeTai(XeTaiEntity xe) {
        repository.add(xe);
    }

    @Override
    public void displayXeTai() {
        List<XeTaiEntity> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("Không có xe tải nào để hiển thị.");
        } else {
            for (XeTaiEntity xe : list) {
                System.out.println(xe);
            }
        }
    }

    @Override
    public boolean deleteXeTai(String bienSo) {
        List<XeTaiEntity> danhSach = repository.findAll();
        boolean deleted = false;

        Iterator<XeTaiEntity> iterator = danhSach.iterator();
        while (iterator.hasNext()) {
            XeTaiEntity xe = iterator.next();
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