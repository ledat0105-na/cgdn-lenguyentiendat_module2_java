package ss17_binary_file.binary_file_product.repository;

import ss17_binary_file.binary_file_product.entity.Product;
import ss17_binary_file.binary_file_product.util.BinaryFileUtil;

import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String FILE_PATH = "src/ss17_binary_file/binary_file_product/data/products.dat";

    @Override
    public void add(Product product) {
        List<Product> list = getAll();
        list.add(product);
        BinaryFileUtil.writeToFile(FILE_PATH, list);
    }

    @Override
    public List<Product> getAll() {
        return BinaryFileUtil.readFromFile(FILE_PATH);
    }

    @Override
    public Product findByName(String name) {
        for (Product p : getAll()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
