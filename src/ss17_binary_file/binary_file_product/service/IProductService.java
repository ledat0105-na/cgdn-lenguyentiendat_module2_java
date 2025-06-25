package ss17_binary_file.binary_file_product.service;

import ss17_binary_file.binary_file_product.entity.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> getAll();
    Product searchByName(String name);
}
