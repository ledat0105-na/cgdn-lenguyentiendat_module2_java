package quan_ly_phuong_tien.Controller;

import quan_ly_phuong_tien.Model.Entity.OtoEntity;
import quan_ly_phuong_tien.Model.Entity.XeMayEntity;
import quan_ly_phuong_tien.Model.Entity.XeTaiEntity;
import quan_ly_phuong_tien.Model.Service.ImplOtoService;
import quan_ly_phuong_tien.Model.Service.ImplXeMayService;
import quan_ly_phuong_tien.Model.Service.ImplXeTaiService;

import java.util.Scanner;
import java.util.regex.Pattern;

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
            System.out.print("Vui lòng chọn lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addPhuongTien();
                    break;
                case 2:
                    displayPhuongTien();
                    break;
                case 3:
                    deletePhuongTien();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void addPhuongTien() {
        System.out.println("1. Thêm Xe Tải");
        System.out.println("2. Thêm Ô Tô");
        System.out.println("3. Thêm Xe Máy");
        System.out.print("Chọn loại phương tiện: ");
        int type = Integer.parseInt(scanner.nextLine());

        String idVehicle;
        while (true) {
            System.out.print("Nhập biển kiểm soát: ");
            idVehicle = scanner.nextLine();

            if (validateVehicleName(idVehicle)) {
                break;
            } else {
                System.out.println("BKS không hợp lệ. Vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập hãng sản xuất: ");
        String brand = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên chủ sở hữu: ");
        String owner = scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Nhập trọng tải: ");
                double trongTai = Double.parseDouble(scanner.nextLine());
                implXeTaiService.addXeTai(new XeTaiEntity(idVehicle, brand, year, owner, trongTai));
                System.out.println("Xe tải đã được thêm thành công.");
                break;
            case 2:
                System.out.print("Nhập số chỗ ngồi: ");
                int choNgoi = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập loại xe: ");
                String carType = scanner.nextLine();
                implOtoService.addOto(new OtoEntity(idVehicle, brand, year, owner, carType, choNgoi));
                System.out.println("Ô tô đã được thêm thành công.");
                break;
            case 3:
                System.out.print("Nhập công suất: ");
                int power = Integer.parseInt(scanner.nextLine());
                implXeMayService.addXeMay(new XeMayEntity(idVehicle, brand, year, owner, power));
                System.out.println("Xe máy đã được thêm thành công.");
                break;
            default:
                System.out.println("Không có loại phương tiện tương ứng.");
        }
    }

    public static boolean validateVehicleName(String vehicleName) {
        String regex = "^[0-9]{2}[A-Z][0-9]-[0-9]{5}$";
        return Pattern.matches(regex, vehicleName);
    }

    public void displayPhuongTien() {
        System.out.println("1. Hiển thị Xe Tải");
        System.out.println("2. Hiển thị Ô Tô");
        System.out.println("3. Hiển thị Xe Máy");
        System.out.print("Chọn loại phương tiện cần hiển thị: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("----- Danh sách Xe Tải -----");
                implXeTaiService.displayXeTai();
                break;
            case 2:
                System.out.println("----- Danh sách Ô Tô -----");
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

    public void deletePhuongTien() {
        int loaiXe = 0;

        while (true) {
            System.out.println("1. Xóa Xe Tải");
            System.out.println("2. Xóa Ô Tô");
            System.out.println("3. Xóa Xe Máy");
            System.out.print("Chọn loại phương tiện cần xóa: ");

            try {
                loaiXe = Integer.parseInt(scanner.nextLine());
                if (loaiXe < 1 || loaiXe > 3) {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập biển kiểm soát của xe cần xóa: ");
            String idVehicle = scanner.nextLine();

            System.out.print("Bạn có chắc chắn muốn xóa? (Yes/No): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("No")) {
                System.out.println("Hủy xóa phương tiện.");
                break;
            }

            boolean deleted = false;

            switch (loaiXe) {
                case 1:
                    deleted = implXeTaiService.deleteXeTai(idVehicle);
                    if (!deleted) {
                        System.out.println("Không tìm thấy xe tải với BKS: " + idVehicle);
                    }
                    break;
                case 2:
                    deleted = implOtoService.deleteOto(idVehicle);
                    if (!deleted) {
                        System.out.println("Không tìm thấy ô tô với BKS: " + idVehicle);
                    }
                    break;
                case 3:
                    deleted = implXeMayService.deleteXeMay(idVehicle);
                    if (!deleted) {
                        System.out.println("Không tìm thấy xe máy với BKS: " + idVehicle);
                    }
                    break;
            }

            if (deleted) {
                System.out.println("Phương tiện đã được xóa.");
                break;
            } else {
                System.out.println("Vui lòng thử lại với biển kiểm soát hợp lệ hoặc nhập 'No' để hủy.");
                System.out.println("Hoặc nhập 'No' để hủy.");
            }
        }
    }
}
