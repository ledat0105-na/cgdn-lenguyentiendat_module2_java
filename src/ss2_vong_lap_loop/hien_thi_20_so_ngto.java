package ss2_vong_lap_loop;

import java.util.Scanner;

public class hien_thi_20_so_ngto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng số nguyên tố cần hiển thị: ");
        int numbers = sc.nextInt();
        int count = 0;
        int n = 2;
        System.out.println("Các số nguyên tố đầu tiên là: ");
        while (count < numbers) {
            if (laSoNguyenTo(n)) {
                System.out.println(n + " ");
                count++;
            }
            n++;
        }
    }

    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}