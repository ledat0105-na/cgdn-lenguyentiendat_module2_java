package ss4_lop_va_doi_tuong.Fan;

public class OnlyFan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public OnlyFan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed == SLOW || speed == MEDIUM || speed == FAST) {
            this.speed = speed;
        }
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }

    @Override
    public String toString() {
        if (on) {
            return "OnlyFan is on: speed = " + speed + ", color = " + color + ", radius = " + radius;
        } else {
            return "OnlyFan is off: color = " + color + ", radius = " + radius;
        }
    }
}

