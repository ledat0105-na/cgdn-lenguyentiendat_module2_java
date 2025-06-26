package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;

public interface IOtoService {
    void addOto(OtoEntity oto);
    void displayOto();

    boolean deleteOto(String bienKiemSoat);
}
