package ss3_mang_array;

import java.util.Scanner;

public class xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 4, 6, 7, 8};
        int soLuongPhanTu = 5;

        System.out.print("Mảng ban đầu: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("Nhập phần tử cần xóa: ");
        int del = sc.nextInt();

        int indexDel = -1;
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (arr[i] == del) {
                indexDel = i;
                break;
            }
        }
        if (indexDel == -1) {
            System.out.println("Không tìm thấy phần tử " + del + "trong mang");
        } else {
            for (int i = indexDel; i < soLuongPhanTu - 1; i++) {
                arr[i] = arr[i + 1];
            }
            soLuongPhanTu--;

            System.out.print("Mảng sau khi xóa: ");
            for (int i = 0; i < soLuongPhanTu; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
