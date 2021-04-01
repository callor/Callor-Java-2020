package com.callor.Iterate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateGeneric {

	public static void main(String[] args) throws IOException {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);

		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = entries.next();
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
}
