package com.example.planningWEDate.services;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.planningWEDate.entity.DateWE;
import com.example.planningWEDate.entity.Response;
import com.example.planningWEDate.entity.WEDateBeforeTodayException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class Services {

	private Logger log = LoggerFactory.getLogger(Services.class);

	public Response save(LocalDate dateWe) {
		log.info("Starting method save {}", dateWe);
		Response response = new Response();
		if(dateWe.isAfter(LocalDate.now())|| dateWe.isEqual(LocalDate.now()) ) {
			LocalDate PublishedWEDate = setWeekEndingDate(dateWe.minusDays(7));
			log.info(" PublishedWEDate is {} ", PublishedWEDate);
			response.setData(PublishedWEDate);
			return response;
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Bad Request with the next date %s", dateWe));
	}
	
	
	private LocalDate setWeekEndingDate(LocalDate date) {
		int currentDay = DayOfWeek.from(date).getValue();
		System.out.println(currentDay);
		
		if(currentDay == 1) {
			return date.plusDays(19);
		}else if(currentDay == 2) {
			return date.plusDays(18);
		}else if(currentDay == 3) {
			return date.plusDays(17);
		}else if(currentDay == 4) {
			return date.plusDays(16);
		}else if(currentDay == 5) {
			return date.plusDays(22);
		}else if(currentDay == 6) {
			return date.plusDays(7);
		}
		return date.plusDays(20);
	}


}
