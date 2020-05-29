package com.callor.varriable;

public class CharHangul {

	public static void main(String[] args) {
		
		
		int count = 0 ;
		for(int i = '가' ; i <= '힣' ; i++) {
			System.out.print((char)i + "\t");
			if(i % 5 == 0) System.out.println();
			count ++;
		}
		System.out.println();
		System.out.println("개수  : " + count);
		
		
	}
	
}
