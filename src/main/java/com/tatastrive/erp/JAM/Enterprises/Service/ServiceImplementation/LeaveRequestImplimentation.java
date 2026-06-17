package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.LeaveRequest;
import com.tatastrive.erp.JAM.Enterprises.Repository.DepartmentRepository;
import com.tatastrive.erp.JAM.Enterprises.Repository.LeaveRequestRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestImplimentation implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRepository;

    @Override
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {

        leaveRequest.setStatus("PENDING");

        return leaveRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest approveLeave(Long id) {

        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leave.setStatus("APPROVED");

        return leaveRepository.save(leave);
    }

    @Override
    public LeaveRequest rejectLeave(Long id) {

        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leave.setStatus("REJECTED");

        return leaveRepository.save(leave);
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {

        return leaveRepository.findAll();
    }
}