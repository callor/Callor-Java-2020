package com.callor.alorithm;

/*
 * 정수의 자릿수 구하기
 */
public class DigitLenthEx_01 {
	
	public static void main(String[] args) {
				
		int intNum = 32786;
		int nCount = 0;
		System.out.printf("%d의 ",intNum);
		while(intNum > 0) {
			intNum /= 10;
			nCount ++;
		}
		System.out.printf("자릿수 %d\n",nCount);
	}

}
