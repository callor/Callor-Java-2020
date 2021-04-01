package com.callor.contains;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Java8ArrayContainsCertainStringValue {
	
	
	  public static void main(String[] args) throws IOException {

	        // Check an array contains a certain value?
	        String[] array = { "hello", "world" };

	        System.out.println(Arrays.toString(array));
	        
	        // Java 8 string check
	        System.out.println(Stream.of(array).anyMatch(x -> x == "world"));
	        System.out.println(Stream.of(array).anyMatch(x -> x.equals("world") ));

	    }

}
