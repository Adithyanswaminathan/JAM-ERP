package com.tatastrive.erp.JAM.Enterprises.Repository;

import com.tatastrive.erp.JAM.Enterprises.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
