package com.callor.collections.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 50 ~ 100 사이의 임의의 난수 50개를 생성하고
 * 그 중 prime 수인 값들만 list에 담고
 * list를 출력
 */
public class PrimeServiceV1 {
	
	protected Random rnd;
	protected List<Integer> primeList;	
	
	public PrimeServiceV1() {
		rnd = new Random();
		primeList = new ArrayList<Integer>();
	}
	
	
	public void printNum() {
		for(int i = 0 ; i < 50 ; i++) {
			int num = rnd.nextInt(51) + 50;
			if(isPrime(num)) {
				primeList.add(num);
			}
		}
	}
	
	private boolean isPrime(int num) {
		
		for(int i = 2 ; i < num ; i++) {
			if(num % 2 == 0) return false; 
		}
		return true;
		
	}
	
	public void printPrimeNum() {
		
		System.out.println("소수 개수 : " + primeList.size());
		int nCount = 0;
		for(Integer prime : primeList) {
			System.out.print( prime + "\t");
			if(++nCount  % 5 == 0) System.out.println();
		}
		System.out.println();
	}

}
