package case_study.employee_management.Model.Entity;

public class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toCSV() {
        return id + "," + name + "," + position + "," + salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Họ Tên: " + name +
                ", Chức vụ: " + position +
                ", Lương: " + salary;
    }
}
