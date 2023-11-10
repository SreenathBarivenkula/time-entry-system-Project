package com.example.models;

//src/main/java/com/example/model/Reminder.java
@Entity
public class Reminder {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Long userId;
 private String title;
 private String description;
 private LocalDateTime dueDate;
 // Getters and setters
}

