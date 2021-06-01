package com.example.planningWEDate.entity;

public class WEDateBeforeTodayException extends RuntimeException{

	public WEDateBeforeTodayException() {
		super("Invalid date");
	}

}
