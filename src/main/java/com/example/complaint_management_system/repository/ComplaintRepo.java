package com.example.complaint_management_system.repository;

import com.example.complaint_management_system.model.Complaint;
import com.example.complaint_management_system.model.Employee;
import com.example.complaint_management_system.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint,Long> {

    @Query(value = "SELECT * FROM Complaint c WHERE c.employee_id = ?1",nativeQuery = true)
    List<Complaint> allRaisedComplaints(Long employee_id);

    @Query(value = "SELECT * FROM Complaint c WHERE c.status = ?1",nativeQuery = true)
    List<Complaint> OpenComplaints(String status);

    @Query(value = "SELECT * FROM Complaint c WHERE c.handle_by_id = ?1",nativeQuery = true)
    List<Complaint> findComplaint(Long vendor_id);


    @Query(value = "SELECT * FROM Complaint c WHERE c.handle_by_id = ?1 AND c.status = ?2",nativeQuery = true)
    List<Complaint> findOpenComplaint(Long vendor_id,String status);
}
