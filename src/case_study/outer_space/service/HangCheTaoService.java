package case_study.outer_space.service;

import case_study.outer_space.model.HangCheTao;
import case_study.outer_space.repository.HangCheTaoRepository;

import java.util.List;

public class HangCheTaoService {
    private final HangCheTaoRepository repository = new HangCheTaoRepository();

    public boolean existsByTenHang(String tenHang) {
        List<HangCheTao> danhSachHangCheTao = repository.readData();
        for (HangCheTao hangCheTao : danhSachHangCheTao) {
            if (hangCheTao.getTenHang().equalsIgnoreCase(tenHang)) {
                return true;
            }
        }
        return false;
    }

    public void saveIfNew(String maHang, String tenHang, String quocGia) {
        if (!existsByTenHang(tenHang)) {
            HangCheTao hang = new HangCheTao(maHang, tenHang, quocGia);
            repository.appendData(hang);
        }
    }

    public List<HangCheTao> getAll() {
        return repository.readData();
    }
}