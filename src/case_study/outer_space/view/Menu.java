package case_study.outer_space.view;

import case_study.outer_space.controller.VehicleController;

import java.util.Scanner;

public class Menu {
    private final VehicleController vehicleController = new VehicleController();
    private final Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        int choice;
        do {
            System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN THÁM HIỂM ===");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị danh sách phương tiện");
            System.out.println("3. Tìm kiếm phương tiện");
            System.out.println("4. Xóa phương tiện");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Thêm Drone bay");
                    System.out.println("2. Thêm Xe tuần tra mặt trăng");
                    System.out.print("Nhập lựa chọn: ");
                    int addChoice = Integer.parseInt(sc.nextLine());
                    vehicleController.add(addChoice);
                    break;
                case 2:
                    System.out.println("1. Hiển thị Drone bay");
                    System.out.println("2. Hiển thị Xe tuần tra mặt trăng");
                    System.out.print("Nhập lựa chọn: ");
                    int showChoice = Integer.parseInt(sc.nextLine());
                    vehicleController.display(showChoice);
                    break;
                case 3:
                    System.out.println("Nhập từ khóa số hiệu đăng ký hoặc tên người điều phối: ");
                    String keyword = sc.nextLine();
                    vehicleController.search(keyword);
                    break;
                case 4:
                    System.out.println("Nhập số hiệu phương tiện muốn xóa: ");
                    String soHieu = sc.nextLine();
                    vehicleController.delete(soHieu);
                    break;
                case 5:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, Vui lòng chọn lại!");
            }
        } while (choice != 5);
    }
}
