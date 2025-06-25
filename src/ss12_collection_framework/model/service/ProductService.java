package ss12_collection_framework.model.service;

import ss12_collection_framework.model.entity.ProductEntity;
import ss12_collection_framework.model.repository.ProductRepository;
import java.util.List;

public class ProductService {
    private final ProductRepository repository = new ProductRepository();

    public void addProduct(ProductEntity product) {
        repository.add(product);
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public ProductEntity getProductById(int id) {
        return repository.findById(id);
    }

    public void updateProduct(int id, String name, double price) {
        ProductEntity product = repository.findById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
        }
    }

    public void deleteProduct(int id) {
        repository.delete(id);
    }

    public List<ProductEntity> searchProduct(String name) {
        return repository.searchByName(name);
    }

    public void sortAsc() {
        repository.sortByPriceAsc();
    }

    public void sortDesc() {
        repository.sortByPriceDesc();
    }
}
