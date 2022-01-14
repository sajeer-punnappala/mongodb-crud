package com.mongodb.mongodb.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongodb.mongodb.model.StudentResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StudentResponse<Object>> handleGenericException(Exception ex, WebRequest request) throws Exception {
		StudentResponse<Object> studentResponse = new StudentResponse<Object>(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), null, ex.getMessage());
		return new ResponseEntity<StudentResponse<Object>>(studentResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<StudentResponse<Object>> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		StudentResponse<Object> studentResponse = new StudentResponse<Object>(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), null, ex.getMessage());
		return new ResponseEntity<StudentResponse<Object>>(studentResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		StudentResponse<Object> studentResponse = new StudentResponse<Object>(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), null, ex.getBindingResult().toString());
		return new ResponseEntity(studentResponse,HttpStatus.BAD_REQUEST);
	}
}
