package com.callor.character;

public class CharAlpha {

	public static void main(String[] args) {
		
		int intCount = 0 ;
		for(int i = '0' ; i <= 'z' ; i++) {
			System.out.printf("%c\t",i);
			if(++intCount % 5 == 0)System.out.println();
			
		}
		System.out.println("\n=================================");
		for(int i = '0' ; i <= '9' ; i++) {
			System.out.printf("%c\t",i);
			if(++intCount % 5 == 0)System.out.println();
			
		}
		System.out.println("\n=================================");
		for(int i = 'A' ; i <= 'Z' ; i++) {
			System.out.printf("%c\t",i);
			if(++intCount % 5 == 0)System.out.println();
			
		}
		System.out.println("\n=================================");
		for(int i = 'a' ; i <= 'z' ; i++) {
			System.out.printf("%c\t",i);
			if(++intCount % 5 == 0)System.out.println();
			
		}
		System.out.println("\n=================================");	
	}
	
}
