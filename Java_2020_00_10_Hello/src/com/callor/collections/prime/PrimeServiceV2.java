package com.callor.collections.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 50 ~ 100 사이의 임의의 난수 50개를 생성하고
 * 그 중 prime 수인 값들만 list에 담고
 * list를 출력
 */
public class PrimeServiceV2 {
	
	protected Random rnd;
	protected List<Integer> primeList;	
	
	public PrimeServiceV2() {
		rnd = new Random();
		primeList = new ArrayList<Integer>();
	}
	
	
	public void printNum() {
		for(int i = 0 ; i < 50 ; i++) {
			int rndNum = rnd.nextInt(51) + 50;
			int index = 0;
			for(index = 2 ; index < rndNum ; i++) {
				if(rndNum % index == 0) {
					break;
					
				}
			}
			if(index >= rndNum) {
				primeList.add(rndNum);	
			}
		}
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
