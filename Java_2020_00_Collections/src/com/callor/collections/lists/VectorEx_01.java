package com.callor.collections.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/*
 * Vector란?
 * Vector는 ArrayList와 동일한 내부구조를 가지고 있다.
 * ArrayList와 마찬가지로 Vector내부에 값이 추가되면 자동으로 크기가 조절되며 
 * 그다음 객체들은 한 자리씩 뒤로 이동된다.
 * 하지만 모든 것이 다 똑같은 것은 아니고 
 * 
 * Vector와 Arraylist의 한가지 다른 점이 있는데 
 * Vector는 동기화된 메소드로 구성되어 있기 때문에 
 * 멀티 스레드가 동시에 이 메소드들을 실행할 수 없고, 
 * 하나의 스레드가 실행을 완료해야만 
 * 다른 스레드들이 실행할 수 있다. 
 * 그래서 멀티 스레드 환경에서 안전하게 객체를 추가하고 삭제할 수 있다
 * 
 * 
 * Vector의 단점 (ArrayList와의 비교)
 * 벡터는 항상 동기화되는 장점이자 단점이 있다.
 * 
 * 스레드가 1개일때도 동기화를 하기 때문에 
 * ArrayList보다 성능이 떨어진다.
 *  Arraylist는 기본적인 기능은 벡터와 동일하나 자동 동기화 기능이 빠져있고, 
 *  동기화 옵션이 존재한다.
 *  
 *  그리고 벡터에 비해 속도가 더 빠르기 때문에 벡터에 비해 많이 쓰이고 있다.
 * 
 * 
 */


public class VectorEx_01 {
	
	public static void main(String[] args) {
		List<Integer> intVector = new Vector<Integer>();
		List<Integer> intList = new ArrayList<Integer>();
		Random rnd = new Random();

		System.out.println("Vector Start");
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 1000_000 ; i++) {
			intVector.add(rnd.nextInt(100));
		}
		long end = System.currentTimeMillis();
		System.out.printf("Vector End 시작시각 : %d, 종료시각 :  %d, 계산시각  %d\n\n",start,end, end - start);
		
		System.out.println("List Start");
		start = System.currentTimeMillis();
		for(int i = 0 ; i < 1000_000 ; i++) {
			intList.add(rnd.nextInt(100));
		}
		end = System.currentTimeMillis();
		System.out.printf("List End 시작시각 : %d, 종료시각 :  %d, 계산시각  %d\n",start,end, end - start);

		
		
		int count = 0 ;
		for(Integer i : intList) {
			// System.out.printf("%03d\t",i );
		}
		
		
	}
	
	

}
