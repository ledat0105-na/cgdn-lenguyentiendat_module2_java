package ss12_collection_framework.model.service;

import ss12_collection_framework.model.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    void addProduct(ProductEntity product);

    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(int id);

    void updateProduct(int id, String name, double price);

    void deleteProduct(int id);

    List<ProductEntity> searchProduct(String name);

    void sortAsc();

    void sortDesc();
}
