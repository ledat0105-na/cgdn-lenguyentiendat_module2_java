package ss3_mang_array;

import java.util.Scanner;

public class TinhTongCacSoCuaMaTranVuongMang2Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập kích thước ma trân vuông: ");
        int number = sc.nextInt();

        double[][] maTran = new double[number][number];
        System.out.println("Nhập các phần tử của ma trận: ");
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print("ma trận [" + i + "][" + j + "] = ");
                maTran[i][j] = sc.nextDouble();
            }
        }
        double tong = 0;
        for (int i = 0; i < number; i++) {
            tong += maTran[i][i];
        }
        System.out.println("Tổng các phần tử ở đường chéo chính là: " + tong);
    }
}
