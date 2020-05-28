package com.callor.find;

import java.util.Optional;
import java.util.stream.Stream;



/*
 * findFirst () 메서드는 스트림에서 첫 번째 요소를 반환합니다. 
 * 아래 출력을 확인하면 프로그램은 Optional [A]
 */
public class FindFirst {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("A", "B", "C");

		Optional<String> result = stream.findFirst();
		System.out.println(result);

	}

}
