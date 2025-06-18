package ss15_try_catch;

import java.util.Scanner;

public class KiemTraTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập cạnh thứ nhất: ");
            double a = sc.nextDouble();

            System.out.print("Nhập cạnh thứ hai: ");
            double b = sc.nextDouble();

            System.out.print("Nhập cạnh thứ ba: ");
            double c = sc.nextDouble();

            kiemTraTamGiac(a, b, c);
            System.out.println("Ba cạnh hợp lệ. Đây là một tam giác");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không hợp lệ: Hãy nhập số hợp lệ!");
        }
    }

    public static void kiemTraTamGiac(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Không được nhập cạnh âm hoặc bằng 0!");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh không lớn hơn cạnh còn lại!");
        }
    }
}
