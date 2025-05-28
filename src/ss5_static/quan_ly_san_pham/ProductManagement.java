package ss5_static.quan_ly_san_pham;

import java.util.Scanner;

public class ProductManagement {
    private static Student[] students = new Student[10];
    private static int productCount = 7;

    static {
        students[0] = new Student("Nước Coca", 10000);
        students[1] = new Student("Nước Pepssi", 10000);
        students[2] = new Student("Bánh ngọt", 20000);
        students[3] = new Student("Sữa hộp", 25000);
        students[4] = new Student("Kẹo", 2000);
        students[5] = new Student("Sữa chua", 25000);
        students[6] = new Student("Sữa vinamilk", 30000);
    }

    public static void main(String[] args) {
        DisplayMenu();
    }

    public static void DisplayMenu() {
        final int DISPLAY = 1;
        final int ADD = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int SEARCH = 5;
        final int LIST = 6;

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("-----Chọn chức năng-----\n"
                    + "1.Hiển thị danh sách sản phẩm\n"
                    + "2.Thêm mới sản phẩm\n"
                    + "3.Cập nhật sản phẩm\n"
                    + "4.Xóa sản phẩm\n"
                    + "5.Tìm kiếm sản phẩm\n"
                    + "6.Thoát chương trình\n");
            System.out.print("Chọn chức năng bạn muốn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case DISPLAY:
                    displayProduct();
                    break;
                case ADD:
                    addProduct();
                    break;
                case UPDATE:
                    updateProduct();
                    break;
                case DELETE:
                    deleteProduct();
                    break;
                case SEARCH:
                    searchProduct();
                    break;
                default:
                    flag = false;
                    System.out.println("Đã thoát chương trình.");
                    break;
            }
        }
    }

    private static void displayProduct() {
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < productCount; i++) {
            System.out.println("ID: " + students[i].getId());
            System.out.println("Tên: " + students[i].getName());
            System.out.println("Giá: " + students[i].getPrice() + " VND\n");
        }
    }

    public static void addProduct() {
        if (productCount >= students.length) {
            System.out.println("Danh sách sản phẩm đã đầy. Không thể thêm sản phẩm mới.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Student newProduct = new Student(name, price);
        students[productCount] = newProduct;
        productCount++;

        System.out.println("Đã thêm sản phẩm có ID: " + newProduct.getId());
    }

    public static void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                System.out.print("Nhập tên mới: ");
                String newName = scanner.nextLine();
                System.out.print("Nhập giá mới: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();

                students[i].setName(newName);
                students[i].setPrice(newPrice);
                System.out.println("Cập nhật thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm với ID: " + id);
    }

    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < productCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--productCount] = null;
                System.out.println("Đã xóa sản phẩm thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm với ID: " + id);
    }

    public static void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập từ khóa tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (students[i].getName().toLowerCase().contains(keyword)) {
                System.out.println("Sản phẩm bạn tìm thấy là:");
                System.out.println("ID: " + students[i].getId());
                System.out.println("Tên: " + students[i].getName());
                System.out.println("Giá: " + students[i].getPrice() + " VND\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào với từ khóa: " + keyword);
        }
    }
}