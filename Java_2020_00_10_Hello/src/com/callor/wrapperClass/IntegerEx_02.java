package com.callor.wrapperClass;

public class IntegerEx_02 {
	
	public static void main(String[] args) {
		System.out.printf("정수30은 bit 1 이 %d 개\n",Integer.bitCount(30));
		System.out.printf("65를 2진수로: %s\n", Integer.toString(65,2));
		System.out.printf("65를 8진수로: %s\n", Integer.toString(65,8));
		System.out.printf("65를 16진수로: %s\n", Integer.toString(65,16));
		System.out.println("이진수 101을 십진수로 : "+Integer.parseInt("101", 2));
		System.out.println("이진수 101을 십진수로 : "+Integer.valueOf("101", 2));
		System.out.printf("%d 와 %d 중 큰 수는 %d\n",30,50,Integer.max(30,50));
		System.out.printf("%d 와 %d 중 작은 수는 %d\n",30,50,Integer.min(30,50));
		
		System.out.println("정수 55를 이진수로 표현했을때 비트가 1인 가장 큰값");
		System.out.println(Integer.highestOneBit(55));
		
	}
	
	

}
