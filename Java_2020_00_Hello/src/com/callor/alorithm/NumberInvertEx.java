package com.callor.alorithm;

import java.text.DecimalFormat;

/**
 * 정수 거꾸로 뒤집기
 * @author callor
 *
 */
public class NumberInvertEx {

	public static void main(String[] args) {
		
		long intNum = 39234432455599932L;

		System.out.println(intNum);
		String str = "";
		while(intNum > 0) {
			long result = intNum - ((intNum / 10) * 10);
			str += result;
			intNum /= 10;
		}
		
		intNum = Long.valueOf(str);
		System.out.println(intNum);
		
		
		
	}
	
}
