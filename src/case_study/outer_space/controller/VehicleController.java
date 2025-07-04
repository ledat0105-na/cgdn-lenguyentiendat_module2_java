package case_study.outer_space.controller;

import case_study.outer_space.service.DroneService;
import case_study.outer_space.service.IVehicleService;
import case_study.outer_space.service.XeTuanTraService;

public class VehicleController {
    private final IVehicleService droneService = new DroneService();
    private final IVehicleService xeService = new XeTuanTraService();

    public void add(int choice) {
        if (choice == 1) {
            droneService.add();
        } else if (choice == 2) {
            xeService.add();
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void display(int choice) {
        if (choice == 1) {
            droneService.display();
        } else if (choice == 2) {
            xeService.display();
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void search(String keyword) {
        droneService.search(keyword);
        xeService.search(keyword);
    }

    public void delete(String soHieu) {
        if (soHieu.startsWith("DRN")) {
            droneService.delete(soHieu);
        } else if (soHieu.startsWith("XTT")) {
            xeService.delete(soHieu);
        } else {
            System.out.println("Số hiệu không hợp lệ (phải bắt đầu bằng DRN hoặc XTT)");
        }
    }
}