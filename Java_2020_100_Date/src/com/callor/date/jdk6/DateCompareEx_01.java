package com.callor.date.jdk6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCompareEx_01 {

	static final String DATE_FORMAT = "yyyy-MM-dd";
	static final String TIME_FORMAT = "hh:mm:ss";
	
	public static void main(String[] args) {

		SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);
		SimpleDateFormat st = new SimpleDateFormat(TIME_FORMAT);
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2019,01,01);
		c2.set(2019, 01,32);

		System.out.println("before:" + (c1.before(c2)));
		System.out.println("after:" + (c1.after(c2)));
		System.out.println("equals:" + (c1.equals(c2)));

		
		
		Date date1 = c1.getTime();
		Date date2 = c2.getTime();
		
		System.out.println("before:" + (date1.before(date2)));
		System.out.println("after:" + (date1.after(date2)));
		System.out.println("equals:" + (date1.equals(date2)));
		
		
	}

}
