package com.tatastrive.erp.JAM.Enterprises.Controller;

import java.util.List;

import com.tatastrive.erp.JAM.Enterprises.Service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tatastrive.erp.JAM.Enterprises.Entity.LeaveRequest;

@RestController
@RequestMapping("/leave")

public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveService;

    // Apply leave
    @PostMapping
    public ResponseEntity<LeaveRequest> applyLeave(
            @RequestBody LeaveRequest leaveRequest) {

        return new ResponseEntity<>(
                leaveService.applyLeave(leaveRequest),
                HttpStatus.CREATED);
    }

    // Approve leave
    @PutMapping("/approve/{id}")
    public ResponseEntity<LeaveRequest> approveLeave(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveService.approveLeave(id));
    }

    // Reject leave
    @PutMapping("/reject/{id}")
    public ResponseEntity<LeaveRequest> rejectLeave(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveService.rejectLeave(id));
    }

    // Get all leave requests
    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests() {

        return ResponseEntity.ok(
                leaveService.getAllLeaveRequests());
    }
}