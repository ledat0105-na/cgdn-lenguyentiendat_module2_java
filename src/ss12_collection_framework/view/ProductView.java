package ss12_collection_framework.view;

import ss12_collection_framework.model.entity.ProductEntity;
import ss12_collection_framework.controller.ProductController;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final ProductController controller = new ProductController();
    private final Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n===== CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Hiển thị sản phẩm");
            System.out.println("5. Tìm theo tên");
            System.out.println("6. Sắp xếp giá tăng dần");
            System.out.println("7. Sắp xếp giá giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    controller.sortPriceAsc();
                    showAll();
                    break;
                case 7:
                    controller.sortPriceDesc();
                    showAll();
                    break;
                case 0:
                    System.out.println("Chương trình đã dừng!");
                    return;
                default:
                    System.out.println("Chọn sai, vui lòng thử lại!");
            }
        }
    }

    public void addProduct() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());
        controller.addProduct(id, name, price);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public void editProduct() {
        System.out.print("ID cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Tên mới: ");
        String name = sc.nextLine();
        System.out.print("Giá mới: ");
        double price = Double.parseDouble(sc.nextLine());
        controller.editProduct(id, name, price);
        System.out.println("Cập nhật sản phẩm thành công!");
    }

    public void deleteProduct() {
        System.out.print("ID cần xoá: ");
        int id = Integer.parseInt(sc.nextLine());
        controller.deleteProduct(id);
        System.out.println("Xóa sản phẩm thành công!");
    }

    public void showAll() {
        System.out.println("----- DANH SÁCH SẢN PHẨM -----");
        List<ProductEntity> products = controller.showAll();
        if (products.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (ProductEntity p : products) {
                System.out.println(p);
            }
        }
    }

    public void searchByName() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("SẢN PHẨM ĐÃ TÌM KIẾM: ");
        List<ProductEntity> result = controller.searchProduct(name);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy.");
        } else {
            for (ProductEntity p : result) {
                System.out.println(p);
            }
        }
    }
}
