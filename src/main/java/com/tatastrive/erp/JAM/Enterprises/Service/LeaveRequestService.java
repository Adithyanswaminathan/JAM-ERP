package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.LeaveRequest;
import com.tatastrive.erp.JAM.Enterprises.Repoistory.LeaveRequestRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepoistory leaveRepository;

    // Apply leave
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {

        leaveRequest.setStatus("PENDING");

        return leaveRepository.save(leaveRequest);
    }

    // Approve leave
    public LeaveRequest approveLeave(Long id) {

        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leave.setStatus("APPROVED");

        return leaveRepository.save(leave);
    }

    // Reject leave
    public LeaveRequest rejectLeave(Long id) {

        LeaveRequest leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leave.setStatus("REJECTED");

        return leaveRepository.save(leave);
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {

        return leaveRepository.findAll();
    }
}