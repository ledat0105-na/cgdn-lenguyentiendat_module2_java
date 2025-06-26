package quan_ly_phuong_tien.Model.Service;

import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;

public interface IXeTaiService {
    void addXeTai(XeTaiEntity xeTai);
    void displayXeTai();

    boolean deleteXeTai(String bienKiemSoat);
}
