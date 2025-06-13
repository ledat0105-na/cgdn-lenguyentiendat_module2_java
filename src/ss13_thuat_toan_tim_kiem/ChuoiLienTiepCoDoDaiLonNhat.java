package ss13_thuat_toan_tim_kiem;

import java.util.Scanner;

public class ChuoiLienTiepCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi: ");
        String chuoiGoc = sc.nextLine();

        String chuoiHienTai = "";
        String chuoiDaiNhat = "";

        for (int i = 0; i < chuoiGoc.length(); i++) {
            char kyTu = chuoiGoc.charAt(i);
            if (chuoiHienTai.isEmpty() || kyTu >= chuoiHienTai.charAt(chuoiHienTai.length() - 1)) {
                chuoiHienTai += kyTu;
            } else {
                if (chuoiHienTai.length() > chuoiDaiNhat.length()) {
                    chuoiDaiNhat = chuoiHienTai;
                }
                chuoiHienTai = "" + kyTu;
            }
        }

        if (chuoiHienTai.length() > chuoiDaiNhat.length()) {
            chuoiDaiNhat = chuoiHienTai;
        }

        System.out.println(chuoiDaiNhat);
    }
}