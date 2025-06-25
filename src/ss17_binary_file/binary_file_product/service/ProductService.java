package ss17_binary_file.binary_file_product.service;

import ss17_binary_file.binary_file_product.entity.Product;
import ss17_binary_file.binary_file_product.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private final ProductRepository repository = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        repository.add(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    public Product searchByName(String name) {
        return repository.findByName(name);
    }
}
