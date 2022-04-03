package com.example.complaint_management_system.controller;

import com.example.complaint_management_system.model.Admin;
import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.model.Employee;
import com.example.complaint_management_system.model.Vendor;
import com.example.complaint_management_system.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;


    @PostMapping("/")
    ResponseEntity<?> addAdmin(@RequestBody Admin admin){

        try {
            adminService.addAdmin(admin);
            return new ResponseEntity<>(admin,HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/employee")
    ResponseEntity<?> addEmployee(@RequestBody Employee employee){

        try {
            adminService.addEmployee(employee);
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity<?> removeEmployee(@PathVariable("id") Long id){

        try {

            adminService.removeEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/vendor")
    ResponseEntity<?> addVendor(@RequestBody Vendor vendor){

        try {
            adminService.addVendor(vendor);
            return new ResponseEntity<>(vendor,HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/vendor/{id}")
    ResponseEntity<?> removeVendor(@PathVariable("id") Long id){

        try {

            adminService.removeVendor(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/complaint")
    ResponseEntity<List<Complaint>> openComplaint(){

        try {
            return new ResponseEntity<>(adminService.openComplaint(),HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/complaint/{id}")
    ResponseEntity<String> changeStatus(@PathVariable("id") Long id,@RequestParam("status")String status,@RequestHeader("remark") String remark){

        try{
            return new ResponseEntity<>(adminService.changeStatus(status,id,remark),HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
