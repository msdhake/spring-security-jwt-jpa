package com.love2code.springsecurityjwt.models;

import java.util.Date;

public class ErrorMessage {

	private String errorMessageDescription;
	private Date date;
	
	public ErrorMessage() {
	}

	public ErrorMessage(String errorMessageDescription, Date date) {
		this.errorMessageDescription = errorMessageDescription;
		this.date = date;
	}
	
	
}
