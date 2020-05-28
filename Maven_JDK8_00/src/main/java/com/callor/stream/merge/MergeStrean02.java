package com.callor.stream.merge;

import java.util.stream.Stream;

public class MergeStrean02 {

	
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("A","B","C");
		Stream<String> stream2 = Stream.of("D","E","F");
		Stream<String> stream3 = Stream.of("G","H","I");
		Stream<String> stream4 = Stream.of("J","K","L");
		
		Stream<String> mergedStream = Stream.of(stream1, stream2, stream3, stream4).flatMap(i -> i);
		mergedStream.forEach(stream -> System.out.println(stream));
		
	}
	
}
