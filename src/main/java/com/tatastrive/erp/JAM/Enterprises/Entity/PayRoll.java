package com.tatastrive.erp.JAM.Enterprises.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class PayRoll
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double basicSalary;
    private Double bonus;
    private Double deduction;
    private Double netSalary;
    private String month;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

}
