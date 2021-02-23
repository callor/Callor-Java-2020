package com.callor.alorithm;

import java.util.Random;

public class PrimeEx_03 {

	public static void main(String[] args) {

		
		Random rnd = new Random();
		for(int i = 0 ; i < 10 ; i++) {
			int num = rnd.nextInt(100) + 2;
			int j = 0;
			for(j = 2 ; j < num ; j++) {
				if(j % num == 0) break;
			}

			if(j >= num) {
				System.out.printf("%d 는 소수입니다\n",num);
			} else {
				System.out.printf("%d 는 소수가 아닙니다\n",num);
			}
		}
	}

}
