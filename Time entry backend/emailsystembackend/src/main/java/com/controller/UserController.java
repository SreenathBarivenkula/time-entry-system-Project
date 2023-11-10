package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sendingemail.UserLoginRequest;

import com.sendingemail.UserLoginRequest;
import com.service.NotificationService;

@RestController
public class UserController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest) {
        // Perform login logic here
    	User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // Send login notification email
            notificationService.sendLoginNotification(loginRequest.getEmail());

            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatusCode.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
