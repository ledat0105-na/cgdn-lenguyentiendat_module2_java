package kiem_tra_module2.controller;

import kiem_tra_module2.model.entity.Contact;
import kiem_tra_module2.model.repository.ContactRepository;
import kiem_tra_module2.model.repository.IContactRepository;
import kiem_tra_module2.model.service.ContactService;
import kiem_tra_module2.model.service.IContactService;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private final Scanner sc = new Scanner(System.in);
    private final IContactService service = new ContactService();
    private final IContactRepository repository = new ContactRepository();  // để dùng saveAll()
    private int choice;

    public void showMenu() {
        while (true) {
            System.out.println("\n===== CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ =====");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
                continue;
            }

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
                case 6:
                    System.out.println("=== Đọc từ file ===");
                    service.displayAll();
                    break;
                case 7:
                    System.out.println("=== Ghi vào file ===");
                    List<Contact> list = repository.getAll();
                    repository.saveAll(list);
                    System.out.println("Đã ghi danh bạ vào file thành công.");
                    break;
                case 8:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}