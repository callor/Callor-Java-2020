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
		
		String[] strNames = {
				"홍기동",
				"이몽룡",
				"성춘향",
				"장녹수",
				"임꺽정",
				"장보고"
				};
		System.out.println(Arrays.toString(strNames));
		

	}

}
