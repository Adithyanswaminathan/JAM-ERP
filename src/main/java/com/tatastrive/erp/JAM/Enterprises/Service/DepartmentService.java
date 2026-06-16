package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Department;


import java.util.List;

public interface DepartmentService
{
    Department createDepartment(Department department);
    List<Department> getAllDepartments();
}
