package quan_ly_phuong_tien.model.entity;

public abstract class PhuongTien {
    protected String bienKiemSoat;
    protected String hangSanXuat;
    protected int namSanXuat;
    protected String chuSoHuu;

    public PhuongTien(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public abstract void hienThiThongTin();
}

