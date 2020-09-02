package com.callor.stream.exec;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LoopEx {

	public static void main(String[] args) {
		
		int[] intArr = { 1, 2, 3, 4, 5 };
		System.out.println("[peek()를 마지막에 호출한 경우]");
		Arrays.stream(intArr).filter(a -> a % 2 == 0).peek(System.out::println); // 동작하지 않는다.

		System.out.println();
		System.out.println("[최종 처리 메소드를 마지막에 호출한 경우]");
		int sum = Arrays.stream(intArr).filter(a -> a % 2 == 0).peek(System.out::println).sum();
		System.out.println("총합: " + sum);
		
		System.out.println("[forEach()를 마지막에 호출한 경우]");
		Arrays.stream(intArr).filter(a -> a % 2 == 0).forEach(System.out::println);
		
		IntStream stream1 = IntStream.rangeClosed(1, 100);
		stream1.filter(a -> a % 2 == 0).forEach(System.out::println);
		

	}

}
