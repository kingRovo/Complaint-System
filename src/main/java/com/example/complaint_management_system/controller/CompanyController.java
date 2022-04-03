package com.example.complaint_management_system.controller;

import com.example.complaint_management_system.model.Company;
import com.example.complaint_management_system.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/company")
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping("/")
    List<Company> displayAll(){

        return companyService.findAllCompany();
    }


}
