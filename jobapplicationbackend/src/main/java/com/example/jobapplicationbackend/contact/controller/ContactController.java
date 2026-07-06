package com.example.jobapplicationbackend.contact.controller;

import com.example.jobapplicationbackend.contact.service.IContactService;
import com.example.jobapplicationbackend.dto.ContactRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final IContactService contactService;
    private final BeanFactoryPostProcessor bootstrapExecutorAliasPostProcessor;

    @Autowired
    public ContactController(IContactService contactService, BeanFactoryPostProcessor bootstrapExecutorAliasPostProcessor)
    {
        this.contactService = contactService;
        this.bootstrapExecutorAliasPostProcessor = bootstrapExecutorAliasPostProcessor;
    }

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMessage(@RequestBody ContactRequestDto contactRequestDto)
    {
        boolean isSaved = contactService.saveContact(contactRequestDto);
        if (isSaved)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Contact could not be saved");
        }

    }
}
