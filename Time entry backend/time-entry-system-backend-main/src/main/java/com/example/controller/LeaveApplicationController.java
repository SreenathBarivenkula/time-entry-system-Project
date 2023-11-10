// src/main/java/com/example/controller/LeaveApplicationController.java
@RestController
@RequestMapping("/api/leave-applications")
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @PostMapping
    public ResponseEntity<LeaveApplication> applyForLeave(@RequestBody LeaveApplication leaveApplication) {
        LeaveApplication createdLeaveApplication = leaveApplicationService.applyForLeave(leaveApplication);
        return ResponseEntity.ok(createdLeaveApplication);
    }

    @GetMapping
    public ResponseEntity<List<LeaveApplication>> getAllLeaveApplications() {
        List<LeaveApplication> leaveApplications = leaveApplicationService.getAllLeaveApplications();
        return ResponseEntity.ok(leaveApplications);
    }

    // Implement other operations like update and delete
}
