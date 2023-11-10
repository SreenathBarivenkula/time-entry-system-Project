package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//src/main/java/com/example/service/UserService.java
@Service
public class TimeService {

 @Autowired
 private UserRepository userRepository;

 public User registerUser(User user) {
     // Implement user registration logic, e.g., save the user to the database
     return userRepository.save(user);
 }

 public User authenticateUser(String username, String password) {
     // Implement user authentication logic, e.g., validate user credentials
     return userRepository.findByUsernameAndPassword(username, password);
 }
}
