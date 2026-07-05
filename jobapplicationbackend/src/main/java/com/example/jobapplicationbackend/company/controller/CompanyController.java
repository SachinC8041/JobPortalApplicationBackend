package com.example.jobapplicationbackend.company.controller;

import com.example.jobapplicationbackend.company.service.ICompanyService;
import com.example.jobapplicationbackend.dto.CompanyDto;
import com.example.jobapplicationbackend.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController
{

    private final ICompanyService companyService;

    @Autowired
    public CompanyController(ICompanyService companyService)
    {
        this.companyService = companyService;
    }
    @GetMapping(version = "1.0")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        List<CompanyDto> companyList = companyService.getAllCompanies();

        return ResponseEntity.ok().body(companyList);
    }


}
