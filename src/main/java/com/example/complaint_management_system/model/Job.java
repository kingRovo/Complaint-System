package com.example.complaint_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Boolean isInternal;


    private  String description;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private Vendor assignedTo;



}
