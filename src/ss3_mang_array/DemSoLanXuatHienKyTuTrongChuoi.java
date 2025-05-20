package ss3_mang_array;

import java.util.Scanner;

public class DemSoLanXuatHienKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chuoi = "Lap trinh java co ban";

        System.out.println("Chuỗi ban đầu có là: " + chuoi);
        System.out.print("Nhập ký tự cần đếm: ");
        char kyTu = sc.next().charAt(0);

        int count = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == kyTu) {
                count++;
            }
        }
        System.out.println("Ký tự ' " + kyTu + " ' xuất hiện " + count + " lần");
    }
}
