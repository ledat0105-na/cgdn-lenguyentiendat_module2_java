package quan_ly_phuong_tien.controller;

import quan_ly_phuong_tien.service.PhuongTienService;
import quan_ly_phuong_tien.service.PhuongTienServiceImpl;

import java.util.Scanner;

public class PhuongTienController {
    private PhuongTienService service = new PhuongTienServiceImpl();

    public void hienThiMenu() {
        Scanner scanner = new Scanner(System.in);
        int chon;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
            System.out.println("1. Thêm mới phương tiện.\n2. Hiển thị phương tiện\n3. Xóa phương tiện\n4. Thoát");
            chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    service.themPhuongTien();
                    break;
                case 2:
                    service.hienThiPhuongTien();
                    break;
                case 3:
                    service.xoaPhuongTien();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 4);
    }
}
