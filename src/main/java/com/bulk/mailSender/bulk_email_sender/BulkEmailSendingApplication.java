package com.bulk.mailSender.bulk_email_sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BulkEmailSendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulkEmailSendingApplication.class, args);
	}

}
