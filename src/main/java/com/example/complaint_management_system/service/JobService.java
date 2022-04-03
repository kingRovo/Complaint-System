package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Job;
import com.example.complaint_management_system.model.Vendor;
import com.example.complaint_management_system.repository.JobRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class JobService {

     private final JobRepo jobRepo;

     private final VendorRepo vendorRepo;


    @Transactional
     public void addNewJob(Job job){

         try{
         jobRepo.save(job);
         }
         catch (Exception exception){
             System.out.println(exception.getMessage());
         }
     }

    @Transactional
     public void assignedJobTo(Long job_id,Long vendor_id){

         Job job = jobRepo.getById(job_id);
         Vendor vendor = vendorRepo.getById(vendor_id);
         if (!job.getIsInternal()){
             job.setAssignedTo(vendor);
             jobRepo.save(job);
         }
     }

     public  Job findjob(Long id){

        return jobRepo.findById(id).orElseThrow();
     }
}
