package com.example.planningWEDate.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import com.example.planningWEDate.entity.WEDateBeforeTodayException;

@ExtendWith(MockitoExtension.class)
class ServicesTest {
	
	@InjectMocks
	Services services;

	@Test
	public void testSaveLoad() {
		LocalDate dateWe = LocalDate.parse("2089-06-11");
		assertTrue(services.saveLoad(dateWe).isResult());
	}
		
	@Test
	public void testSaveThrowCurrentDay() {
		LocalDate dateWe = LocalDate.now();
		assertThrows(WEDateBeforeTodayException.class, () -> services.saveLoad(dateWe));
	}
	
	@Test
	public void testSaveThrowPassDate() {
		LocalDate dateWe = LocalDate.now().minusDays(5);
		assertThrows(WEDateBeforeTodayException.class, () -> services.saveLoad(dateWe));
	}
	
	@Test
	public void testSaveSchedule() {
		LocalDate dateWe = LocalDate.parse("2089-06-11");
		assertEquals("success",services.saveSchedule(dateWe).getMessage());
	}
	
	@Test
	public void testSaveScheduleThrowSaturdarCurrentWeek() {
		LocalDate dateWe = LocalDate.now().plusDays(2);
		assertThrows(WEDateBeforeTodayException.class, () -> services.saveSchedule(dateWe));
	}	
	
	@Test
	public void testSaveScheduleNow() {
		LocalDate dateWe = LocalDate.now();
		assertThrows(WEDateBeforeTodayException.class, () -> services.saveSchedule(dateWe));
	}
	
	@Test
	public void testSaveSchedulePast() {
		LocalDate dateWe = LocalDate.now().minusDays(10);
		assertThrows(WEDateBeforeTodayException.class, () -> services.saveSchedule(dateWe));
	}
	
	@Test
	public void testTodayDayMonday() {
		assertEquals(LocalDate.parse("2021-06-05"), ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-05-31")));
	}
	
	@Test
	public void testTodayDayTuesday() {
		assertEquals(LocalDate.parse("2021-06-05"), ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-06-01")));
	}
	@Test
	public void testTodayDayWednesday() {
		assertEquals(LocalDate.parse("2021-06-05"),ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-06-02")));
	}
	@Test
	public void testTodayDayThursday() {
		assertEquals(LocalDate.parse("2021-06-05"),ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-06-03")));
	}
	@Test
	public void testTodayDayFriday() {
		assertEquals(LocalDate.parse("2021-06-05"),ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-06-04")));
	}
	
	@Test
	public void testTodayDaySaturday() {
		assertEquals(LocalDate.parse("2021-06-05"),ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-06-05")));
	}
	
	@Test
	public void testTodayDaySunday() {
		assertEquals(LocalDate.parse("2021-06-12"),ReflectionTestUtils.invokeMethod(services, "setWeekEndingDate", LocalDate.parse("2021-06-06")));
	}
	




}
