package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;

import java.util.List;

public interface IOtoRepository {
    List<OtoEntity> findAll();

    void add(OtoEntity oto);

    void updateAll(List<OtoEntity> otoList);
}