package org.current.nextguidely.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle all uncaught exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		Arrays.stream(exception
				.getStackTrace())
				.forEach(System.out::println);

		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", exception);
	}
	
	// Handle specific known exceptions like JSON serialization errors
	@ExceptionHandler(InvalidDefinitionException.class)
	public ResponseEntity<Object> handleSerializationException(InvalidDefinitionException ex, WebRequest request) {
		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Serialization Error", ex);
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentExceptionn(IllegalArgumentException exception, WebRequest request) {
		return buildResponseEntity(HttpStatus.EXPECTATION_FAILED, "Invalid Argument", exception);
	}
	
	// Utility method to structure the error response
	private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, Exception ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("message", "failed");
		body.put("error", ex.getMessage());
		return new ResponseEntity<>(body, status);
	}
}
