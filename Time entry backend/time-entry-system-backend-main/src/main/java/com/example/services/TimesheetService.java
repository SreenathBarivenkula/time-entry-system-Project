package com.example.services;

//src/main/java/com/example/service/TimesheetService.java
@Service
public class TimesheetService {
    @Autowired
    private EmailService emailService;

	
	@Autowired
 private TimesheetRepository timesheetRepository;

 public Timesheet createTimesheet(Timesheet timesheet) {
     // Implement logic to save the timesheet in the database
     return timesheetRepository.save(timesheet);
 }

 public List<Timesheet> getAllTimesheets() {
     // Implement logic to fetch all timesheets
     return timesheetRepository.findAll();
 }
 public Timesheet approveTimesheet(Long timesheetId) {
     // Implement logic to set the timesheet status to "approved"
     Timesheet timesheet = timesheetRepository.findById(timesheetId).orElse(null);
     if (timesheet != null) {
         timesheet.setStatus("approved");
         return timesheetRepository.save(timesheet);
     }
     return null;
 }

 public Timesheet rejectTimesheet(Long timesheetId) {
     // Implement logic to set the timesheet status to "rejected"
     Timesheet timesheet = timesheetRepository.findById(timesheetId).orElse(null);
     if (timesheet != null) {
         timesheet.setStatus("rejected");
         return timesheetRepository.save(timesheet);
     }
     return null;
 }
 
 public Timesheet approveTimesheet(Long timesheetId) {
     Timesheet timesheet = timesheetRepository.findById(timesheetId).orElse(null);
     if (timesheet != null) {
         timesheet.setStatus("approved");
         emailService.sendEmail(timesheet.getUser().getEmail(), "Timesheet Approved", "Your timesheet has been approved.");
         return timesheetRepository.save(timesheet);
     }
     return null;
 }

 public Timesheet rejectTimesheet(Long timesheetId) {
     Timesheet timesheet = timesheetRepository.findById(timesheetId).orElse(null);
     if (timesheet != null) {
         timesheet.setStatus("rejected");
         emailService.sendEmail(timesheet.getUser().getEmail(), "Timesheet Rejected", "Your timesheet has been rejected.");
         return timesheetRepository.save(timesheet);
     }
     return null;
 }
}
