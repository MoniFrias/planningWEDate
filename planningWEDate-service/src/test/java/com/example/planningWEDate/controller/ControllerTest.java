package com.example.planningWEDate.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.example.planningWEDate.services.Services;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

	@InjectMocks
	Controller controller;
	@Mock
	Services service;
	
	@Test
	public void testSaveLoad() {
		LocalDate date = null;
		assertEquals(HttpStatus.OK, controller.saveLoad(date).getStatusCode());
	}
	
	@Test
	public void testSaveSchedule() {
		LocalDate date = null;
		assertEquals(HttpStatus.OK, controller.saveSchedule(date).getStatusCode());
	}

}
