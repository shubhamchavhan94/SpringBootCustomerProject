package com.demo.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;

@Component
public class User {

	@Email
	private String emailAddress;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
