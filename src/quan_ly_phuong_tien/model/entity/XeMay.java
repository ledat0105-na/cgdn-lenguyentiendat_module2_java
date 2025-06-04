package quan_ly_phuong_tien.model.entity;

public class XeMay extends PhuongTien {
    private int congSuat;

    public XeMay(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    @Override
    public void hienThiThongTin() {
        System.out.printf("Xe Máy: %s - %s - %d - %s - %d cc\n", bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, congSuat);
    }
}
