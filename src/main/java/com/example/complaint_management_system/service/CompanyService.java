package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Company;
import com.example.complaint_management_system.repository.CompanyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepo companyRepo;


    public List<Company> findAllCompany(){

        return companyRepo.findAll();
    }


}
