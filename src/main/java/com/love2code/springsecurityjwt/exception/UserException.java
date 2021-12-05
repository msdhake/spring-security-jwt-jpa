package com.love2code.springsecurityjwt.exception;

import org.springframework.stereotype.Service;

@Service
public class UserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException() {
		
	}
	
	public UserException(String strException) {
		
		super(strException);
	}
	
}
