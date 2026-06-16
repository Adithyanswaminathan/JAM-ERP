package com.tatastrive.erp.JAM.Enterprises.Service;
import java.util.List;
import com.tatastrive.erp.JAM.Enterprises.Entity.Attendance;

public interface AttendanceService {
    Attendance saveAttendance(Attendance attendance);

    List<Attendance> getAllAttendance();

    Attendance getAttendanceById(Long id);
}
