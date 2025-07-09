package com.teorerras.spring_boot_demo.controller;

import com.teorerras.spring_boot_demo.model.Contact;
import com.teorerras.spring_boot_demo.service.ContactService;
import com.teorerras.spring_boot_demo.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.getContact(id));
    }

    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.addContact(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok("Contact deleted.");
    }
}
