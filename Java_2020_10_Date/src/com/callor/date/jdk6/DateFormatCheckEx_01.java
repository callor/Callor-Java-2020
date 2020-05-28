package com.callor.date.jdk6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;

/*
 * SimpleDateFormat의 Exception을 이용하여 날짜 형식 오류 검증
 */
public class DateFormatCheckEx_01 {

	public static void main(String[] args) {

		SimpleDateFormat check = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			Date date = check.parse("201902-29");
			System.out.println(date);
		} catch (DateTimeParseException e) {
			System.out.println("날짜형식 오류");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
