package com.tatastrive.erp.JAM.Enterprises.Controller;


import com.tatastrive.erp.JAM.Enterprises.Entity.Department;
import com.tatastrive.erp.JAM.Enterprises.Entity.Employee;
import com.tatastrive.erp.JAM.Enterprises.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments()
    {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Long departmentId)
    {
        return ResponseEntity.ok(departmentService.getEmployeesByDepartmentId(departmentId));
    }


}
