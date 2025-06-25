package ss7_abstract_class_va_interface.interface_colorable_cho_hinh_hoc;

public class Square extends Shape implements Colorable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
