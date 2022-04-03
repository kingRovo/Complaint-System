package com.example.complaint_management_system.service;

import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.model.Employee;
import com.example.complaint_management_system.model.Job;
import com.example.complaint_management_system.model.Vendor;
import com.example.complaint_management_system.repository.ComplaintRepo;
import com.example.complaint_management_system.repository.EmployeeRepo;
import com.example.complaint_management_system.repository.JobRepo;
import com.example.complaint_management_system.repository.VendorRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ComplaintRepo complaintRepo;
    private final JobService jobService;
    private final VendorRepo vendorRepo;
    private final ComplaintService complaintService;



    public ResponseEntity<?> raiseComplaint(Complaint complaint, Long employeeId,Long job_id){

        try {
            Calendar cal = Calendar.getInstance();

            Employee employee = findEmployee(employeeId);
            Job job = jobService.findjob(job_id);
            log.info("After job service+++++++++++");
            complaint.setHandledBy(job.getAssignedTo());
            log.info("After handleed +++++++++++");
            complaint.setStatus("Open");
            complaint.setCreatedBy(employee);
            complaint.setCreatedAt(cal.getTime());
            log.info("After all +++++++++++");

            complaintService.addComplaint(complaint);
            log.info("After save +++++++++++");

            return new ResponseEntity<>(complaint.getId(), HttpStatus.CREATED);

        }
        catch (Exception exception){

            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }


    @Transactional
    public List<Complaint> findJobsComplaint(Long id){


        try{

            return complaintRepo.allRaisedComplaints(id);
        }
        catch (Exception exception){

            System.out.println(exception.getMessage());
            return null;
        }
    }


    public Employee findEmployee(Long id){

        return employeeRepo.findById(id).orElseThrow();
    }



}
