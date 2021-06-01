package com.example.planningWEDate.services;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.planningWEDate.entity.DateWE;
import com.example.planningWEDate.entity.Response;
import com.example.planningWEDate.entity.WEDateBeforeTodayException;

@Service
public class Services {


	public Response saveLoad(LocalDate dateWe) {
		Response response = new Response();
		DateWE weekEndingDate = new DateWE();
		if(dateWe.isAfter(LocalDate.now())|| dateWe.isEqual(LocalDate.now()) ) {
			int currentDay = DayOfWeek.from(dateWe).getValue();
			if(currentDay == 6) {
				weekEndingDate.setWeekEndingDate(dateWe);
				response.setData(weekEndingDate);
				return response;
			}
			throw new WEDateBeforeTodayException();
		}
		throw new WEDateBeforeTodayException();
	}

	
	public Response saveSchedule(LocalDate dateWe) {
		Response response = new Response();
		DateWE weekEndingDate = new DateWE();
		LocalDate currentDay = LocalDate.now();
		int day = DayOfWeek.from(dateWe).getValue();
		if(dateWe.isAfter(currentDay)|| dateWe.isEqual(currentDay) ) {
			LocalDate saturdayCurrentWeek = setWeekEndingDate(currentDay);
			if(day == 6) {
				if(!saturdayCurrentWeek.equals(dateWe)) {
					weekEndingDate.setWeekEndingDate(dateWe);
					response.setData(weekEndingDate);
					return response;
				}
				throw new WEDateBeforeTodayException();
			}
			throw new WEDateBeforeTodayException();
		}
		throw new WEDateBeforeTodayException();
	}
	
	private LocalDate setWeekEndingDate(LocalDate date) {
		int currentDay = DayOfWeek.from(date).getValue();
		System.out.println(currentDay);
		
		if(currentDay == 1) {
			return date.plusDays(5);
		}else if(currentDay == 2) {
			return date.plusDays(4);
		}else if(currentDay == 3) {
			return date.plusDays(3);
		}else if(currentDay == 4) {
			return date.plusDays(2);
		}else if(currentDay == 5) {
			return date.plusDays(1);
		}else if(currentDay == 7) {
			return date.plusDays(6);
		}
		return date;
	}


}
