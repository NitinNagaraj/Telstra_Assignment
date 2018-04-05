package com.hcl.telstraAssignment.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Wrong input")
public class ErrorResponse {
	
	String errorCode;
    String message;
    
    public ErrorResponse(String errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }
    
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
