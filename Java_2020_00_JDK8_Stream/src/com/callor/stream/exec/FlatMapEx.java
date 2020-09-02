package com.callor.stream.exec;

import java.util.Arrays;
import java.util.List;

/*
 * 입력된 데이터(요소)들이 List<String>에 저장되어 있다고 가정하고, 
 * 요소별로 단어를 뽑아 단어 스트림으로 재생성한다. 
 * 만약 입력된 데이터들이 숫자라면 숫자를 뽑아 숫자 스트림으로 재생성한다.
 */
public class FlatMapEx {
	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		inputList1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(System.out::println);
		
		System.out.println();
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputList2.stream().flatMapToInt(data -> {
			String[] strArray = data.split(",");
			int[] intArray = new int[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				intArray[i] = Integer.parseInt(strArray[i].trim());
			}
			return Arrays.stream(intArray);
		}).forEach(System.out::println);
	}
}
