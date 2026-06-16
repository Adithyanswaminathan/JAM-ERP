package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    LeaveRequest applyLeave(LeaveRequest leaveRequest);

    LeaveRequest approveLeave(Long id);

    LeaveRequest rejectLeave(Long id);

    List<LeaveRequest> getAllLeaveRequests();
}