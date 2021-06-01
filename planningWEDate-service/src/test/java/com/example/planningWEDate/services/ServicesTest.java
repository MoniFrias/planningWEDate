package com.example.planningWEDate.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.planningWEDate.entity.WEDateBeforeTodayException;

@ExtendWith(MockitoExtension.class)
class ServicesTest {
	
	@InjectMocks
	Services services;

	@Test
	public void testSave() {
		LocalDate dateWe = LocalDate.now();
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSave1() {
		LocalDate dateWe = LocalDate.now().plusDays(1);
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSave2() {
		LocalDate dateWe = LocalDate.now().plusDays(2);
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSave3() {
		LocalDate dateWe = LocalDate.now().plusDays(3);
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSave4() {
		LocalDate dateWe = LocalDate.now().plusDays(4);
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSave5() {
		LocalDate dateWe = LocalDate.now().plusDays(5);
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSave6() {
		LocalDate dateWe = LocalDate.now().plusDays(6);
		assertTrue(services.save(dateWe).isResult());
	}
	
	@Test
	public void testSaveThrow() {
		LocalDate dateWe = LocalDate.now().minusDays(5);
		assertThrows(WEDateBeforeTodayException.class, () -> services.save(dateWe));
	}

}
