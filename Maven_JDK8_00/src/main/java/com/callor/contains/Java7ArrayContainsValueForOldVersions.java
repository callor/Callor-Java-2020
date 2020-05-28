package com.callor.contains;

import java.io.IOException;
import java.util.Arrays;

public class Java7ArrayContainsValueForOldVersions {

	public static void main(String[] args) throws IOException {

		// Check an array contains a certain value?
		String[] array = { "hello", "world" };

		System.out.println(Arrays.toString(array));

		// Java old way
		System.out.println(Arrays.asList(array).contains("world"));

	}

}
