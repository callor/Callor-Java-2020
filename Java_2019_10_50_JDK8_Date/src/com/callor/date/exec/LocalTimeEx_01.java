package com.callor.date.exec;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class LocalTimeEx_01 {

	public static void main(String[] args) {

		LocalTime localTime = LocalTime.now();
		DateTimeFormatter fTime 
			= DateTimeFormatter.ofPattern("hh:mm:ss");
		
		String curTime = fTime.format(localTime);
		System.out.println(curTime);
		
		DateTimeFormatter f24Time
			= DateTimeFormatter.ofPattern("HH:mm:ss");
		curTime = f24Time.format(localTime);
		System.out.println(curTime);
		
		
		
		
	}

}
