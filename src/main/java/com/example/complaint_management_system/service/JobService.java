package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Job;
import com.example.complaint_management_system.model.Vendor;
import com.example.complaint_management_system.repository.JobRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class JobService {

     private final JobRepo jobRepo;

     private final VendorRepo vendorRepo;


    @Transactional
     public void addNewJob(Job job){

         try{
         jobRepo.save(job);
         log.info("new job added to system");
         }
         catch (Exception exception){
             log.error(exception.getMessage());

         }
     }

    @Transactional
     public void assignedJobTo(Long job_id,Long vendor_id){

         Job job = jobRepo.getById(job_id);
         Vendor vendor = vendorRepo.getById(vendor_id);
         if (!job.getIsInternal()){
             job.setAssignedTo(vendor);
             log.info("job assigned to vendor");
             jobRepo.save(job);
         }
     }

     public  Job findjob(Long id){

        try{
            return jobRepo.findById(id).orElseThrow();
        }
        catch (Exception e){
            log.error(e.getMessage());
            return null;
        }

     }
}
