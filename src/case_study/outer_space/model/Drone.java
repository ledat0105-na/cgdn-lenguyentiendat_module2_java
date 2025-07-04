package case_study.outer_space.model;

public class Drone extends PhuongTien {
    private int tamBay;

    public Drone(String soHieu, String hangCheTao, int namSanXuat, String nguoiDieuPhoi, int tamBay) {
        super(soHieu, hangCheTao, namSanXuat, nguoiDieuPhoi);
        this.tamBay = tamBay;
    }

    public int getTamBay() {
        return tamBay;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + tamBay;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tầm bay: " + tamBay + "km";
    }
}
