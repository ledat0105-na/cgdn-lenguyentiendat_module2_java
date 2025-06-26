package quan_ly_phuong_tien.Model.Entity;

public class OtoEntity extends PhuongTien {
    private String loaiXe;
    private int soChoNgoi;

    public OtoEntity(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, String loaiXe, int soChoNgoi) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.loaiXe = loaiXe;
        this.soChoNgoi = soChoNgoi;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    @Override
    public String toString() {
        return "Oto: BKS: " + getBienKiemSoat() +
                ", Hãng Sx: " + getHangSanXuat() +
                ", Năm Sx: " + getNamSanXuat() +
                ", Chủ sở hữu: " + getChuSoHuu() +
                ", Loại xe: " + loaiXe +
                ", Số chỗ: " + soChoNgoi;
    }

    @Override
    public String getInfoToCSV() {
        return getBienKiemSoat() +
                "," + getHangSanXuat() +
                "," + getNamSanXuat() +
                "," + getChuSoHuu() +
                "," + loaiXe + "," +
                soChoNgoi;
    }
}
