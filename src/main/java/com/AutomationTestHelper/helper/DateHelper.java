package com.AutomationTestHelper.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateHelper {
	
	public String getTodaysDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();	
		System.out.println("today's date is" + dateFormat.format(date));
		String todaysDate = dateFormat.format(date);
		
		return todaysDate;
	}
	
	public String getTomorrowDate() {
			
		String tomorrowDate = "";
		Date dt = new Date();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.from(dt.toInstant().atZone(ZoneId.of("UTC"))).plusDays(1);
		tomorrowDate = dtf.format(now);
				
		return tomorrowDate;
	}
	
	public String getDatAfterDate() {
		
		String dayAfterDate = "";
		Date dt = new Date();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.from(dt.toInstant().atZone(ZoneId.of("UTC"))).plusDays(2);
		dayAfterDate = dtf.format(now);
				
		return dayAfterDate;
	}
	
	public String getDateAddedDay(String day) {
		
		int dayInt = Integer.parseInt(day);
		String dayAfterDate = "";
		Date dt = new Date();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.from(dt.toInstant().atZone(ZoneId.of("UTC"))).plusDays(dayInt);
		dayAfterDate = dtf.format(now);
				
		return dayAfterDate;
	}

}
