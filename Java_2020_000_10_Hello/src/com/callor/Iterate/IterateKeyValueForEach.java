package com.callor.Iterate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IterateKeyValueForEach {
	public static void main(String[] args) throws IOException {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);

		// Iterating over keys
		for (Integer key : map.keySet()) {
			System.out.println("Key = " + key);
		}

		// Iterating over values
		for (Integer value : map.values()) {
			System.out.println("Value = " + value);
		}
	}
}
