package ss14_thuat_toan_sap_xep;

import java.util.Scanner;

public class MinhHoaThuatToanSapXepChen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập độ dài của mảng: ");
        int size = scanner.nextInt();
        int[] list = new int[size];

        System.out.print("Độ dài " + list.length + " giá trị: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.print("Mảng đã nhập vào: ");
        for (int value : list) {
            System.out.print(value + "\t");
        }

        System.out.println("\n\nBắt đầu xử lý sắp xếp......");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println("Đổi chỗ " + list[i] + " cho " + list[i + 1]);

                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }

            System.out.print("Sau khi sắp xếp " + k + " loại: ");
            for (int value : list) {
                System.out.print(value + "\t");
            }
            System.out.println();

            if (!needNextPass) {
                System.out.println("Mảng có thể được sắp xếp và không cần lần duyệt tiếp theo");
                break;
            }
        }
    }
}
