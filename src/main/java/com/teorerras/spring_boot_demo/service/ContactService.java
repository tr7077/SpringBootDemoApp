package com.teorerras.spring_boot_demo.service;

import com.teorerras.spring_boot_demo.model.Address;
import com.teorerras.spring_boot_demo.model.Contact;
import com.teorerras.spring_boot_demo.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService implements IContactService{
    private final ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact request) {
        return contactRepository.save(request);
    }

    @Override
    public Contact updateContact(Long id, Contact newContact) {
        return contactRepository.findById(id).map(existingContact -> {
            update(existingContact, newContact);
            return contactRepository.save(existingContact);
        }).orElse(null);
    }

    private void update(Contact existingContact, Contact newContact) {
        existingContact.setFirstName(newContact.getFirstName());
        existingContact.setLastName(newContact.getLastName());
        Address oldAddress = existingContact.getAddress();
        Address newAddress = newContact.getAddress();
        if (newAddress != null) {
            if (oldAddress != null) {
                oldAddress.setAddress(newAddress.getAddress());
                oldAddress.setCity(newAddress.getCity());
                oldAddress.setState(newAddress.getState());
                oldAddress.setCountry(newAddress.getCountry());
                oldAddress.setPostalCode(newAddress.getPostalCode());
            }
            else {
                existingContact.setAddress(newAddress);
            }
        }
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.findById(id).ifPresentOrElse(contactRepository::delete, () -> {
            throw new EntityNotFoundException("No contact found!");
        });
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
