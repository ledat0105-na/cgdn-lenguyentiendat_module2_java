package ss13_thuat_toan_tim_kiem;

import java.util.Scanner;

public class ChuoiTangDanCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi: ");
        String chuoiGoc = sc.nextLine();

        String chuoiTang = "";
        String chuoiTangDaiNhat = "";

        for (int i = 0; i < chuoiGoc.length(); i++) {
            char kyTuHienTai = chuoiGoc.charAt(i);

            if (chuoiTang.isEmpty() || kyTuHienTai > chuoiTang.charAt(chuoiTang.length() - 1)) {
                chuoiTang += kyTuHienTai;
            } else {
                if (chuoiTang.length() > chuoiTangDaiNhat.length()) {
                    chuoiTangDaiNhat = chuoiTang;
                }
                chuoiTang = "" + kyTuHienTai;
            }
        }
        if (chuoiTang.length() > chuoiTangDaiNhat.length()) {
            chuoiTangDaiNhat = chuoiTang;
        }
        System.out.println("Chuỗi tăng dần dài nhất là: " + chuoiTangDaiNhat);
    }
}
