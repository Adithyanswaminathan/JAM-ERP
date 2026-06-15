package com.tatastrive.erp.JAM.Enterprises.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@Entity
@Table(name="attendance")
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private LocalDate date;
    private String status;
    private String checkInTime;
    private String checkOutTime;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;




}
