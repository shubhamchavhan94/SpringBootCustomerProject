package com.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class CustomerException {

	// timestamp, status, message

	private final Date timestamp;
	private final HttpStatus status;
	private final String message;

	public CustomerException(Date timestamp, HttpStatus status, String message) {
		
		System.out.println("Inside Customer Exception class..");
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}
	

	public Date getTimestamp() {
		return timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
