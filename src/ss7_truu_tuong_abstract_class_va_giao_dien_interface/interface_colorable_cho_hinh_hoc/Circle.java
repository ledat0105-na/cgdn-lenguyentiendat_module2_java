package ss7_truu_tuong_abstract_class_va_giao_dien_interface.interface_colorable_cho_hinh_hoc;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

