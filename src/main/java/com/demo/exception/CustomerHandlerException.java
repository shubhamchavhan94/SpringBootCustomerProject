package com.demo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerHandlerException {

	@ExceptionHandler(value = {CustomerNotFoundException.class})
	public ResponseEntity<CustomerException> getCustomerHandler(CustomerNotFoundException customerNotFoundException)
	{
		CustomerException customerException = new CustomerException(new Date(), HttpStatus.NOT_FOUND, customerNotFoundException.getMessage());
		return new ResponseEntity<>(customerException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerException> getCustomerHandler(Exception exception)
	{
		CustomerException customerException = new CustomerException(new Date(), HttpStatus.NOT_FOUND, exception.getMessage());
		return new ResponseEntity<CustomerException>(customerException, HttpStatus.NOT_FOUND);
	}
}
