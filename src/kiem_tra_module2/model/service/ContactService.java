package kiem_tra_module2.model.service;

import kiem_tra_module2.model.entity.Contact;
import kiem_tra_module2.model.repository.ContactRepository;
import kiem_tra_module2.model.repository.IContactRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ContactService implements IContactService {
    private final IContactRepository repository = new ContactRepository();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void displayAll() {
        List<Contact> list = repository.getAll();
        if (list.isEmpty()) {
            System.out.println("Danh bạ trống!");
        } else {
            for (Contact contact : list) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void add() {
        System.out.println("Thêm mới");
        String phone;
        while (true) {
            System.out.print("Số điện thoại: ");
            phone = sc.nextLine().trim();
            if (phone.matches("^0\\d{9}$")) break;
            System.out.println("Sai định dạng! Số điện thoại phải có 10 chữ số và bắt đầu bằng 0.");
        }

        List<Contact> list = repository.getAll();
        for (Contact contact : list) {
            if (contact.getPhone().equalsIgnoreCase(phone)) {
                System.out.println("Số điện thoại đã tồn tại trong danh bạ!");
                return;
            }
        }

        System.out.print("Nhóm: ");
        String group = sc.nextLine();
        System.out.print("Họ tên: ");
        String fullname = sc.nextLine();
        String gender;
        while (true) {
            System.out.print("Giới tính: ");
            gender = sc.nextLine().trim();
            if (gender.matches("^(?i)(nam|nữ)$")) break;
            System.out.println("Sai định dạng! Giới tính chỉ có nam hoặc nữ.");
        }
        System.out.print("Địa chỉ: ");
        String address = sc.nextLine();
        System.out.print("Ngày sinh: ");
        String birthday = sc.nextLine();

        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine().trim();
            if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) break;
            System.out.println("Sai định dạng! Ví dụ đúng: abc@gmail.com");
        }

        Contact newContact = new Contact(phone, group, fullname, gender, address, birthday, email);
        repository.add(newContact);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void edit() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String phoneToEdit = sc.nextLine().trim();
        List<Contact> list = repository.getAll();
        boolean found = false;

        for (Contact contact : list) {
            if (contact.getPhone().equalsIgnoreCase(phoneToEdit)) {
                System.out.print("Nhóm mới: ");
                contact.setGroup(sc.nextLine());
                System.out.print("Họ tên mới: ");
                contact.setFullname(sc.nextLine());
                String genderNew;
                while (true) {
                    System.out.print("Giới tính: ");
                    genderNew = sc.nextLine().trim();
                    if (genderNew.matches("^(?i)(nam|nữ)$")) break;
                    System.out.println("Sai định dạng! Giới tính chỉ có nam hoặc nữ.");
                }
                System.out.print("Địa chỉ mới: ");
                contact.setAddress(sc.nextLine());
                System.out.print("Ngày sinh mới: ");
                contact.setBirthday(sc.nextLine());

                String newEmail;
                while (true) {
                    System.out.print("Email mới: ");
                    newEmail = sc.nextLine().trim();
                    if (newEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) break;
                    System.out.println("Sai định dạng email!");
                }
                contact.setEmail(newEmail);

                found = true;
                break;
            }
        }

        if (found) {
            repository.saveAll(list);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy số điện thoại cần sửa!");
        }
    }

    @Override
    public void delete() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String phoneToDelete = sc.nextLine().trim();
        List<Contact> list = repository.getAll();

        boolean removed = false;

        Iterator<Contact> iterator = list.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getPhone().equalsIgnoreCase(phoneToDelete)) {
                iterator.remove();
                removed = true;
            }
        }

        if (removed) {
            repository.saveAll(list);
            System.out.println("Đã xóa liên hệ thành công.");
        } else {
            System.out.println("Không tìm thấy số điện thoại cần xóa.");
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập số điện thoại hoặc tên để tìm kiếm: ");
        String keyword = sc.nextLine().toLowerCase().trim();
        List<Contact> resultList = repository.search(keyword);

        if (resultList.isEmpty()) {
            System.out.println("Không tìm thấy kết quả phù hợp.");
        } else {
            for (Contact contact : resultList) {
                System.out.println(contact);
            }
        }
    }
}
