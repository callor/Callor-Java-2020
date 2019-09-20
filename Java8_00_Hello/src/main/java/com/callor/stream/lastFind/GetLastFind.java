package com.callor.stream.lastFind;

import java.util.Arrays;
import java.util.List;

public class GetLastFind {

	public static void main(String[] args) {

		// case 1
		List<String> list = Arrays.asList("A", "B", "C", "D");
		list.stream().reduce((a, b) -> b).ifPresent(s -> System.out.println(s));

		// case 2
		list = Arrays.asList();
		System.out.println(list.stream().reduce((a, b) -> b).orElse("E"));

		// case 3
		list.stream().reduce((a, b) -> b).orElseThrow(() -> new IllegalStateException("no last element"));

	}

}
