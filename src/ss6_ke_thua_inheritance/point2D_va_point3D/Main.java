package ss6_ke_thua_inheritance.point2D_va_point3D;

public class Main {
    public static void main(String[] args) {
        Point2D p2d1 = new Point2D();
        System.out.println("Point2D mặc định: " + p2d1);

        Point2D p2d2 = new Point2D(2.5f, 3.5f);
        System.out.println("Point2D với tọa độ: " + p2d2);

        p2d2.setXY(4.0f, 5.0f);
        System.out.println("Point2D cập nhật tọa độ: " + p2d2);

        Point3D p3d1 = new Point3D();
        System.out.println("Point3D mặc định: " + p3d1);

        Point3D p3d2 = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Point3D với tọa độ: " + p3d2);

        p3d2.setXYZ(7.0f, 8.0f, 9.0f);
        System.out.println("Point3D cập nhật tọa độ: " + p3d2);
    }
}

