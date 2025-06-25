package ss12_collection_framework.model.repository;

import ss12_collection_framework.model.entity.ProductEntity;

import java.util.List;

public interface IProductRepository {
    void add(ProductEntity product);

    List<ProductEntity> findAll();

    ProductEntity findById(int id);

    void delete(int id);

    List<ProductEntity> searchByName(String keyword);

    void sortByPriceAsc();

    void sortByPriceDesc();
}
