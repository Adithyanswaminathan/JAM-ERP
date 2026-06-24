package com.tatastrive.erp.JAM.Enterprises.Controller;


import com.tatastrive.erp.JAM.Enterprises.Service.DepartmentService;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.DepartmentRequest;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.DepartmentResponse;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.EmployeeDepResponse;
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
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest)
    {
        DepartmentResponse response = departmentService.createDepartment(departmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments()
    {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<EmployeeDepResponse>> getEmployeesByDepartment(@PathVariable Long departmentId)
    {
        return ResponseEntity.ok(departmentService.getEmployeesByDepartmentId(departmentId));
    }


}
