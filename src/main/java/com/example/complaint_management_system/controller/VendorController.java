package com.example.complaint_management_system.controller;


import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    @GetMapping("/{id}/jobs")
    ResponseEntity<List<Complaint>> findJobs(@PathVariable("id") Long id){

        try {

            return new ResponseEntity<>(vendorService.findAllComplaint(id),HttpStatus.OK);

        }
        catch (Exception exception){

            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/complaint/{id}")
    ResponseEntity<String> changeStatus(@PathVariable("id") Long id,@RequestParam("status")String status,@RequestHeader("remark") String remark){

        try{
            return new ResponseEntity<>(vendorService.changeStatus(status,id,remark),HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}/openjob")
    ResponseEntity<List<Complaint>> findOpenJobs(@PathVariable("id") Long id){

        try {

            return new ResponseEntity<>(vendorService.allAssignedOpenJobs(id),HttpStatus.OK);

        }
        catch (Exception exception){

            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
