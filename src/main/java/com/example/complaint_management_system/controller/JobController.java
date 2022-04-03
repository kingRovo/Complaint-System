package com.example.complaint_management_system.controller;

import com.example.complaint_management_system.model.Job;
import com.example.complaint_management_system.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/jobs")
public class JobController {

    private final JobService jobService;


    @PostMapping("/")
    ResponseEntity<?> addJob(@Valid @RequestBody Job job){

        try{
            jobService.addNewJob(job);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/{id}/vendor/{vendor_id}")
    ResponseEntity<?> assignedJobTo(@PathVariable("id")Long job_id,@PathVariable("vendor_id") Long vendor_id){

        try{
            jobService.assignedJobTo(job_id,vendor_id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
