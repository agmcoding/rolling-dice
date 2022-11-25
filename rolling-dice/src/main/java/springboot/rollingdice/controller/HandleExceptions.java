package springboot.rollingdice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import springboot.rollingdice.exception.InvalidNumberOfRollsException;

@ControllerAdvice
public class HandleExceptions {

	@ExceptionHandler(InvalidNumberOfRollsException.class)
	public ResponseEntity<?> handleInvalidNumberOfRollsException(InvalidNumberOfRollsException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
}
