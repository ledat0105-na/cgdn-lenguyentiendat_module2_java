package ss12_collection_framework.controller;

import ss12_collection_framework.model.entity.ProductEntity;
import ss12_collection_framework.model.service.ProductService;
import java.util.List;

public class ProductController {
    private final ProductService service = new ProductService();

    public void addProduct(int id, String name, double price) {
        ProductEntity product = new ProductEntity(id, name, price);
        service.addProduct(product);
    }

    public List<ProductEntity> showAll() {
        return service.getAllProducts();
    }

    public void editProduct(int id, String name, double price) {
        service.updateProduct(id, name, price);
    }

    public void deleteProduct(int id) {
        service.deleteProduct(id);
    }

    public List<ProductEntity> searchProduct(String name) {
        return service.searchProduct(name);
    }

    public void sortPriceAsc() {
        service.sortAsc();
    }

    public void sortPriceDesc() {
        service.sortDesc();
    }
}
