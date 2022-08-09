package com.yuzee.common.lib.dto;

public class GenericResponse {
	
	private int responseCode;
	private String message;
	
	public GenericResponse() {
		
	}

	public GenericResponse(int responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserSignUpResponse [responseCode=" + responseCode + ", message=" + message + "]";
	}
	
	

}
