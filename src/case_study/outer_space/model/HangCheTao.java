package case_study.outer_space.model;

public class HangCheTao {
    private String maHang;
    private String tenHang;
    private String quocGia;

    public HangCheTao(String maHang, String tenHang, String quocGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.quocGia = quocGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getQuocGia() {
        return quocGia;
    }

    @Override
    public String toString() {
        return maHang + "," + tenHang + "," + quocGia;
    }
}
