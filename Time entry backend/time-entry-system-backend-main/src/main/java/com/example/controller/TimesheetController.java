package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//src/main/java/com/example/controller/TimesheetController.java
@RestController
@RequestMapping("/api/timesheets")
public class TimesheetController {
 @Autowired
 private TimesheetService timesheetService;

 @PostMapping
 public ResponseEntity<Timesheet> createTimesheet(@RequestBody Timesheet timesheet) {
     Timesheet createdTimesheet = timesheetService.createTimesheet(timesheet);
     return ResponseEntity.ok(createdTimesheet);
 }

 @GetMapping
 public ResponseEntity<List<Timesheet>> getAllTimesheets() {
     List<Timesheet> timesheets = timesheetService.getAllTimesheets();
     return ResponseEntity.ok(timesheets);
 }

 // Implement other operations like update and delete
}
