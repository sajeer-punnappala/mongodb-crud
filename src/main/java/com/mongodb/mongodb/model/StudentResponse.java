package com.mongodb.mongodb.model;

import org.springframework.http.HttpStatus;


public class StudentResponse<T> {
	
	private HttpStatus httpStatus;
	
	private int statusCode;
	
	private T data;
	
	private String errorMsg;
	

	public StudentResponse(HttpStatus httpStatus, int statusCode, T data, String errorMsg) {
		super();
		this.httpStatus = httpStatus;
		this.statusCode = statusCode;
		this.data = data;
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentResponse [httpStatus=").append(httpStatus).append(", statusCode=").append(statusCode)
				.append(", data=").append(data).append(", errorMsg=").append(errorMsg).append("]");
		return builder.toString();
	}
	
	
}
