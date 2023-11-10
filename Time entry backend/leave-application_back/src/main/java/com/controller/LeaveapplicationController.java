package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Leaveapplication;
import com.repository.LeaveApplicationRepository;

@RestController
@RequestMapping("/api/leave-applications")
public class LeaveapplicationController {
    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @PostMapping
    public ResponseEntity<Leaveapplication> submitLeaveApplication(@RequestBody Leaveapplication leaveapplication) {
        // Save the leave application to the database
        Leaveapplication savedApplication = leaveApplicationRepository.save(leaveapplication);
        return ResponseEntity.ok(savedApplication);
    }

// part for approve/ reject

    @GetMapping
    public List<Leaveapplication> getLeaveApplications() {
        // Retrieve and return leave applications from the database
        return leaveApplicationRepository.findAll();
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Leaveapplication> approveLeaveApplication(@PathVariable Long id) {
        // Fetch the leave application by ID and update its status to "Approved"
        Leaveapplication application = leaveApplicationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Leave Application not found"));
        application.setStatus("Approved");
        leaveApplicationRepository.save(application);
        return ResponseEntity.ok(application);
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Leaveapplication> rejectLeaveApplication(@PathVariable Long id) {
        // Fetch the leave application by ID and update its status to "Rejected"
        Leaveapplication application = leaveApplicationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Leave Application not found"));
        application.setStatus("Rejected");
        leaveApplicationRepository.save(application);
        return ResponseEntity.ok(application);
    }
}

