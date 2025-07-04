package case_study.outer_space.model;

public class XeTuanTra extends PhuongTien {
    private int capChongBucXa;

    public XeTuanTra(String soHieu, String hangCheTao, int namSanXuat, String nguoiDieuPhoi, int capChongBucXa) {
        super(soHieu, hangCheTao, namSanXuat, nguoiDieuPhoi);
        this.capChongBucXa = capChongBucXa;
    }

    public int getCapChongBucXa() {
        return capChongBucXa;
    }

    public void setCapChongBucXa(int capChongBucXa) {
        this.capChongBucXa = capChongBucXa;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ",Cấp " + capChongBucXa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chống bức xạ: Cấp " + capChongBucXa;
    }

}
