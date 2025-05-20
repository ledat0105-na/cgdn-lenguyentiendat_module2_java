package ss3_mang_array;

import java.util.Scanner;

public class TinhTonhCacPhanTuCoSanTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số hàng: ");
        int hang = sc.nextInt();

        System.out.print("Nhập số côt: ");
        int cot = sc.nextInt();

        double[][] maTran = new double[hang][cot];
        System.out.println("Nhập giá trị cho ma trận: ");

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print("ma trận [" + i + "][" + j + "] = ");
                maTran[i][j] = sc.nextDouble();
            }
        }
        System.out.print("Nhập chỉ số cột cần tính tổng (từ 0 đến " + (cot - 1) + "): ");
        int cotCanTinh = sc.nextInt();

        if (cotCanTinh < 0 || cotCanTinh >= cot) {
            System.out.println("Chỉ số cột không hợp lệ.");
        } else {
            double tong = 0;
            for (int i = 0; i < hang; i++) {
                tong += maTran[i][cotCanTinh];
            }
            System.out.println("Tổng của cột " + cotCanTinh + " là: " + tong);
        }
    }
}
