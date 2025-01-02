package com.bulk.mailSender.bulk_email_sender.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//Create a service to send emails in batches:
@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Async
	public void sendEmails() throws MessagingException,IOException{
		List<String> emailAddresses = getEmailAddresses();
		
		int batchSize = 15;
		for(int i=0; i<emailAddresses.size(); i+= batchSize) {
			List<String> batch = emailAddresses.subList(i, Math.min(i+batchSize, emailAddresses.size()));
			for(String email : batch) {
				sendEmail(email);
			}
			try {
				Thread.sleep(3600000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); 
				throw new RuntimeException(e);
			}
		}
	}
	
	private List<String> getEmailAddresses() throws IOException{
		ClassPathResource resource = new ClassPathResource("email-list.txt");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))){
			return reader.lines().collect(Collectors.toList());
		}
	}
	
	private void sendEmail(String to) throws MessagingException{
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setTo(to);
		helper.setSubject("Dummy Subject Line");
		//helper.setText("\"Hi,\\n\\nPlease find attached my resume.\\n\\nRegards,\\n[Anubhav Mishra]", true);
		helper.setText("<p>Hi,</p><p>Please find attached my resume.</p><p>Regards,<br>[Anubhav Mishra]</p>", true);
		ClassPathResource pdf = new ClassPathResource("Anubhav_Mishra-5+Years_Java_Backend_Developer_(Spring-Boot,Microservices).pdf"); //replace this with your pdf file name and path would be good to add the file in resources directory
		helper.addAttachment("Anubhav_Mishra-5+Years_Java_Backend_Developer_(Spring-Boot,Microservices).pdf", pdf);
		
		mailSender.send(message);
	}
}
