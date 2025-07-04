package case_study.outer_space.repository;

import case_study.outer_space.model.HangCheTao;
import case_study.outer_space.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class HangCheTaoRepository {
    private static final String PATH = "src/case_study/outer_space/data/hangCheTao.csv";

    public List<HangCheTao> readData() {
        List<String> lines = ReadAndWriteFile.readFileCSV(PATH);
        List<HangCheTao> list = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                list.add(new HangCheTao(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        }
        return list;
    }

    public void writeData(List<HangCheTao> data) {
        List<String> lines = new ArrayList<>();
        for (HangCheTao hang : data) {
            lines.add(hang.toString());
        }
        ReadAndWriteFile.writeListToCSV(PATH, lines);
    }

    public void appendData(HangCheTao hang) {
        ReadAndWriteFile.writeLineToCSV(PATH, hang.toString());
    }
}