package quan_ly_phuong_tien.Model.Entity;

public class XeMayEntity extends PhuongTien {
    private int congSuat;

    public XeMayEntity() {
    }

    public XeMayEntity(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMayEntity{" +
                super.toString() +
                ", congSuat=" + congSuat +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return "XEMAY," + getBienKiemSoat() + "," + getHangSanXuat() + "," + getNamSanXuat() + "," +
                getChuSoHuu() + "," + congSuat;
    }
}