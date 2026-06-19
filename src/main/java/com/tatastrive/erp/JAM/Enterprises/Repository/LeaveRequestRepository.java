package com.tatastrive.erp.JAM.Enterprises.Repository;

import com.tatastrive.erp.JAM.Enterprises.Entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {
}
