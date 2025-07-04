package case_study.outer_space.model;

public abstract class PhuongTien {
    private String soHieu;
    private String hangCheTao;
    private int namSanXuat;
    private String nguoiDieuPhoi;

    public PhuongTien() {
    }

    public PhuongTien(String soHieu, String hangCheTao, int namSanXuat, String nguoiDieuPhoi) {
        this.soHieu = soHieu;
        this.hangCheTao = hangCheTao;
        this.namSanXuat = namSanXuat;
        this.nguoiDieuPhoi = nguoiDieuPhoi;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public String getHangCheTao() {
        return hangCheTao;
    }

    public void setHangCheTao(String hangCheTao) {
        this.hangCheTao = hangCheTao;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getNguoiDieuPhoi() {
        return nguoiDieuPhoi;
    }

    public void setNguoiDieuPhoi(String nguoiDieuPhoi) {
        this.nguoiDieuPhoi = nguoiDieuPhoi;
    }

    public String toCSV() {
        return soHieu + "," + hangCheTao + "," + namSanXuat + "," + nguoiDieuPhoi;
    }

    public String toString() {
        return "Số hiệu: " + soHieu +
                ", Hãng chế tạo: " + hangCheTao +
                ", Năm sản xuất: " + namSanXuat +
                ", Người điều phối: " + nguoiDieuPhoi;
    }
}
