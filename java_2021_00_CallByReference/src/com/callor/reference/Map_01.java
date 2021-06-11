package com.callor.reference;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {

	public static void main(String[] args) {

		Map<String,String> strMap = new HashMap<String,String>();
		System.out.println(strMap.toString());
		
		// map을 매개변수로 전달 1
		addMap(strMap);
		
		// addMap에서 매개변수로 전달받은 map에 요소를 일부 추가했다
		// 전달하기 전의 strMap에 데이터 변화가 생겼다
		System.out.println(strMap.toString());
		
		// map을 매개변수로 전달 1
		newMap(strMap);
		
		// newMap에서 매개변수로 전달받은 map을 새롭게 생성하고 데이터를 추가했다
		// 전달하기 전의 strMap에 데이터 변화가 없다
		System.out.println(strMap.toString());
				
	}
	
	private static void addMap(Map<String,String> maps) {
		maps.put("name","홍길동");
	}
	
	private static void newMap(Map<String,String> maps) {
		maps = new HashMap<String,String>();
		maps.put("tel","010-111-111");
	}
	
	
}
