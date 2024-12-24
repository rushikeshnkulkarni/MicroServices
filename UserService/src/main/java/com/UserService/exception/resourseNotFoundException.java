package com.UserService.exception;

public class resourseNotFoundException extends RuntimeException {

	
	public resourseNotFoundException() {
		
		super("id not found");
	}
	
public resourseNotFoundException(String message) {
		
		super(message);
	}
}
