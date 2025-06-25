package ss17_binary_file.binary_file_product.repository;

import ss17_binary_file.binary_file_product.entity.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product product);
    List<Product> getAll();
    Product findByName(String name);
}
