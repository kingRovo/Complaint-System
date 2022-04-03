package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Admin;
import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.model.Employee;
import com.example.complaint_management_system.model.Vendor;
import com.example.complaint_management_system.repository.AdminRepo;
import com.example.complaint_management_system.repository.ComplaintRepo;
import com.example.complaint_management_system.repository.EmployeeRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;
    private final EmployeeRepo employeeRepo;
    private final VendorRepo vendorRepo;

    private final ComplaintRepo complaintRepo;


    @Transactional
    public void addAdmin(Admin admin){

        try{
            if (!ObjectUtils.isEmpty(admin))
                adminRepo.save(admin);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }

    @Transactional
    public void addEmployee(Employee employee){

        try{
            if (!ObjectUtils.isEmpty(employee))
            employeeRepo.save(employee);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }


    @Transactional
    public void removeEmployee(Long employee_id){

        try {
            if (!ObjectUtils.isEmpty(employeeRepo.getById(employee_id))){
                employeeRepo.deleteById(employee_id);
            }
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }


    @Transactional
    public void addVendor(Vendor vendor){

        try{
            if (!ObjectUtils.isEmpty(vendor))
                vendorRepo.save(vendor);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }


    @Transactional
    public void removeVendor(Long vendor_id){

        try {
            if (!ObjectUtils.isEmpty(employeeRepo.getById(vendor_id))){
                employeeRepo.deleteById(vendor_id);
            }
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }

    public List<Complaint> openComplaint(){

       try{
           return complaintRepo.OpenComplaints("Open");
       }
       catch (Exception exception){

           System.out.println(exception.getMessage());
           return null;
       }
    }

    @Transactional
    public String changeStatus(String status,Long complaint_id,String remark){

        try {
            Complaint complaint = complaintRepo.getById(complaint_id);
            complaint.setStatus(status);
            complaint.setRemarks(remark);
            complaintRepo.save(complaint);
            return status;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }


}


