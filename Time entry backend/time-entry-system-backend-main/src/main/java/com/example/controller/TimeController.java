package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//src/main/java/com/example/controller/UserController.java
@RestController
@RequestMapping("/api/user")
public class TimeController {

 @Autowired
 private UserService userService;

 @PostMapping("/register")
 public ResponseEntity<?> registerUser(@RequestBody User user) {
     User registeredUser = userService.registerUser(user);
     return ResponseEntity.ok(registeredUser);
 }

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody User user) {
     User authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
     if (authenticatedUser != null) {
         return ResponseEntity.ok(authenticatedUser);
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
     }
 }
}
