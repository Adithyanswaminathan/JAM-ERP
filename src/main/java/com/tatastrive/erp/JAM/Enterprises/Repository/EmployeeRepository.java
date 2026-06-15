package com.tatastrive.erp.JAM.Enterprises.Repository;

import com.tatastrive.erp.JAM.Enterprises.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
