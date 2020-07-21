package com.callor.collections.maps;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private Map<Integer, BigInteger> memoizeHashMap = new HashMap<>();
	
	
	// default 생성자
	{
		memoizeHashMap.put(0, BigInteger.ZERO);
		memoizeHashMap.put(1, BigInteger.ONE);
		memoizeHashMap.put(2, BigInteger.ONE);
	}

	private BigInteger fibonacci(int n) {
		if (memoizeHashMap.containsKey(n)) {
			return memoizeHashMap.get(n);
		} else {
			BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
			memoizeHashMap.put(n, result);
			return result;
		}
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i < 100; i++) {
			System.out.println(fibonacci.fibonacci(i));
		}
	}

}
