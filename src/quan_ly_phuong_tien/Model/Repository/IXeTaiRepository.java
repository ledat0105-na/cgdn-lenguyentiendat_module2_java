package quan_ly_phuong_tien.Model.Repository;

import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;

import java.util.List;

public interface IXeTaiRepository {
    List<XeTaiEntity> findAll();

    void add(XeTaiEntity xeTai);

    void updateAll(List<XeTaiEntity> xeTaiList);
}