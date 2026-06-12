package com.tatastrive.erp.JAM.Enterprises.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    private String designation;

    private Double salary;

    private LocalDate joiningDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Constructors
    public Employee() {}

    // Getters and Setters
}