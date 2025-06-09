package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeMayEntity;

public interface IXeMayService {
    void addXeMay(XeMayEntity xemay);
    void displayXeMay();
    void deleteIdXeMay(String bienKiemSoatXeMay);
}
