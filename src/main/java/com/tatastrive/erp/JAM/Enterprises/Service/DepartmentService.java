package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Employee;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.DepartmentRequest;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.DepartmentResponse;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.EmployeeDepResponse;


import java.util.List;

public interface DepartmentService
{
    DepartmentResponse createDepartment(DepartmentRequest departmentRequest);
    List<DepartmentResponse> getAllDepartments();
    List<EmployeeDepResponse> getEmployeesByDepartmentId(Long id);

}
