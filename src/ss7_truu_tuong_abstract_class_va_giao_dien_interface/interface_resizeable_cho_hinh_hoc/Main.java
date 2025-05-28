package ss7_truu_tuong_abstract_class_va_giao_dien_interface.interface_resizeable_cho_hinh_hoc;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Resizeable[] shapes = {
                new Circle(10),
                new Rectangle(4, 5),
                new Square(6)
        };

        Random random = new Random();

        for (Resizeable shape : shapes) {
            double percent = 1 + random.nextInt(100);

            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.printf("Circle - Before: %.2f, ", c.getArea());
                c.resize(percent);
                System.out.printf("After (%.0f%%): %.2f%n", percent, c.getArea());
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                System.out.printf("Rectangle - Before: %.2f, ", r.getArea());
                r.resize(percent);
                System.out.printf("After (%.0f%%): %.2f%n", percent, r.getArea());
            } else if (shape instanceof Square) {
                Square s = (Square) shape;
                System.out.printf("Square - Before: %.2f, ", s.getArea());
                s.resize(percent);
                System.out.printf("After (%.0f%%): %.2f%n", percent, s.getArea());
            }
        }
    }
}

