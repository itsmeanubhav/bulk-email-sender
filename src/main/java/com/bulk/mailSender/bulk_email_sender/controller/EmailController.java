package com.bulk.mailSender.bulk_email_sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bulk.mailSender.bulk_email_sender.service.EmailService;

//Creating a REST controller to trigger email sending

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send-emails")
	public String sendEmails() {
		try {
			emailService.sendEmails();
			return "Emails sent successfully";
		}catch(Exception e) {
			return "Failed to send emails: " + e.getMessage();
		}
	}
}
