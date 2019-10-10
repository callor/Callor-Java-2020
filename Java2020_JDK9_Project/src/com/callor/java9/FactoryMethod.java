package com.callor.java9;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point> list = List.of(new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4));

		Set<String> set = Set.of("a", "b", "c");

		Map<Integer, Integer> map= Map.of();
		System.out.println(map);
		
		Map<String, Integer> map1 =  Map.of("Kor", 20);
		System.out.println(map1);
//		                         Map.of(k1, v1, k2, v2)
//		                         Map.of(k1, v1, k2, v2, k3, v3)
//		                         ...

		Map<String, Integer> map2 = Map.ofEntries(
		    Map.entry("Ã¶¼ö:", 20),
		    Map.entry("¿µÈñ:", 30),
		    Map.entry("¸Í¹Ú", 40),
//		    // ...
		    Map.entry("ÁØÇ¥", 99));
		System.out.println(map2);
		
		
		
	}

}
