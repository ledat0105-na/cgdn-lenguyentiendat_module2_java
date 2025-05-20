package ss3_mang_array;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mang = new int[10];
        int soLuongPhanTu = 5;
        mang[0] = 10;
        mang[1] = 4;
        mang[2] = 6;
        mang[3] = 7;
        mang[4] = 8;

        System.out.print("Mảng ban đầu: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            System.out.print(mang[i] + " ");
        }
        System.out.println();

        System.out.print("Nhập số cần chèn: ");
        int x = sc.nextInt();

        System.out.print("Nhập vị trí cần chèn (index): ");
        int index = sc.nextInt();

        if (index < 0 || index > soLuongPhanTu || soLuongPhanTu >= mang.length) {
            System.out.println("Không chèn được phần tử vào mảng.");
        } else {
            for (int i = soLuongPhanTu; i > index; i--) {
                mang[i] = mang[i - 1];
            }

            // Chèn phần tử
            mang[index] = x;
            soLuongPhanTu++;

            // Bước 6: In mảng sau khi chèn
            System.out.print("Mảng sau khi chèn: ");
            for (int i = 0; i < soLuongPhanTu; i++) {
                System.out.print(mang[i] + " ");
            }
            System.out.println();
        }
    }
}
