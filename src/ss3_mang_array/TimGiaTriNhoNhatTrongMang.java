package ss3_mang_array;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("mang[ " + i + "] = ");
            arr[i] = sc.nextInt();
        }
        int min = arr[0];

        for (int i = 0; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
    }
}
