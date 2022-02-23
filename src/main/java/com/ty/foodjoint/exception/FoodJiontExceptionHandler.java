package com.ty.foodjoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.foodjoint.util.ResponseStructure;

@ControllerAdvice
public class FoodJiontExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IDNotFoundEcxepiton.class)
	public ResponseEntity<ResponseStructure<String>> handleException(IDNotFoundEcxepiton ecxepiton) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		structuer.setStatus(HttpStatus.NOT_FOUND.value());
		structuer.setMessage(ecxepiton.getMessage());
		structuer.setData("Exception : ID not found/exist");
		return new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.NOT_FOUND);

	}

}
