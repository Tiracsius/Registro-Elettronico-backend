package com.registro.registroelettronico.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.registro.registroelettronico.dto.ApiErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<ApiErrorResponse.FieldError> errors = ex.getBindingResult().getFieldErrors()
				.stream().map(error -> ApiErrorResponse.FieldError.builder()
						.field(error.getField())
						.message(error.getDefaultMessage())	
						.build()
						)
				.toList();
		ApiErrorResponse response = ApiErrorResponse.builder()
				.message("Validation failed")
				.status(HttpStatus.BAD_REQUEST.value())
				.errors(errors)
				.build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiErrorResponse> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
		Throwable cause = ex.getCause();
		
		if (cause instanceof InvalidTypeIdException invalidTypeIdEx) {
			ApiErrorResponse response = ApiErrorResponse.builder()
					.status(HttpStatus.BAD_REQUEST.value())
					.message("Role doesnt exists")
					.build();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		ApiErrorResponse response = ApiErrorResponse.builder()
	    		  .message("Malformed JSON request")
	    		  .status(HttpStatus.BAD_REQUEST.value())
	    		  .build();
      	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ApiErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
		ApiErrorResponse response = ApiErrorResponse.builder()
				.message(ex.getMessage())
				.status(HttpStatus.CONFLICT.value())
				.build();
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler({
		ParentNotFoundException.class,
		StudentNotFoundException.class,
		SchoolClassNotFoundException.class,
		SecretaryNotFoundException.class,
		TeacherNotFoundException.class
	})
	public ResponseEntity<ApiErrorResponse> handleNotFounException(RuntimeException ex) {
		ApiErrorResponse response = ApiErrorResponse.builder()
				.message(ex.getMessage())
				.status(HttpStatus.NOT_FOUND.value())
				.build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
