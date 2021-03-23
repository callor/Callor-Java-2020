package com.callor.alorithm.prime;

import java.util.Random;

public class PrimeEx_02 {

	public static void main(String[] args) {

		Random rnd = new Random();
		
//		int rndNum = rnd.nextInt(Integer.MAX_VALUE - 2) + 2;
		int rndNum = rnd.nextInt(1000) + 1;
		
		int index = 0;
		for(index = 2; index < rndNum ; index ++) {
			if(rndNum % index == 0) {
				break;
			}
		}
		
		if(index < rndNum) {
			System.out.printf("난수 %d 는 %d 로 나누어지는 수 이므로 소수가 아님\n",rndNum,index);	
		} else {
			System.out.printf("난수 %d 는 소수임\n",rndNum);
		}
		
		
	}

}
