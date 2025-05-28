package ss6_ke_thua_inheritance.point_va_moveablepoint;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println("Point mặc định: " + p1);

        Point p2 = new Point(5.5f, 7.5f);
        System.out.println("Point với tọa độ: " + p2);

        p2.setXY(8.0f, 9.0f);
        System.out.println("Point cập nhật tọa độ: " + p2);

        MoveablePoint mp1 = new MoveablePoint();
        System.out.println("MovablePoint mặc định: " + mp1);

        MoveablePoint mp2 = new MoveablePoint(3.0f, 4.0f);
        System.out.println("MovablePoint chỉ tốc độ: " + mp2);

        MoveablePoint mp3 = new MoveablePoint(1.0f, 2.0f, 0.5f, 0.5f);
        System.out.println("MovablePoint đầy đủ thông tin: " + mp3);

        mp3.move();
        System.out.println("Sau khi di chuyển: " + mp3);
    }

}
