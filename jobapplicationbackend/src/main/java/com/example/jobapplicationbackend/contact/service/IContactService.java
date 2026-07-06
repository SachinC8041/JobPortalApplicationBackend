package com.example.jobapplicationbackend.contact.service;

import com.example.jobapplicationbackend.dto.ContactRequestDto;


public interface IContactService
{
    boolean saveContact(ContactRequestDto contactRequestDto);
}
