package com.example.services;

//src/main/java/com/example/service/LeaveApplicationService.java
@Service
public class LeaveApplicationService {
 @Autowired
 private LeaveApplicationRepository leaveApplicationRepository;

 public LeaveApplication applyForLeave(LeaveApplication leaveApplication) {
     // Implement logic to save the leave application in the database
     return leaveApplicationRepository.save(leaveApplication);
 }

 public List<LeaveApplication> getAllLeaveApplications() {
     // Implement logic to fetch all leave applications
     return leaveApplicationRepository.findAll();
 }
}
