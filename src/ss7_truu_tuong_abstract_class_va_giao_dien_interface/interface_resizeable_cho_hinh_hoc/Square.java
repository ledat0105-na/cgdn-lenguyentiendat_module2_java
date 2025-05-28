package ss7_truu_tuong_abstract_class_va_giao_dien_interface.interface_resizeable_cho_hinh_hoc;

public class Square implements Resizeable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public void resize(double percent) {
        side += side * percent / 100;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
