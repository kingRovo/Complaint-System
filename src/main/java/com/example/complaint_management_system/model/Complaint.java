package com.example.complaint_management_system.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String status;

    private String subject;


    private String description;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee createdBy;



    private Date createdAt;

    private String remarks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "handle_by_id", referencedColumnName = "id")
    private Vendor handledBy;



    private Integer reOpened;
}
