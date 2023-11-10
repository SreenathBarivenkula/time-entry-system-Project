package com.example.controller;

//src/main/java/com/example/controller/TimesheetWorkflowController.java
@RestController
@RequestMapping("/api/timesheets/workflow")
public class TimesheetWorkflowController {
 @Autowired
 private TimesheetService timesheetService;

 @PutMapping("/{timesheetId}/approve")
 public ResponseEntity<?> approveTimesheet(@PathVariable Long timesheetId) {
     Timesheet approvedTimesheet = timesheetService.approveTimesheet(timesheetId);
     return ResponseEntity.ok(approvedTimesheet);
 }

 @PutMapping("/{timesheetId}/reject")
 public ResponseEntity<?> rejectTimesheet(@PathVariable Long timesheetId) {
     Timesheet rejectedTimesheet = timesheetService.rejectTimesheet(timesheetId);
     return ResponseEntity.ok(rejectedTimesheet);
 }
}
