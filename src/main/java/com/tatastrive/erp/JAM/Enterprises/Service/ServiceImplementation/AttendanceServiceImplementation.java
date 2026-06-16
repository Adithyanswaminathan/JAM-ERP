package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.Attendance;
import com.tatastrive.erp.JAM.Enterprises.Repository.AttendanceRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImplementation implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Override
    public Attendance saveAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }
    @Override
    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }
    @Override
    public Attendance getAttendanceById(Long id){
        return attendanceRepository.findById(id).orElse(null);
    }

}
