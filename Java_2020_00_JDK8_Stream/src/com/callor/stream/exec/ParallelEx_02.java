package com.callor.stream.exec;

import java.util.Date;
import java.util.stream.IntStream;

public class ParallelEx_02 {

	public static void main(String[] args) {

		IntStream.range(0, 10).parallel().forEach(index -> {
			System.out.println(
					"Starting " + Thread.currentThread().getName() + ",    index=" + index + ", " + new Date());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		});
	}
}
