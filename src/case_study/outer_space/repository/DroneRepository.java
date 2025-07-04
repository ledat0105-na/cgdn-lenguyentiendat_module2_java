package case_study.outer_space.repository;

import case_study.outer_space.util.ReadAndWriteFile;

import java.util.List;

public class DroneRepository implements IVehicleRepository {
    private static final String PATH = "src/case_study/outer_space/data/drone.csv";

    @Override
    public List<String> readData() {
        return ReadAndWriteFile.readFileCSV(PATH);
    }

    @Override
    public void writeData(List<String> data) {
        ReadAndWriteFile.writeListToCSV(PATH, data);
    }

    @Override
    public void appendData(String record) {
        ReadAndWriteFile.writeLineToCSV(PATH, record);
    }
}
