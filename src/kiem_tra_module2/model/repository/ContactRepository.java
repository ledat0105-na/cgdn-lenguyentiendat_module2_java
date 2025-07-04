package kiem_tra_module2.model.repository;

import kiem_tra_module2.model.entity.Contact;
import kiem_tra_module2.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository implements IContactRepository {
    private static final String FILE_PATH = "src/kiem_tra_module2/data/contact.csv";

    @Override
    public List<Contact> getAll() {
        List<String> lines = ReadAndWriteFile.readFileCSV(FILE_PATH);
        List<Contact> contactList = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");

            if (parts.length == 7) {
                String phone = parts[0].trim();
                String group = parts[1].trim();
                String fullname = parts[2].trim();
                String gender = parts[3].trim();
                String address = parts[4].trim();
                String birthday = parts[5].trim();
                String email = parts[6].trim();

                Contact contact = new Contact(phone, group, fullname, gender, address, birthday, email);
                contactList.add(contact);
            } else {
                System.out.println("Dòng sai định dạng CSV: " + line);
            }
        }

        return contactList;
    }

    @Override
    public void saveAll(List<Contact> contactList) {
        List<String> lines = new ArrayList<>();
        for (Contact contact : contactList) {
            lines.add(contact.toCSV());
        }
        ReadAndWriteFile.writeListToCSV(FILE_PATH, lines, false);
    }

    @Override
    public void add(Contact contact) {
        List<String> line = new ArrayList<>();
        line.add(contact.toCSV());
        ReadAndWriteFile.writeListToCSV(FILE_PATH, line, true);
    }

    @Override
    public Contact findByPhone(String phone) {
        List<Contact> list = getAll();
        for (Contact contact : list) {
            if (contact.getPhone().equalsIgnoreCase(phone)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> search(String keyword) {
        List<Contact> result = new ArrayList<>();
        List<Contact> list = getAll();
        String lowerKeyword = keyword.toLowerCase();

        for (Contact contact : list) {
            if (contact.getPhone().toLowerCase().contains(lowerKeyword) ||
                    contact.getFullname().toLowerCase().contains(lowerKeyword)) {
                result.add(contact);
            }
        }

        return result;
    }
}