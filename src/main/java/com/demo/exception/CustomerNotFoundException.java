package com.demo.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String message)
	{
		super(message);
	}

}
