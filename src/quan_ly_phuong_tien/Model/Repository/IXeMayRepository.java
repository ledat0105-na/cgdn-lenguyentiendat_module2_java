package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.XeMayEntity;

import java.util.List;

public interface IXeMayRepository {
    List<XeMayEntity> findAll();

    void add(XeMayEntity xeMay);

    void updateAll(List<XeMayEntity> xeMayList);
}
