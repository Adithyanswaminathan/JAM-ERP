package com.tatastrive.erp.JAM.Enterprises.Repository;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
}
