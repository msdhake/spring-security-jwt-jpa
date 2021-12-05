package com.love2code.springsecurityjwt.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.love2code.springsecurityjwt.models.ErrorMessage;

@ControllerAdvice
public class CustomException {

	@ExceptionHandler(value = { UserException.class})
	public ResponseEntity<Object> userIsPresentException( UserException exu, WebRequest wbRequest) {
		
		String errorMessageDescription = exu.getLocalizedMessage();
		
		if(null == errorMessageDescription)
			errorMessageDescription = exu.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(errorMessageDescription, new Date());
		
		return new ResponseEntity<Object>(
				errorMessage, new HttpHeaders(), HttpStatus.ALREADY_REPORTED);
		
	}
}
