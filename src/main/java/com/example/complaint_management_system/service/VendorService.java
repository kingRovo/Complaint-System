package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.repository.ComplaintRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class VendorService {

    private final VendorRepo vendorRepo;
    private final ComplaintRepo complaintRepo;
    public List<Complaint> findAllComplaint(Long vendor_id){

        try {
            if (!ObjectUtils.isEmpty(vendorRepo.findById(vendor_id))){


                return complaintRepo.findComplaint(vendor_id);
            }
            else return Collections.emptyList();
        }
        catch (Exception e){
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public String changeStatus(String status,Long complaint_id,String remark){

        try {
            Complaint complaint = complaintRepo.getById(complaint_id);
            complaint.setStatus(status);
            complaint.setRemarks(remark);
            complaintRepo.save(complaint);
            log.info("status changed as :"+status);
            return status;
        }
        catch (Exception e){
            log.error(e.getMessage());
            return e.getMessage();
        }
    }
    public List<Complaint> allAssignedOpenJobs(Long vendor_id){

        try{
            return complaintRepo.findOpenComplaint(vendor_id,"Open");

        }
        catch (Exception e){

            return Collections.emptyList();
        }
    }

}
