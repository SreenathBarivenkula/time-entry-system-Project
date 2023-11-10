package com.example.controller;
//src/main/java/com/example/controller/HolidayController.java
@RestController
@RequestMapping("/api/holidays")
public class HolidayController {
 
	
	public HolidayController(HolidayService holidayService) {
		super();
		this.holidayService = holidayService;
	}
	
	

@Autowired
 private HolidayService holidayService;

 @GetMapping
 public ResponseEntity<List<Holiday>> getAllHolidays() {
     List<Holiday> holidays = holidayService.getAllHolidays();
     return ResponseEntity.ok(holidays);
 }

 // Implement other operations like adding, updating, and deleting holidays
}
