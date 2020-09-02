package com.callor.stream.exec;

import java.util.Arrays;
import java.util.List;

public class FilteringEx {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "김남준", "김남준");

		// 중복제거
		names.stream().distinct().forEach(System.out::println);
		System.out.println();

		// 시작하는 문자열이 "신"
		names.stream().filter(str -> str.startsWith("신")).forEach(System.out::println);
		System.out.println();

		// 끝나는 문자열이 "준"
		names.stream().distinct().filter(str -> str.endsWith("준")).forEach(System.out::println);

	}
}
