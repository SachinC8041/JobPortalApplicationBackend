package com.example.jobapplicationbackend.company.service.impl;

import com.example.jobapplicationbackend.company.repository.CompanyRepository;
import com.example.jobapplicationbackend.company.service.ICompanyService;
import com.example.jobapplicationbackend.dto.CompanyDto;
import com.example.jobapplicationbackend.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDto> getAllCompanies()
    {
        List<Company> companyrepolist = companyRepository.findAll();
        return companyrepolist.stream().map(this::transformToDto).collect(Collectors.toList());
    }

    private CompanyDto transformToDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(),
                company.getIndustry(), company.getSize(), company.getRating(),
                company.getLocations(), company.getFounded(), company.getDescription(),
                company.getEmployees(), company.getWebsite(), company.getCreatedAt());
    }
}
