package com.example.planningWEDate.services;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.planningWEDate.entity.DateWE;
import com.example.planningWEDate.entity.Response;

@Service
public class Services {

	public Response save(DateWE dateWe) {
		Response response = new Response();
		LocalDate PlanningWEDate = setWeekEndingDate(LocalDate.now()); 
		LocalDate PublishedWEDate = setWeekEndingDate(LocalDate.now().minusDays(7));
		response.setData(PublishedWEDate);
		return response;
	}
	
	private LocalDate setWeekEndingDate(LocalDate date) {
		
		DayOfWeek dayOfWeek = DayOfWeek.from(date);	
		int date1 = dayOfWeek.getValue();
		System.out.println(date1);
		switch (date1) { 				
			case 0: 					
				return date.plusDays(13);			
			case 1: 					
				return date.plusDays(12); 			
			case 2: 					
				return date.plusDays(11);				
			case 3: 					
				return date.plusDays(10);			
			case 4: 					
				return date.plusDays(9);				
			case 5: 					
				return date.plusDays(15);				
			case 6: 					
				return date;			
		}
		return null;
	}


}
