package ss4_lop_va_doi_tuong.Fan;

public class Main {
    public static void main(String[] args) {
        // Fan 1: speed lớn nhất, radius 10, color yellow, quạt bật
        OnlyFan fan1 = new OnlyFan();
        fan1.setSpeed(OnlyFan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        OnlyFan fan2 = new OnlyFan();
        fan2.setSpeed(OnlyFan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}

