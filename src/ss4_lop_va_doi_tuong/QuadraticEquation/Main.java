package ss4_lop_va_doi_tuong.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập a: ");
        double a = input.nextDouble();
        System.out.print("Nhập b: ");
        double b = input.nextDouble();
        System.out.print("Nhập c: ");
        double c = input.nextDouble();

        QuadraticEquation eq = new QuadraticEquation(a, b, c);
        double delta = eq.getDiscriminant();

        if (delta > 0) {
            System.out.println("Phương trình có 2 nghiệm " + eq.getRoot1() + " and " + eq.getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có 1 nghiệm " + eq.getRoot1());
        } else {
            System.out.println("Phương trình có vô số nghiệm");
        }
    }
}
