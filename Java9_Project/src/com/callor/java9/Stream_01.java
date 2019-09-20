package com.callor.java9;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.asList(1, 2, 3).stream(); // (1)
		Arrays.asList(1, 2, 3).parallelStream(); // (2)

		// stream의 요소를 순회해야 한다면 forEach를 활용할 수 있습니다.
		System.out.println("forEach");
		Arrays.asList(1, 2, 3).stream().forEach(System.out::println); // 1,2,3

		// stream의 개별 요소마다 연산을 할 수 있습니다.
		// 아래의 코드는 리스트에 있는 요소의 제곱 연산을 합니다.
		System.out.println("map");
		Arrays.asList(1, 2, 3).stream().map(i -> i * i).forEach(System.out::println); // 1,4,9

		// stream의 최초 요소부터 선언한 인덱스까지의 요소를 추출해 새로운 stream을 만듭니다.
		System.out.println("limit");
		Arrays.asList(1, 2, 3).stream().limit(1).forEach(System.out::println); // 1

		// stream의 최초 요소로부터 선언한 인덱스까지의 요소를 제외하고 새로운 stream을 만듭니다.
		System.out.println("skip");
		Arrays.asList(1, 2, 3).stream().skip(1).forEach(System.out::println); // 2,3

		// stream의 요소마다 비교를 하고 비교문을 만족하는 요소로만 구성된 stream을 반환합니다.
		System.out.println("filter");
		Arrays.asList(1, 2, 3).stream().filter(i -> 2 >= i).forEach(System.out::println); // 1,2

		// stream의 내부에 있는 객체들을 연결한 stream을 반환합니다.
		System.out.println("flatMap");
		Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9)).stream()
				.flatMap(i -> i.stream()).forEach(System.out::println); // 1,2,3,4,5,6,7,8,9

		// stream을 단일 요소로 반환합니다.
		System.out.println("reduce");
		System.out.println(Arrays.asList(1, 2, 3).stream().reduce((a, b) -> a - b).get()); // -4

		// 각의 메소드로 콜렉션 객체를 만들어서 반환합니다.
		System.out.println("Collectors");
		Arrays.asList(1, 2, 3).stream().collect(Collectors.toList());
		Arrays.asList(1, 2, 3).stream().iterator();
	}

}
