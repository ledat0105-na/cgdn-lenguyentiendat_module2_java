package case_study.outer_space.repository;

import java.util.List;

public interface IVehicleRepository {
    List<String> readData();
    void writeData(List<String> data);
    void appendData(String record);
}
