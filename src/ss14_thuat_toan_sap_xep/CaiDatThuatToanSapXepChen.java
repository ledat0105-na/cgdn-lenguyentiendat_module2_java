package ss14_thuat_toan_sap_xep;

import java.util.Scanner;

public class CaiDatThuatToanSapXepChen {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int giaTriHienTai = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > giaTriHienTai) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = giaTriHienTai;

            System.out.print("Sau khi chèn " + giaTriHienTai + ": ");
            for (int giaTri : list) {
                System.out.print(giaTri + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();
        int[] list = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            list[i] = scanner.nextInt();
        }

        System.out.println("\nMảng ban đầu:");
        for (int value : list) {
            System.out.print(value + "\t");
        }

        System.out.println("\n\nBắt đầu quá trình sắp xếp:");
        insertionSort(list);

        System.out.println("\nMảng sau khi sắp xếp tăng dần:");
        for (int value : list) {
            System.out.print(value + "\t");
        }
    }
}
