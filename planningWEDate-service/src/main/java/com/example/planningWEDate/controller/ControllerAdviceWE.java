package com.example.planningWEDate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.planningWEDate.entity.Response;
import com.example.planningWEDate.entity.WEDateBeforeTodayException;

@RestControllerAdvice
public class ControllerAdviceWE {

	@ExceptionHandler(value = WEDateBeforeTodayException.class) 
	public ResponseEntity<Response> WEDateBeforeToday(final WEDateBeforeTodayException exception){
		Response response = new Response(false, exception.getMessage(), null);
		return new ResponseEntity<Response>(response  , HttpStatus.BAD_REQUEST);
	}
	

}
