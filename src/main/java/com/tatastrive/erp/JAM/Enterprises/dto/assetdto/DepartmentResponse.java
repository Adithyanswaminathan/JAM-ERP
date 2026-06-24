package com.tatastrive.erp.JAM.Enterprises.dto.assetdto;

import com.tatastrive.erp.JAM.Enterprises.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse
{
    private Long id;
    private String departmentName;
    private List<EmployeeDepResponse> employees;
}
