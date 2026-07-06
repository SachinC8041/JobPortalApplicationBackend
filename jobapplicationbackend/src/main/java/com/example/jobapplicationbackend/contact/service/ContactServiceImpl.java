package com.example.jobapplicationbackend.contact.service;
import com.example.jobapplicationbackend.contact.repository.ContactRepository;
import com.example.jobapplicationbackend.dto.ContactRequestDto;
import com.example.jobapplicationbackend.entity.Contact;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class ContactServiceImpl implements IContactService
{

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl (ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }
    public boolean saveContact(ContactRequestDto contactRequestDto)
    {
        boolean result = false;
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        if (contact != null  && contact.getId()!= null)
        {
            result = true;
        }
        return result;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto)
    {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setStatus("NEW");

        return contact;
    }
}
