package quan_ly_phuong_tien.model.entity;

public class XeTai extends PhuongTien {
    private double trongTai;

    public XeTai(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    @Override
    public void hienThiThongTin() {
        System.out.printf("Xe Tải: %s - %s - %d - %s - %.1f tấn\n", bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, trongTai);
    }
}
