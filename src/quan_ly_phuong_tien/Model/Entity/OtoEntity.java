package quan_ly_phuong_tien.Model.Entity;

public class OtoEntity extends PhuongTien {
    private String kieuXe;
    private int soChoNgoi;

    public OtoEntity() {
    }

    public OtoEntity(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, String kieuXe, int soChoNgoi) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.kieuXe = kieuXe;
        this.soChoNgoi = soChoNgoi;
    }

    @Override
    public String toString() {
        return "OtoEntity{" +
                super.toString() +
                "kieuXe='" + kieuXe + '\'' +
                ", soChoNgoi=" + soChoNgoi +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return "";
    }
}
