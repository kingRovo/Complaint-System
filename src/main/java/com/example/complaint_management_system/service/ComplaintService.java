package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.repository.ComplaintRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ComplaintService {


    private final ComplaintRepo complaintRepo;

    public void addComplaint(Complaint complaint){

        log.info("hello mw mrra");

        complaintRepo.save(complaint);
    }

}
