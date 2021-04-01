package com.callor.Iterate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IterateLambda {

	public static void main(String[] args) throws IOException {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
	}
}