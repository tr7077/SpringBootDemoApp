package com.teorerras.spring_boot_demo.service;

import com.teorerras.spring_boot_demo.model.Contact;
import java.util.List;

public interface IContactService {
    Contact addContact(Contact request);
    Contact updateContact(Long id, Contact newContact);
    Contact getContact(Long id);
    void deleteContact(Long id);
    List<Contact> getAllContacts();
}
