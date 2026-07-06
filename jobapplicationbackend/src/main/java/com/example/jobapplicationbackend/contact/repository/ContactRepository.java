package com.example.jobapplicationbackend.contact.repository;

import com.example.jobapplicationbackend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long>{
}
