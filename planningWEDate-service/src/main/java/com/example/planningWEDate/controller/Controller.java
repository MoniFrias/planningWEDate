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

	@PostMapping(path = "/saveLoad")
	public ResponseEntity<Response> saveLoad (@RequestParam(name =  "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		Response response = services.saveLoad(date);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path = "/saveSchedule")
	public ResponseEntity<Response> saveSchedule (@RequestParam(name =  "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		Response response = services.saveSchedule(date);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
