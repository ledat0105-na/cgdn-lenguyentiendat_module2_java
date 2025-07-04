package case_study.outer_space.service;

import case_study.outer_space.exception.NotFoundVehicleException;
import case_study.outer_space.model.XeTuanTra;
import case_study.outer_space.repository.IVehicleRepository;
import case_study.outer_space.repository.XeTuanTraRepository;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTuanTraService extends IVehicleService {
    private final IVehicleRepository xeRepository = new XeTuanTraRepository();
    private final HangCheTaoService hangCheTaoService = new HangCheTaoService();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("=== Thêm Xe tuần tra mặt trăng ===");
        String soHieu;
        while (true) {
            System.out.print("Nhập số hiệu (XTT-XXX): ");
            soHieu = sc.nextLine();
            if (soHieu.matches("^XTT-\\d{3}$")) break;
            System.out.println("Sai định dạng!");
        }

        System.out.println("Chọn hãng chế tạo:");
        System.out.println("1. SpaceX (Mỹ)");
        System.out.println("2. NASA (Mỹ)");
        System.out.println("3. Roscosmos (Nga)");
        System.out.println("4. ESA (Liên minh Châu Âu)");
        System.out.println("5. CNSA (Trung Quốc)");

        String maHang = "";
        String tenHang = "";
        String quocGia = "";

        while (true) {
            System.out.print("Nhập lựa chọn (1-5): ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    maHang = "HCT-001";
                    tenHang = "SpaceX";
                    quocGia = "Mỹ";
                    break;
                case "2":
                    maHang = "HCT-002";
                    tenHang = "NASA";
                    quocGia = "Mỹ";
                    break;
                case "3":
                    maHang = "HCT-003";
                    tenHang = "Roscosmos";
                    quocGia = "Nga";
                    break;
                case "4":
                    maHang = "HCT-004";
                    tenHang = "ESA";
                    quocGia = "Liên minh Châu Âu";
                    break;
                case "5":
                    maHang = "HCT-005";
                    tenHang = "CNSA";
                    quocGia = "Trung Quốc";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn từ 1 đến 5.");
                    continue;
            }
            break;
        }

        hangCheTaoService.saveIfNew(maHang, tenHang, quocGia);

        int namSX;
        while (true) {
            System.out.print("Nhập năm sản xuất: ");
            try {
                namSX = Integer.parseInt(sc.nextLine());
                if (namSX <= Year.now().getValue()) break;
                System.out.println("Năm không hợp lệ!");
            } catch (NumberFormatException e) {
                System.out.println("Phải là số nguyên!");
            }
        }

        System.out.print("Nhập người điều phối: ");
        String nguoiDieuPhoi = sc.nextLine().trim();
        while (nguoiDieuPhoi.isEmpty()) {
            System.out.print("Không được để trống. Nhập lại: ");
            nguoiDieuPhoi = sc.nextLine().trim();
        }

        int capDo;
        while (true) {
            System.out.print("Nhập cấp độ chống bức xạ (1-10): ");
            try {
                capDo = Integer.parseInt(sc.nextLine());
                if (capDo >= 1 && capDo <= 10) break;
                System.out.println("Cấp độ phải từ 1 đến 10");
            } catch (NumberFormatException e) {
                System.out.println("Phải là số nguyên!");
            }
        }

        XeTuanTra xe = new XeTuanTra(soHieu, tenHang, namSX, nguoiDieuPhoi, capDo);
        xeRepository.appendData(xe.toCSV());
        System.out.println("Đã thêm Xe tuần tra thành công!");
    }

    @Override
    public void display() {
        List<String> list = xeRepository.readData();
        if (list.isEmpty()) {
            System.out.println("Danh sách xe tuần tra trống.");
        } else {
            System.out.println("=== Danh sách xe tuần tra ===");
            list.forEach(System.out::println);
        }
    }

    @Override
    public void search(String keyword) {
        List<String> list = xeRepository.readData();
        boolean found = false;

        String normalizedKeyword = normalize(keyword);

        for (String line : list) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                String soHieu = normalize(parts[0]);
                String nguoiDieuPhoi = normalize(parts[3]);

                if (soHieu.contains(normalizedKeyword) || nguoiDieuPhoi.contains(normalizedKeyword)) {
                    System.out.println(line);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phương tiện phù hợp.");
        }
    }

    private String normalize(String input) {
        return input.trim().toLowerCase().replaceAll("\\s+", " ");
    }

    @Override
    public void delete(String soHieu) {
        List<String> list = xeRepository.readData();
        List<String> updated = new ArrayList<>();
        boolean found = false;

        for (String line : list) {
            if (line.startsWith(soHieu)) {
                found = true;
            } else {
                updated.add(line);
            }
        }

        if (!found) {
            try {
                throw new NotFoundVehicleException("Số hiệu phương tiện không tồn tại.");
            } catch (NotFoundVehicleException e) {
                System.out.println(e.getMessage());
            }
            return;
        }

        System.out.print("Xác nhận xóa (Yes/No): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            xeRepository.writeData(updated);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Hủy thao tác xóa");
        }
    }
}