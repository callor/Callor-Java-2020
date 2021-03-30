package com.callor.random;

import java.util.Arrays;
import java.util.Random;

/*
 * Random 클래스를 이용하여 50 ~ 100까지 중 난수 1개를 생성
 * 난수의 약수들을 구하여 배열에 저장
 * 배열에 저장된 약수들의 리스트를 출력
 */
public class RandomDivisor {
	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		int intNum = rnd.nextInt(51) + 50;
		System.out.println(intNum);
		int nCount = 0;
		for(int i = 2 ; i < intNum ; i++) {
			if(intNum % i == 0) {
				nCount++;
			}
		}
		
		int[] divisors = new int[nCount];
		int index = 0 ;
		for(int i = 2 ; i < intNum ; i++) {
			if(intNum % i == 0) {
				divisors[index++] = i; 
			}
		}
		
		System.out.println(Arrays.toString(divisors));
		
	}
	
	

}
