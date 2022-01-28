package com.callor.random;

import java.util.Random;

/**
 * 
 * @author callor
 * 1 ~ 100까지의 임의의 숫자를 5개 만들고
 * 그 수가 3의 배수인지 아닌지를 판별하여 출력하시오
 */
public class RandomMutiple {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		for(int i = 0 ; i < 5 ; i++) {
			int num = rnd.nextInt(100);
			
			if(num % 3 == 0) {
				System.out.println(num + " 는(은) 3의 배수");
			} else {
				System.out.println(num + " 는(은) 3의 배수아님");
			}
		}
	}
}
