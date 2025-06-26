package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.Model.Repository.IOtoRepository;
import quan_ly_phuong_tien.Model.Repository.OtoRepository;

import java.util.Iterator;
import java.util.List;

public class ImplOtoService implements IOtoService {

    private final IOtoRepository repository = new OtoRepository();

    @Override
    public void addOto(OtoEntity oto) {
        repository.add(oto);
    }

    @Override
    public void displayOto() {
        List<OtoEntity> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("Không có ô tô nào để hiển thị.");
        } else {
            for (OtoEntity oto : list) {
                System.out.println(oto);
            }
        }
    }

    @Override
    public boolean deleteOto(String bienSo) {
        List<OtoEntity> danhSach = repository.findAll();
        boolean deleted = false;

        Iterator<OtoEntity> iterator = danhSach.iterator();
        while (iterator.hasNext()) {
            OtoEntity oto = iterator.next();
            if (oto.getBienKiemSoat().equalsIgnoreCase(bienSo)) {
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
