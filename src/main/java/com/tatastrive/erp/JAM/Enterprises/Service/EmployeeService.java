package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Employee;
import com.tatastrive.erp.JAM.Enterprises.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

     EmployeeDTO createEmployee(Employee employee);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
