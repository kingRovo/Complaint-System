package com.example.complaint_management_system.controller;

import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/{emp_id}/job/{job_id}/complaint")
    ResponseEntity<?> raiseComplaint(@RequestBody Complaint complaint, @PathVariable("emp_id") Long emp_id,@PathVariable("job_id") Long job_id){

        try {
            employeeService.raiseComplaint(complaint,emp_id,job_id);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception exception){

            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/complaint")
    ResponseEntity<List<Complaint>> findJobsComplaint(@PathVariable("id") Long id){

        try {

            return new ResponseEntity<>(employeeService.findJobsComplaint(id),HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity(e.getStackTrace(),HttpStatus.BAD_REQUEST);
        }
    }
}
