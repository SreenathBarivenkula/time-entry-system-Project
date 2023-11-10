package com.example.services;
//src/main/java/com/example/service/ReminderService.java
@Service
public class ReminderService {
 @Autowired
 private ReminderRepository reminderRepository;

 public Reminder createReminder(Reminder reminder) {
     // Implement logic to save the reminder in the database
     return reminderRepository.save(reminder);
 }

 public List<Reminder> getAllReminders() {
     // Implement logic to fetch all reminders
     return reminderRepository.findAll();
 }
}

