package kiem_tra_module2.model.repository;


import kiem_tra_module2.model.entity.Contact;

import java.util.List;

public interface IContactRepository {
    List<Contact> getAll();

    void saveAll(List<Contact> contactList);

    void add(Contact contact);

    Contact findByPhone(String phone);

    List<Contact> search(String keyword);
}
