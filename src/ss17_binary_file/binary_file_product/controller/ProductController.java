package ss17_binary_file.binary_file_product.controller;

import ss17_binary_file.binary_file_product.entity.Product;
import ss17_binary_file.binary_file_product.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService service = new ProductService();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== QUẢN LÝ SẢN PHẨM ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void add() {
        System.out.print("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Hãng sản xuất: ");
        String producer = scanner.nextLine();
        System.out.print("Mô tả: ");
        String description = scanner.nextLine();

        Product product = new Product(id, name, price, producer, description);
        service.addProduct(product);
        System.out.println("Thêm sản phẩm thành công.");
    }

    private void display() {
        List<Product> list = service.getAll();
        if (list.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

    private void search() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        Product p = service.searchByName(name);
        if (p != null) {
            System.out.println("Tìm thấy: " + p);
        } else {
            System.out.println("Không tìm thấy sản phẩm có tên: " + name);
        }
    }
}

