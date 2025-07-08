package com.teorerras.spring_boot_demo.repository;

import com.teorerras.spring_boot_demo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
