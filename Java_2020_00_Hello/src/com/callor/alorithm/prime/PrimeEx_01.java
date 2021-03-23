package com.callor.alorithm.prime;

import java.util.Scanner;

public class PrimeEx_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("2 이상의 정수를 입력하세요!!");
		System.out.print(" >> ");
		int keyNum = scan.nextInt();
		
		int index = 2;
		for(index = 2 ; index  < keyNum ; index ++) {
			if(keyNum % index == 0) {
				System.out.printf("%d 는 %d 로 나누어지는 수 이므로 소수가 아님\n",keyNum,index);
				break;
			}
		}
		if(index < keyNum) {
			System.out.printf("%d 는 %d 로 나누어지는 수 이므로 소수가 아님\n",keyNum,index);	
		} else {
			System.out.printf("%d 는 소수임\n",keyNum);
		}
		
		scan.close();
	}
	
}
