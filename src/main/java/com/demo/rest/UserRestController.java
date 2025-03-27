package com.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.EmailRequest;
import com.demo.model.User;
import com.demo.service.MailService;

import jakarta.validation.constraints.Email;

@RestController
@RequestMapping("/api")
@Validated
public class UserRestController {

	@Autowired
	private MailService mailService;

	@Autowired
	private User user;

	@GetMapping("/sendmailapp")
	public String sendingMail(@Email @RequestParam("Email") String email) {

		user.setEmailAddress(email);

		try {
			mailService.mailSending(user);

		} catch (MailException mailException) {
			System.out.println(mailException);
		}

		return "Your mail has been send successfully.";

	}
	
	@PostMapping("/send-email-attachment")
	public String sendEmailwithAttachment(@RequestBody EmailRequest emailRequest) {
		
		mailService.sendEmailWithAttachment(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody(), emailRequest.getAttachmentFilePath());
	
		return "Email with attachment send successfully.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
