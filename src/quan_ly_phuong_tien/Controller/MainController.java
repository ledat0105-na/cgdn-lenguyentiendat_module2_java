package quan_ly_phuong_tien.Controller;

import quan_ly_phuong_tien.Model.Service.ImplOtoService;
import quan_ly_phuong_tien.Model.Service.ImplXeMayService;
import quan_ly_phuong_tien.Model.Service.ImplXeTaiService;
import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;

import java.util.Scanner;

public class MainController {
    ImplOtoService implOtoService = new ImplOtoService();
    ImplXeMayService implXeMayService = new ImplXeMayService();
    ImplXeTaiService implXeTaiService = new ImplXeTaiService();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("1. Thêm phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thoát");
            System.out.println("Vui lòng chọn những lựa chọn sau: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addPhuongTien();
                    break;
                case 2:
                    displayPhuongTien();
                    break;
                case 3:
                    deletePhuongtien();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void addPhuongTien() {
        System.out.println("1. Thêm Xe Tải");
        System.out.println("2. Thêm Oto");
        System.out.println("3. Thêm Xe Máy");
        System.out.print("Mời chọn các lựa chọn sau: ");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập BKS phương tiện: ");
        String idVehicle = scanner.nextLine();
        System.out.println("Nhập hãng xe: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập người sở hữu: ");
        String owner = scanner.nextLine();

        switch (type) {
            case 1:
                System.out.println("Trọng tải: ");
                int trongTai = Integer.parseInt(scanner.nextLine());
                implXeTaiService.addXeTai(new XeTaiEntity(idVehicle, brand, year, owner, trongTai));
                System.out.println("Đã thêm thành công");
                break;
            case 2:
                System.out.println("Nhập số chỗ ngồi: ");
                int choNgoi = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập loại xe: ");
                String carType = scanner.nextLine();
                implOtoService.addOto(new OtoEntity(idVehicle, brand, year, owner, carType, choNgoi));
                System.out.println("Đã thêm thành công");
                break;
            case 3:
                System.out.println("Nhập công suất: ");
                int power = Integer.parseInt(scanner.nextLine());
                implXeMayService.addXeMay(new XeMayEntity(idVehicle, brand, year, owner, power));
                System.out.println("Đã thêm thành công");
                break;
            default:
                System.out.println("Không có phương tiện nào.");
        }
    }

    public void displayPhuongTien() {
        System.out.println("1. Hiển thị Xe Tải");
        System.out.println("2. Hiển thị Xe Oto");
        System.out.println("3. Hiển thị Xe Máy");
        System.out.print("Vui lòng chọn loại phương tiện cần hiển thị: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("----- Danh sách Xe Tải -----");
                implXeTaiService.displayXeTai();
                break;
            case 2:
                System.out.println("----- Danh sách Xe Ô tô -----");
                implOtoService.displayOto();
                break;
            case 3:
                System.out.println("----- Danh sách Xe Máy -----");
                implXeMayService.displayXeMay();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public void deletePhuongtien() {
        System.out.println("Nhập phương tiện muốn xóa: ");
        String idVehicle = scanner.nextLine();
        System.out.println("Bạn chắc chắn xóa phương tiện này (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            implXeTaiService.deleteIdXeTai(idVehicle);
            implOtoService.deleteOto(idVehicle);
            implXeMayService.deleteIdXeMay(idVehicle);
            System.out.println("Phương tiện đã xóa thành công !!!");
        }
    }
}
