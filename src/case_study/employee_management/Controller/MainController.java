package case_study.employee_management.Controller;

import case_study.employee_management.Model.Service.EmployeeService;
import case_study.employee_management.Model.Service.IEmployeeService;

import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IEmployeeService service = new EmployeeService();
    int choice;

    public void showMenu() {
        while (true) {
            System.out.println("\n===== QUẢN LÝ NHÂN VIÊN =====");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Sửa nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm theo ID hoặc tên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    service.displayAll();
                    break;
                case 2:
                    service.add();
                    break;
                case 3:
                    service.edit();
                    break;
                case 4:
                    service.delete();
                    break;
                case 5:
                    service.search();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
