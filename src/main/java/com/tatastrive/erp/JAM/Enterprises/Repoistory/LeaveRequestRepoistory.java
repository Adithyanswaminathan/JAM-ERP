package com.tatastrive.erp.JAM.Enterprises.Repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatastrive.erp.JAM.Enterprises.Entity.LeaveRequest;

@Repository
public interface LeaveRequestRepoistory extends JpaRepository<LeaveRequest, Long> {

}