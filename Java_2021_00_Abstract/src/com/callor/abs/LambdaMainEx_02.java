package com.callor.abs;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.UnaryOperator;

/*
 * java 내장 인터페이스를 이용한 lambda
 *
 * java.lang.Runnable	void run()	매개변수도 없고, 반환값도 없음
 * Supplier	T get()	매개변수는 없고, 반환값만 있음
 * Consumer	void accept(T t)	
 * 			Supplier와 반대로 매개변수만 있고, 반환값이 없음
 * Function	R apply(T t)	일반적인 함수. 하나의 매개변수를 받아서 결과를 반환
 * Predicate	boolean test(T t)	조건식을 표현하는데 사용. 
 * 			매개변수는 하나, 반환 타입은 boolean
 * BiConsumer	void accept(T t, U u)	
 * 			두개의 매개변수만 있고, 반환값이 없음
 * BiPredicate	boolean test(T t, U u)	
 * 			조건식을 표현하는데 사용됨. 
 * 			매개변수는 둘, 반환값은 boolean
 * BiFunction	R apply(T t, U u)	
 * 			두개의 매개변수를 받아서 하나의 결과를 반환
 * 
 * 수학에서 결과로 true 또는 false를 반환하는 함수를 Predicate 라고 한다.
 * 매개변수가 2개인 함수형 인터페이스는 이름 앞에 ‘Bi’가 붙는다.
 * Supplier는 매개변수는 없고 반환값만 존재하는데 메서드는 
 * 두 개의 값을 반환할 수 없으므로 BiSupplier가 없다.
 * 매개변수의 타입과 반환타입이 일치할 때는 
 * Function 대신 UnaryOperator를 사용한다. (매개 변수 2개면 BinaryOperator)
 * 
 * 
 */

public class LambdaMainEx_02 {

	public static void main(String[] args) {

		Runnable runF1 = ()->System.out.println("대한민국만세");
		runF1.run();
		
		
		// 한개의 매개변수와 return, 
		// 매개변수과 return 타입이 동일
		UnaryOperator<String> unStr = (str1)-> String.format("%s 님 환영",str1);
		System.out.println(unStr.apply("홍길동"));
		
		// 한개의 매개변수와 return
		// 정수형 매개변수, 문자여형 return
		Function<Integer,Integer> f1 = (num1)-> num1 * num1;
		System.out.println(f1.apply(100));
		
		// 한개의 매개변수와 return
		// 정수형 매개변수, 문자열형 return
		Function<Integer,String> f2 = (num1)-> String.format("%d * %d = %d",num1,num1,num1 * num1);
		System.out.println(f2.apply(100));

		// 정수형 매개변수와 정수형 return
		IntFunction<Integer> intF1 = (num1)->num1 * 100;
		System.out.println(intF1.apply(200));
		
		// Long형 매개변수와 Long형 return
		LongFunction<Long> longF1 = (num1)->num1 * num1;
		System.out.println(longF1.apply(100L));
		
		
		// 동일한 유형의 두 피연산자에 대한 연산을 나타내며 
		// 피연산자와 동일한 유형의 결과를 생성합니다.
		BinaryOperator<String> stringSum=(x, y)->x+" "+y;
		System.out.println(stringSum.apply("Welcome","Callor Home"));
		
		// 두개의 매개변수, 1개의 return
		// 매개변수, return 타입이 모두 다를때
		BiFunction<Integer, Integer, String> biF1 
			= (num1, num2)->String.format("%d * %d = %d",num1,num2, num1 * num2);
		System.out.println(biF1.apply(200, 300));
		
		
		
		
		
		
		
	}

	

	
}
