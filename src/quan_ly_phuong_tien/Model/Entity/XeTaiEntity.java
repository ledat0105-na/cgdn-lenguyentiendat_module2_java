package quan_ly_phuong_tien.Model.Entity;

public class XeTaiEntity extends PhuongTien {
    private double trongTai;

    public XeTaiEntity() {
    }

    public XeTaiEntity(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTaiEntity{" +
                super.toString() +
                ", trongTai=" + trongTai +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return "XETAI," + getBienKiemSoat() + "," + getHangSanXuat() + "," +
                getNamSanXuat() + "," + getChuSoHuu() + "," + trongTai;
    }
}
