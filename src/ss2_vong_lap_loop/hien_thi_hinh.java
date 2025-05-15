package ss2_vong_lap_loop;

import java.util.Scanner;

public class hien_thi_hinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luachon;

        do {
            System.out.println("\n ----- Menu -----");
            System.out.println("1. In hình chữ nhật");
            System.out.println("2. In tam giác vuông (4 góc)");
            System.out.println("3. In tam giác cân");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luachon = sc.nextInt();

            switch (luachon) {
                case 1:
                    inHinhChuNhat(4, 8);
                    break;
                case 2:
                    inTamGiacVuong(5);
                    break;
                case 3:
                    inTamGiacCan(5);
                    break;
                case 4:
                    System.out.println("Đang thoát ...");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ");
            }
        } while (luachon != 4);
    }

    public static void inHinhChuNhat(int chieuCao, int chieuRong) {
        System.out.println("\nHình chữ nhật: ");
        for (int i = 0; i < chieuCao; i++) {
            for (int j = 0; j < chieuRong; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void inTamGiacVuong(int chieuCao) {
        System.out.println("\nTam giác vuông - Góc trên trái:");
        for (int i = chieuCao; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nTam giác vuông - Góc dưới phải:");
        for (int i = 1; i <= chieuCao; i++) {
            for (int j = 1; j <= chieuCao - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nTam giác vuông - Góc trên phải:");
        for (int i = chieuCao; i >= 1; i--) {
            for (int j = 1; j <= chieuCao - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void inTamGiacCan(int chieuCao) {
        System.out.println("\nTam giác cân:");
        for (int i = 1; i <= chieuCao; i++) {
            for (int j = 1; j <= chieuCao - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
