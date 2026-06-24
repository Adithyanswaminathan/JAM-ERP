package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;


import com.tatastrive.erp.JAM.Enterprises.Entity.Department;
import com.tatastrive.erp.JAM.Enterprises.Entity.Employee;
import com.tatastrive.erp.JAM.Enterprises.Repository.DepartmentRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.DepartmentService;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.DepartmentRequest;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.DepartmentResponse;
import com.tatastrive.erp.JAM.Enterprises.dto.assetdto.EmployeeDepResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentImplementation implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;


    @Override
    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        Department department = mapper.map(departmentRequest,Department.class);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentResponse response =mapper.map(savedDepartment,DepartmentResponse.class);
        return response;
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map( department -> mapper.map(department,DepartmentResponse.class)
                ).toList();
    }

    @Override
    public List<EmployeeDepResponse> getEmployeesByDepartmentId(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department Not Found"));
        return department.getEmployees()
                .stream().map(employee -> mapper.map(employee,EmployeeDepResponse.class))
                .toList();
    }

}
