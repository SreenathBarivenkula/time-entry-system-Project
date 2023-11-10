package com.example.services;
//src/main/java/com/example/service/HolidayService.java
@Service
public class HolidayService {
 @Autowired
 private HolidayRepository holidayRepository;

 public List<Holiday> getAllHolidays() {
     // Implement logic to fetch all holidays
     return holidayRepository.findAll();
 }
}
