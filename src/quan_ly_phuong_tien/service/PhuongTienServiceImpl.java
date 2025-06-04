package quan_ly_phuong_tien.service;

import quan_ly_phuong_tien.model.entity.XeTai;
import quan_ly_phuong_tien.model.entity.Oto;
import quan_ly_phuong_tien.model.entity.XeMay;
import quan_ly_phuong_tien.model.entity.PhuongTien;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhuongTienServiceImpl implements PhuongTienService {
    private List<XeTai> xeTais = new ArrayList<>();
    private List<Oto> otos = new ArrayList<>();
    private List<XeMay> xeMays = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void themPhuongTien() {
        System.out.println("1. Thêm xe tải\n2. Thêm ôtô\n3. Thêm xe máy");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.print("Biển kiểm soát: ");
        String bks = scanner.nextLine();
        System.out.print("Hãng sản xuất: ");
        String hsx = scanner.nextLine();
        System.out.print("Năm sản xuất: ");
        int nam = Integer.parseInt(scanner.nextLine());
        System.out.print("Chủ sở hữu: ");
        String chu = scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Trọng tải: ");
                double tt = Double.parseDouble(scanner.nextLine());
                xeTais.add(new XeTai(bks, hsx, nam, chu, tt));
                break;
            case 2:
                System.out.print("Kiểu xe: ");
                String kieu = scanner.nextLine();
                System.out.print("Số chỗ ngồi: ");
                int cho = Integer.parseInt(scanner.nextLine());
                otos.add(new Oto(bks, hsx, nam, chu, kieu, cho));
                break;
            case 3:
                System.out.print("Công suất: ");
                int cs = Integer.parseInt(scanner.nextLine());
                xeMays.add(new XeMay(bks, hsx, nam, chu, cs));
                break;
        }
    }

    @Override
    public void hienThiPhuongTien() {
        System.out.println("1. Hiển thị xe tải\n2. Hiển thị ôtô\n3. Hiển thị xe máy");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                xeTais.forEach(XeTai::hienThiThongTin);
                break;
            case 2:
                otos.forEach(Oto::hienThiThongTin);
                break;
            case 3:
                xeMays.forEach(XeMay::hienThiThongTin);
                break;
        }
    }

    @Override
    public void xoaPhuongTien() {
        System.out.print("Nhập biển kiểm soát: ");
        String bks = scanner.nextLine();
        if (xoaTheoBienSo(xeTais, bks) || xoaTheoBienSo(otos, bks) || xoaTheoBienSo(xeMays, bks)) {
            System.out.println("Đã xóa thành công!");
        } else {
            System.out.println("Không tìm thấy phương tiện!");
        }
    }

    private <T extends PhuongTien> boolean xoaTheoBienSo(List<T> list, String bks) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getBienKiemSoat().equals(bks)) {
                System.out.print("Xác nhận xóa? (Yes/No): ");
                if (scanner.nextLine().equalsIgnoreCase("Yes")) {
                    iterator.remove();
                    return true;
                }
                break;
            }
        }
        return false;
    }
}

