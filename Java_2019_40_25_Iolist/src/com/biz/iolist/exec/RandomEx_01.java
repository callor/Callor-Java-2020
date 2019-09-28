package com.biz.iolist.exec;

public class RandomEx_01 {

	public static void main(String[] args) {
		
		for(int i = 0 ; i < 10 ; i++) {
			/*
			 * 0부터 1미만의 값을 double 형으로 생성하는 method
			 */
			double rnd1 = Math.random();	
			System.out.println(rnd1);
		}

		int start = 10;
		int end = 55;
		for(int i = 0 ; i < 10 ; i++) {
			/*
			 * 0부터 1미만의 값을 double 형으로 생성하는 method
			 */
			double rnd1 = Math.random();
		
			// start ~ end 까지 범위의 임의 수를 생성하라
			int num = (int)(rnd1 * (end - start + 1) + start);
			System.out.println(num);
		
		}

		
		
		
	}
	
}
