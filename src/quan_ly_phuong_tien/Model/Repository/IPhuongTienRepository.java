package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.PhuongTien;

import java.util.List;

public interface IPhuongTienRepository {
        List<PhuongTien> findAll();
        void add(PhuongTien pt);
        boolean deleteByBienSo(String bienSo);
}
