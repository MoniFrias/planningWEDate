package com.example.planningWEDate.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.planningWEDate.entity.Response;
import com.example.planningWEDate.services.Services;

@RestController
@RequestMapping(path = "/planning")
public class Controller {
	
	@Autowired
	Services services;

	@PostMapping(path = "/save")
	public ResponseEntity<Response> save (@RequestParam(name =  "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		Response response = services.save(date);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
