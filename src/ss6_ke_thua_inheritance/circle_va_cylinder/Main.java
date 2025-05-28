package ss6_ke_thua_inheritance.circle_va_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println(c1.toString());

        Circle c2 = new Circle(2.5, "blue");
        System.out.println(c2.toString());

        c2.setRadius(3.0);
        c2.setColor("green");
        System.out.println("Updated c2: " + c2.toString());

        System.out.println();
        Cylinder cyl1 = new Cylinder();
        System.out.println(cyl1.toString());

        Cylinder cyl2 = new Cylinder(2.0, "yellow", 5.0);
        System.out.println(cyl2.toString());

        cyl2.setHeight(7.0);
        cyl2.setRadius(3.0);
        cyl2.setColor("purple");
        System.out.println("Updated cyl2: " + cyl2.toString());
    }
}
