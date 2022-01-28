package com.callor.stream.exec;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelEx_01 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "신용권", "김남준", "람다식", "병렬처리");
		Stream<String> stream = list.stream();
		stream.forEach(ParallelEx_01::print);

		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelEx_01::print);
	}

	public static void print(String string) {
		System.out.println(string + " : " + Thread.currentThread().getName());
	}

}
