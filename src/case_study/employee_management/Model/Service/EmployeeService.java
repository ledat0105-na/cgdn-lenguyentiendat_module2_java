package case_study.employee_management.Model.Service;

import case_study.employee_management.Model.Entity.Employee;
import case_study.employee_management.Model.Repository.EmployeeRepository;
import case_study.employee_management.Model.Repository.IEmployeeRepository;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository repository = new EmployeeRepository();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void displayAll() {
        List<Employee> list = repository.getAll();
        if (list.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
        } else {
            for (Employee employee : list) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public void add() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Chức vụ: ");
        String position = sc.nextLine();

        System.out.print("Lương: ");
        double salary;
        while (true) {
            try {
                salary = Double.parseDouble(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Lương không hợp lệ. Nhập lại: ");
            }
        }

        List<Employee> list = repository.getAll();
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }

        repository.add(new Employee(id, name, position, salary));
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void edit() {
        System.out.print("Nhập ID cần sửa: ");
        String id = sc.nextLine();
        List<Employee> list = repository.getAll();
        boolean found = false;

        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                System.out.print("Tên mới: ");
                employee.setName(sc.nextLine());
                System.out.print("Chức vụ mới: ");
                employee.setPosition(sc.nextLine());

                System.out.print("Lương mới: ");
                double salary;
                while (true) {
                    try {
                        salary = Double.parseDouble(sc.nextLine().trim());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Lương không hợp lệ. Nhập lại: ");
                    }
                }
                employee.setSalary(salary);
                found = true;
                break;
            }
        }

        if (found) {
            repository.saveAll(list);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy ID!");
        }
    }

    @Override
    public void delete() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();
        List<Employee> list = repository.getAll();

        boolean removed = list.removeIf(employee -> employee.getId().equalsIgnoreCase(id));

        if (removed) {
            repository.saveAll(list);
            System.out.println("Đã xóa.");
        } else {
            System.out.println("Không tìm thấy ID.");
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập ID hoặc tên cần tìm: ");
        String keyword = sc.nextLine().toLowerCase().trim();
        List<Employee> list = repository.getAll();
        boolean found = false;

        for (Employee employee : list) {
            String idLower = employee.getId().toLowerCase().trim();
            String nameLower = employee.getName().toLowerCase().trim();

            if (idLower.contains(keyword) || nameLower.contains(keyword)) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả!");
        }
    }
}
