package com.callor.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx_01 {

	public static void main(String[] args) {

		// key, value 쌍의 자료구조
		Map<Integer, String> intMap = new HashMap<Integer, String>();

		// Map 에 데이터 추가
		intMap.put(1, "대한민국");
		intMap.put(2, "우리나라");
		intMap.put(3, "Republic of Korea");

		// Map 에서 key 값으로 조회
		System.out.println(intMap.get(3));

		// for 를 사용하기 위해서는 Map 의 키값을 Set 객체로 추출해야 한다
		Set<Integer> keys = intMap.keySet();

		// Map 모든 요소의  Value 값 출력
		for (Integer key : keys) {
			System.out.printf("%d => %s\n",key,intMap.get(key));
		}

		System.out.println();
		// or 람다식으로 표현
		keys.forEach(key -> System.out.println(intMap.get(key)));

		// 모든 key와 value를 같이 print하는 방법
		Set<Map.Entry<Integer, String>> entries = intMap.entrySet();

		for (Map.Entry<Integer, String> entry : entries) {
		  System.out.print("key: "+ entry.getKey());
		  System.out.println(", Value: "+ entry.getValue());
		}
		
		// or (lambda expression)
		System.out.println("\n람다식으로 표현");
		intMap.forEach((key, value) -> {
		  System.out.print("key: "+ key);
		  System.out.println(", Value: "+ value);
		});
		
		
		
	}

}
