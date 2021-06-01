package com.example.planningWEDate.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.example.planningWEDate.entity.WEDateBeforeTodayException;

@ExtendWith(MockitoExtension.class)
class ControllerAdviceWETest {

	@InjectMocks
	ControllerAdviceWE controllerA;
	
	@Test
	public void testWEDateBeforeToday() {
		WEDateBeforeTodayException exception= new WEDateBeforeTodayException();
		assertEquals(HttpStatus.BAD_REQUEST, controllerA.WEDateBeforeToday(exception).getStatusCode());
	}

}
