package quan_ly_phuong_tien.Model.Entity;

public class XeMayEntity extends PhuongTien {
    private int congSuat;

    public XeMayEntity(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    @Override
    public String toString() {
        return "XeMay: BKS: " + getBienKiemSoat() +
                ", Hãng Sx: " + getHangSanXuat() +
                ", Năm Sx: " + getNamSanXuat() +
                ", Chủ sở hữu " + getChuSoHuu() +
                ", Công suất: " + congSuat;
    }

    @Override
    public String getInfoToCSV() {
        return getBienKiemSoat() +
                "," + getHangSanXuat() +
                "," + getNamSanXuat() +
                "," + getChuSoHuu() +
                "," + congSuat;
    }
}