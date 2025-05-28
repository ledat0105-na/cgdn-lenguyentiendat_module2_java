package ss7_truu_tuong_abstract_class_va_giao_dien_interface.interface_colorable_cho_hinh_hoc;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(4);

        for (Shape shape : shapes) {
            System.out.printf("Area: %.2f%n", shape.getArea());

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}

