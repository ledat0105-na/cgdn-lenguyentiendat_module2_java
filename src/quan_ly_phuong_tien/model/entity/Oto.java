package quan_ly_phuong_tien.model.entity;

public class Oto extends PhuongTien {
    private String kieuXe;
    private int soChoNgoi;

    public Oto(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, String kieuXe, int soChoNgoi) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.kieuXe = kieuXe;
        this.soChoNgoi = soChoNgoi;
    }

    @Override
    public void hienThiThongTin() {
        System.out.printf("Ôtô: %s - %s - %d - %s - %s - %d chỗ\n", bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, kieuXe, soChoNgoi);
    }
}
