package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.repository.ComplaintRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
@AllArgsConstructor
public class VendorService {

    private final VendorRepo vendorRepo;
    private final ComplaintRepo complaintRepo;
    public List<Complaint> findAllComplaint(Long vendor_id){

        try {
            if (!ObjectUtils.isEmpty(vendorRepo.findById(vendor_id)))
            return complaintRepo.findComplaint(vendor_id);
            else return null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

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
    public List<Complaint> allAssignedOpenJobs(Long vendor_id){

        return complaintRepo.findOpenComplaint(vendor_id,"Open");
    }

}
