package com.example.controller;

//src/main/java/com/example/controller/ReminderController.java
@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
 @Autowired
 private ReminderService reminderService;

 @PostMapping
 public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
     Reminder createdReminder = reminderService.createReminder(reminder);
     return ResponseEntity.ok(createdReminder);
 }

 @GetMapping
 public ResponseEntity<List<Reminder>> getAllReminders() {
     List<Reminder> reminders = reminderService.getAllReminders();
     return ResponseEntity.ok(reminders);
 }

 // Implement other operations like update and delete
}
