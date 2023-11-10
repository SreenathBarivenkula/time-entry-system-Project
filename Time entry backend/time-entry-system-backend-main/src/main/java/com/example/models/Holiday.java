package com.example.models;

//src/main/java/com/example/model/Holiday.java
@Entity
public class Holiday {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private Date date;
 // Getters and setters
}
