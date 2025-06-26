package quan_ly_phuong_tien.Model.Entity;

public class XeTaiEntity extends PhuongTien {
    private double trongTai;

    public XeTaiEntity(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    @Override
    public String toString() {
        return "XeTai: BKS: " + getBienKiemSoat() +
                ", Hãng Sx " + getHangSanXuat() +
                ", Năm Sx " + getNamSanXuat() +
                ", Chủ sở hữu " + getChuSoHuu() +
                ", Trọng tải: " + trongTai;
    }

    @Override
    public String getInfoToCSV() {
        return getBienKiemSoat() +
                "," + getHangSanXuat() +
                "," + getNamSanXuat() +
                "," + getChuSoHuu() +
                "," + trongTai;
    }
}