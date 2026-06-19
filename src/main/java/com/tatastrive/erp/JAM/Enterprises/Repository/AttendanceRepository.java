package com.tatastrive.erp.JAM.Enterprises.Repository;


import com.tatastrive.erp.JAM.Enterprises.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

}
