package com.example.jobapplicationbackend.company.service;

import com.example.jobapplicationbackend.dto.CompanyDto;
import com.example.jobapplicationbackend.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<CompanyDto> getAllCompanies();

}
