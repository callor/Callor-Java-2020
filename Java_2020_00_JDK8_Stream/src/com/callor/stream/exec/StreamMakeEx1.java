package com.callor.stream.exec;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.callor.stream.domain.Student;

public class StreamMakeEx1 {

	public static int sum;
	
	public static void main(String[] args) {

		// Collection으로 부터 가져오기
		List<Student> studentList = Arrays.asList(new Student("홍길동", 10), new Student("김길동", 20),
				new Student("남길동", 30));

		Stream<Student> stream = studentList.stream();
		stream.forEach(s -> System.out.println(s.getName()));

		// 배열로 부터 가져오기
		String[] stringArray = { "홍길동", "신용권", "김미나" };
		Stream<String> stringStream = Arrays.stream(stringArray);
		stringStream.forEach(a -> System.out.print(a + ","));
		System.out.println();

		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(a -> System.out.print(a + ","));



		IntStream stream1 = IntStream.rangeClosed(1, 100);
		// IntStream stream = IntStream.range(1, 100); //범위에 100이 포함되지 않음
		stream1.forEach(a -> sum += a);
		System.out.println("총합: " + sum);

	}
}


