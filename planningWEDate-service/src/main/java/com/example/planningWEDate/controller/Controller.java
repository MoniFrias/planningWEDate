package com.example.planningWEDate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.planningWEDate.entity.DateWE;
import com.example.planningWEDate.entity.Response;
import com.example.planningWEDate.services.Services;

@RestController
@RequestMapping(path = "/planning")
public class Controller {
	
	@Autowired
	Services services;

	@PostMapping(path = "/save")
	public ResponseEntity<Response> save (@RequestBody DateWE dateWe){
		Response response = services.save(dateWe);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
