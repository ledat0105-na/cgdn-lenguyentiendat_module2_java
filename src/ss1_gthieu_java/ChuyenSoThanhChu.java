package ss1_gthieu_java;

import java.util.Scanner;

public class ChuyenSoThanhChu {
    public static String docSoDonVi(int so) {
        switch (so) {
            case 0: return "không";
            case 1: return "một";
            case 2: return "hai";
            case 3: return "ba";
            case 4: return "bốn";
            case 5: return "năm";
            case 6: return "sáu";
            case 7: return "bảy";
            case 8: return "tám";
            case 9: return "chín";
            default: return "";
        }
    }

    public static String docSoTu10Den19(int so) {
        switch (so) {
            case 10: return "mười";
            case 11: return "mười một";
            case 12: return "mười hai";
            case 13: return "mười ba";
            case 14: return "mười bốn";
            case 15: return "mười lăm";
            case 16: return "mười sáu";
            case 17: return "mười bảy";
            case 18: return "mười tám";
            case 19: return "mười chín";
            default: return "";
        }
    }

    public static String docHangChuc(int hangChuc) {
        switch (hangChuc) {
            case 2: return "hai mươi";
            case 3: return "ba mươi";
            case 4: return "bốn mươi";
            case 5: return "năm mươi";
            case 6: return "sáu mươi";
            case 7: return "bảy mươi";
            case 8: return "tám mươi";
            case 9: return "chín mươi";
            default: return "";
        }
    }

    public static String docSo(int so) {
        if (so < 0 || so > 999) {
            return "ngoài khả năng";
        }

        if (so < 10) {
            return docSoDonVi(so);
        } else if (so < 20) {
            return docSoTu10Den19(so);
        } else if (so < 100) {
            int chuc = so / 10;
            int donVi = so % 10;
            if (donVi == 0) {
                return docHangChuc(chuc);
            } else {
                return docHangChuc(chuc) + " " + docSoDonVi(donVi);
            }
        } else {
            int tram = so / 100;
            int phanConLai = so % 100;
            String ketQua = docSoDonVi(tram) + " trăm";
            if (phanConLai == 0) {
                return ketQua;
            } else {
                return ketQua + " " + docSo(phanConLai);
            }
        }
    }

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập số nguyên từ 0 đến 999: ");
        int soNhap = nhap.nextInt();
        System.out.println("Cách đọc: " + docSo(soNhap));
    }
}