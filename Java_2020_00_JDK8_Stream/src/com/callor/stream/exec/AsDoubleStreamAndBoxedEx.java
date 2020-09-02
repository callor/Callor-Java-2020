package com.callor.stream.exec;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * asDoubleStream()
 * IntStream()의 int요소 또는 LongStream의 long요소를 double요소로 타입 변환해서 DoubleStream을 생성
 * 
 * asLongStream()
 * IntStream()의 int요소를 long요소로 타입 변환해서 LongStream을 생성
 * 
 * boxed()
 * int요소, long요소, double요소를 Integer, Long, Double요소로 박싱해서 Stream을 생성
 */
public class AsDoubleStreamAndBoxedEx {

	public static void main(String[] args) {
		
		int[] intArray = { 1, 2, 3, 4, 5 };

		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream().forEach(a->System.out.print(a +"\t"));
		System.out.println();

		intStream = Arrays.stream(intArray);
		intStream.asLongStream().forEach(a->System.out.print(a +"\t"));
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(System.out::print);

	}
}
