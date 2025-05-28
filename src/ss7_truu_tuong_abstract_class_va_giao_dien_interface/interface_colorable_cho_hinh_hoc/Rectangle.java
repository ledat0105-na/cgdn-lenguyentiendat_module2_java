package ss7_truu_tuong_abstract_class_va_giao_dien_interface.interface_colorable_cho_hinh_hoc;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

