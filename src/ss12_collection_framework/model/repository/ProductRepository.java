package ss12_collection_framework.model.repository;

import ss12_collection_framework.model.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.LinkedList;

public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    //LinkedList
    //private final List<Product> productList = new LinkedList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            if (p.getId() == id) {
                productList.remove(i);
                break;
            }
        }
    }

    public List<Product> searchByName(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public void sortByPriceAsc() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    public void sortByPriceDesc() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
    }
}