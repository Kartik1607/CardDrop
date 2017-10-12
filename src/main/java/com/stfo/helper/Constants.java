package com.stfo.helper;

import java.time.LocalDateTime;

public class Constants {
	public static final int TIME_SHORT = 0;
	public static final int TIME_LONG = 1;
	
	public static LocalDateTime getExpireTime(int which) {
		LocalDateTime time = LocalDateTime.now();
		switch (which) {
			case Constants.TIME_SHORT: {
				time = time.plusMinutes(5);
				break;
			}
			case Constants.TIME_LONG: {
				time = time.plusYears(1);
				break;
			}
			default :
				time = time.plusMinutes(5);
		}
		return time;
	}
	
	public static final String INVALID_PASSWORD = "INVALID_PASSWORD";
	public static final String SUCCESS_LOGIN = "SUCCESS_LOGIN";
	public static final String NEW_REGISTRATION = "NEW_REGISTRATION";
	public static final String NOT_REGISTERED = "NOT_REGISTERED";
	public static final String ALREADY_REGISTERED = "ALREADY_REGISTERED";
}
