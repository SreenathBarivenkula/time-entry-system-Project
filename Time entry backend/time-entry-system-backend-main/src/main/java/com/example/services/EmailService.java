package com.example.services;

//src/main/java/com/example/service/EmailService.java
@Service
public class EmailService {
 @Autowired
 private JavaMailSender emailSender;

 public void sendEmail(String to, String subject, String text) {
     SimpleMailMessage message = new SimpleMailMessage();
     message.setTo(to);
     message.setSubject(subject);
     message.setText(text);
     emailSender.send(message);
 }
}
