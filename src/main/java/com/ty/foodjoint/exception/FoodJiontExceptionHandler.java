package com.ty.foodjoint.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.foodjoint.util.ResponseStructuer;
@ControllerAdvice
public class FoodJiontExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IDNotFoundEcxepiton.class)
	public ResponseEntity<ResponseStructuer<String>> handleException(IDNotFoundEcxepiton ecxepiton){
		ResponseStructuer<String> structuer=new ResponseStructuer<String>();
		structuer.setStatus(HttpStatus.NOT_FOUND.value());
		structuer.setMessage(ecxepiton.getMessage());
		structuer.setData("Exception : ID not found/exist");
		return new ResponseEntity<ResponseStructuer<String>>(structuer,HttpStatus.NOT_FOUND);
		
	}
	

}
