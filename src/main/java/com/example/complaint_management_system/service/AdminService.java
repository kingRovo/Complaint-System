package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Admin;
import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.model.Employee;
import com.example.complaint_management_system.model.Vendor;
import com.example.complaint_management_system.repository.AdminRepo;
import com.example.complaint_management_system.repository.ComplaintRepo;
import com.example.complaint_management_system.repository.EmployeeRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import javax.transaction.Transactional;
import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepo adminRepo;
    private final EmployeeRepo employeeRepo;
    private final VendorRepo vendorRepo;

    private final ComplaintRepo complaintRepo;


    @Transactional
    public void addAdmin(Admin admin){

        try{
            if (!ObjectUtils.isEmpty(admin)) {
                adminRepo.save(admin);
                log.info("new entry as admin");
            }
        }
        catch (Exception e){

            log.error(e.getMessage());

        }
    }

    @Transactional
    public void addEmployee(Employee employee){

        try{
            if (!ObjectUtils.isEmpty(employee)){
                employeeRepo.save(employee);
                log.info("new employee added");
            }

        }
        catch (Exception e){

            log.error(e.getMessage());

        }
    }


    @Transactional
    public void removeEmployee(Long employee_id){

        try {
            if (!ObjectUtils.isEmpty(employeeRepo.getById(employee_id))){
                employeeRepo.deleteById(employee_id);
                log.info("employee remove at id : "+employee_id);
            }
        }
        catch (Exception e){

            log.error(e.getMessage());

        }
    }


    @Transactional
    public void addVendor(Vendor vendor){

        try{
            if (!ObjectUtils.isEmpty(vendor)){
                vendorRepo.save(vendor);
                log.info("new vendor added ");
        }}
        catch (Exception e){

            log.error(e.getMessage());

        }
    }


    @Transactional
    public void removeVendor(Long vendor_id){

        try {
            if (!ObjectUtils.isEmpty(employeeRepo.getById(vendor_id))){
                employeeRepo.deleteById(vendor_id);
                log.info("vendor removed at Id :"+vendor_id);
            }
        }
        catch (Exception e){

            log.error(e.getMessage());

        }
    }

    public List<Complaint> openComplaint(){

       try{

           return complaintRepo.OpenComplaints("Open");
       }
       catch (Exception exception){

           log.error(exception.getMessage());
           return Collections.emptyList();
       }
    }

    @Transactional
    public String changeStatus(String status,Long complaint_id,String remark){

        try {
            Complaint complaint = complaintRepo.getById(complaint_id);
            complaint.setStatus(status);
            complaint.setRemarks(remark);
            complaintRepo.save(complaint);
            log.info("status changed with special remark");
            return status;
        }
        catch (Exception e){
            log.error(e.getMessage());
            return e.getMessage();
        }
    }


}


