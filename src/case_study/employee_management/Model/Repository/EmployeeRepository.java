package case_study.employee_management.Model.Repository;

import case_study.employee_management.Model.Entity.Employee;
import case_study.employee_management.Util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FILE_PATH = "src/case_study/employee_management/Data/employee.csv";

    @Override
    public List<Employee> getAll() {
        List<String> lines = ReadAndWriteFile.readFileCSV(FILE_PATH);
        List<Employee> employees = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");

            if (parts.length == 4) {
                try {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String position = parts[2].trim();
                    double salary = Double.parseDouble(parts[3].trim());

                    employees.add(new Employee(id, name, position, salary));
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi định dạng lương ở dòng: " + line);
                }
            } else {
                System.out.println("Dòng sai định dạng CSV: " + line);
            }
        }

        return employees;
    }

    @Override
    public void saveAll(List<Employee> employeeList) {
        List<String> lines = new ArrayList<>();
        for (Employee e : employeeList) {
            lines.add(e.toCSV());
        }
        ReadAndWriteFile.writeListToCSV(FILE_PATH, lines, false);
    }

    @Override
    public void add(Employee employee) {
        List<String> line = new ArrayList<>();
        line.add(employee.toCSV());
        ReadAndWriteFile.writeListToCSV(FILE_PATH, line, true);
    }
}
