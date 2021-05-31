package com.example.planningWEDate.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateWE {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate weekEndingDate;	

}
