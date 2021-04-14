package com.callor.rexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 정규표현식을 사용하여 문자열 추출하기
 * 숫자값만 추출하기
 */
public class Pattern_01 {

	public static void main(String[] args) {
		String str = "2020-12-31, 2021/01/03";

		// 검색할 문자열 패턴 : 숫자
		Pattern p = Pattern.compile("([0-9])+");
		// 문자열 설정

		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}

}
