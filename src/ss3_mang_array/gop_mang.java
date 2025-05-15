package ss3_mang_array;

import java.util.Scanner;

public class gop_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử mảng 1: ");
        int size1 = scanner.nextInt();
        int[] mang1 = new int[size1];

        System.out.print("Nhập số lượng phần tử mảng 2: ");
        int size2 = scanner.nextInt();
        int[] mang2 = new int[size2];

        System.out.println("Nhập các phần tử cho mảng 1:");
        for (int i = 0; i < size1; i++) {
            System.out.print("mang1[" + i + "] = ");
            mang1[i] = scanner.nextInt();
        }

        System.out.println("Nhập các phần tử cho mảng 2:");
        for (int i = 0; i < size2; i++) {
            System.out.print("mang2[" + i + "] = ");
            mang2[i] = scanner.nextInt();
        }

        int[] mang3 = new int[size1 + size2];

        for (int i = 0; i < size1; i++) {
            mang3[i] = mang1[i];
        }

        for (int i = 0; i < size2; i++) {
            mang3[size1 + i] = mang2[i];
        }

        System.out.print("Mảng sau khi gộp là: ");
        for (int i = 0; i < mang3.length; i++) {
            System.out.print(mang3[i] + " ");
        }
    }
}
