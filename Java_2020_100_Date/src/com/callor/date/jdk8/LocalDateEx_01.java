package com.callor.date.jdk8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEx_01 {

	public static void main(String[] args) {
		/*
		 * Date, Calendar 클래스의 다양한 이슈를 해결하고
		 * locale(로케일, 국가별) 여러가지 사항들을 해결하여
		 * 새로운 클래스를 도입
		 * JDK 8 이상에서만 사용가능하다.
		 */
		LocalDate localDate = LocalDate.now();
		
		// 문자열로 생성하기
		DateTimeFormatter dDate 
			= DateTimeFormatter.ofPattern("yyy-MM-dd");
		String curDate = dDate.format(localDate);
		
		System.out.println("오늘날짜 : " + curDate);
		
	}

}
