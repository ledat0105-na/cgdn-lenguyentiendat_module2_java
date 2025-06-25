//LinkedList
//private final List<ProductEntity> productList = new LinkedList<>();
package ss12_collection_framework.model.repository;

import ss12_collection_framework.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<ProductEntity> productList = new ArrayList<>();

    public void add(ProductEntity product) {
        productList.add(product);
    }

    public List<ProductEntity> findAll() {
        return productList;
    }

    public ProductEntity findById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void delete(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    public List<ProductEntity> searchByName(String keyword) {
        List<ProductEntity> result = new ArrayList<>();
        for (ProductEntity product : productList) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public void sortByPriceAsc() {
        productList.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }

    public void sortByPriceDesc() {
        productList.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
    }
}
