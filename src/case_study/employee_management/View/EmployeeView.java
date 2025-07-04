package case_study.employee_management.View;

import case_study.employee_management.Controller.MainController;

public class EmployeeView {
    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.showMenu();
    }
}
