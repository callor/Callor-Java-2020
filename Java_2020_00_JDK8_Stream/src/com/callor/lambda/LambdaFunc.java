package com.callor.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunc {

	/**
	 * java 8에 포함된 람다식 함수
	 * @param args
	 */
	public static void main(String[] args) {
		
			Runnable task1 = () -> System.out.println("람다로 구현한 Thread Runnable");
			Thread thread1 = new Thread(task1);
			thread1.start();
			
			
			// 인자는 받지 않고 리턴 타입만 존재
			Supplier<Integer> supp1 = () -> 30 * 40;
			System.out.println(supp1.get());
			
			// 인자는 있으나 리턴이 없다, 매개변수 값을 소비만
			Consumer<String> cons1 = str -> System.out.println(str);
			cons1.accept("대한민국만세");
			
			// 메서드 레퍼런스 방식
			Consumer<String> cons2 = System.out::println;
			
			// 매개변수와 리턴타입이 모두 존대
			Function<String,String> func1 = String::toUpperCase;
			System.out.println(func1.apply("Republic of Korea"));
			
			// 매개변수를 받고 boolean을 리턴
			Predicate<String> pre1 = str -> str.isEmpty();
			System.out.println(pre1.test("Korea"));
			
		
		
	}
	
	
}
