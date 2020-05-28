package com.callor.find;

import java.util.Optional;
import java.util.stream.Stream;

/*
 * indAny () 메서드는 스트림에서 요소를 반환하지만 
 * 반환 된 요소의 순서는 보증되지 않습니다. 
 * 아래 출력을 확인하면 프로그램은 Optional [A]를 반환하지만 
 * 다른 실행에서는 Optional [B] 또는 Optional [C]를 반환 할 수 있습니다.
 */

public class FindAny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<String> stream = Stream.of("A","B","C");
		
		Optional<String> result = stream.findAny();
		System.out.println(result);

	}

}
