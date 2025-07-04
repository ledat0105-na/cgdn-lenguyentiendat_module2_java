package case_study.employee_management.Model.Repository;

import case_study.employee_management.Model.Entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAll();

    void saveAll(List<Employee> employeeList);

    void add(Employee employee);
}
