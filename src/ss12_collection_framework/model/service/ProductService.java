package ss12_collection_framework.model.service;

import ss12_collection_framework.model.entity.Product;
import ss12_collection_framework.model.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository repository = new ProductRepository();

    public void addProduct(Product product) {
        repository.add(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id);
    }

    public void updateProduct(int id, String name, double price) {
        Product p = repository.findById(id);
        if (p != null) {
            p.setName(name);
            p.setPrice(price);
        }
    }

    public void deleteProduct(int id) {
        repository.delete(id);
    }

    public List<Product> searchProduct(String name) {
        return repository.searchByName(name);
    }

    public void sortAsc() {
        repository.sortByPriceAsc();
    }

    public void sortDesc() {
        repository.sortByPriceDesc();
    }
}

