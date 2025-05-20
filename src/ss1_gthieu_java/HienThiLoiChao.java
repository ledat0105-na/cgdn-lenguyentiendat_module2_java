package ss1_gthieu_java;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập lời chào: ");
        String name = sc.nextLine();
        System.out.println("Xin chào " + name);
    }
}