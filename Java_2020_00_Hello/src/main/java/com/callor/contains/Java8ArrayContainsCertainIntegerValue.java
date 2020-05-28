package com.callor.contains;

import java.io.IOException;
import java.util.stream.IntStream;

public class Java8ArrayContainsCertainIntegerValue {
	
	 public static void main(String[] args) throws IOException {

	        // Java 8 integer check
	        int[] array2 = new int[5];
	        System.out.println(IntStream.of(array2).anyMatch(x -> x == 0));
	    }

}
