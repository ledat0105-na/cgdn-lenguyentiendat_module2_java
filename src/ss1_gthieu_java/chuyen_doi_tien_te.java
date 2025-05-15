package ss1_gthieu_java;

import java.util.Scanner;

public class chuyen_doi_tien_te {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tien USD: ");
        usd = sc.nextDouble();
        double quyDoi = usd * 23000;
        System.out.println("Gia tri VND la " + quyDoi);
    }
}