package com.example.UserManagement;

import com.example.UserManagement.mail.GoogleMailService;
import com.example.UserManagement.mail.MailService;
import com.example.UserManagement.mail.OutlookMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	@Primary
	public MailService outlookMail(){
		return new OutlookMailService();
	}
	@Bean
	public MailService googleMail(){
		return new GoogleMailService();
	}
}
