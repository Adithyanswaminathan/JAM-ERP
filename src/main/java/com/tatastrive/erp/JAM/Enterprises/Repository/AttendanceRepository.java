package com.tatastrive.erp.JAM.Enterprises.Repository;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    interface AssetRepository extends JpaRepository<Asset,Long> {
    }
}
