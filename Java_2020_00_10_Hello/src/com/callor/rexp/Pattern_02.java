package com.callor.rexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 정규표현식을 사용하여 문자열 추출하기
 */
public class Pattern_02 {

	public static void main(String[] args) {
		
		
		StackTraceElement[] ste = new Throwable().getStackTrace();
		String str = ste[ste.length - 1].toString();

		// 검색할 문자열 패턴 : 영문자
		Pattern pattern = Pattern.compile("([a-z])+");
		// 문자열 설정

		Matcher match = pattern.matcher(str);
		while (match.find()) {
			System.out.println(match.group());
		}
	}

}
