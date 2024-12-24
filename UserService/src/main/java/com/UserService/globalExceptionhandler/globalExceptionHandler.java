package com.UserService.globalExceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UserService.exception.resourseNotFoundException;
import com.UserService.payload.apiResponse;

@RestControllerAdvice
public class globalExceptionHandler {
//
//	@ExceptionHandler(resourseNotFoundException.class)
//	public ResponseEntity<apiResponse> handlerResourseNotFoundException (resourseNotFoundException ex){
//		
//		String message = ex.getMessage();
//		
//		apiResponse response = apiResponse.message(message).success(true).status(HttpStatus.NOT_FOUND);
//		
//		return new  ResponseEntity<apiResponse>(response, HttpStatus.NOT_FOUND);
	//}
}
