package com.callor.stream.merge;

import java.util.stream.Stream;

public class MergeStream01 {

	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("A", "B", "C");
		Stream<String> stream2 = Stream.of("D", "E", "F");

		Stream<String> mergedStream = Stream.concat(stream1, stream2);
		mergedStream.forEach(stream -> System.out.println(stream));

		
		
		
	}

}
