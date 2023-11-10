package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	 
	@Autowired
	    private JavaMailSender javaMailSender;

	    public void sendLoginNotification(String recipientEmail) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(recipientEmail);	
	        message.setSubject("Login Succesfull-Time entry system");
	        message.setText("Dear"+recipientEmail +"You have successfully logged in.");
	        message.setSubject("Thank you");
	        javaMailSender.send(message);
	    }
}
