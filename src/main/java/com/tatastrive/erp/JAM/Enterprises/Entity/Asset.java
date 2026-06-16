package com.tatastrive.erp.JAM.Enterprises.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String assetName;

        private String assetType;

        @ManyToOne
        @JoinColumn(name = "employee_id")
        private Employee employee;
    }

