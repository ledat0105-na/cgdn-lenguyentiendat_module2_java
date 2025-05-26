package ss5_static.quan_ly_san_pham;

public class Product {
    private String id;
    private String name;
    private double price;

    public static int count = 0;
    public static int nextId = 1;

    public Product() {
    }

    public Product(String name, double price) {
        this.id = "SP" + nextId++;
        this.name = name;
        this.price = price;
        count++;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
