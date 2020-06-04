package com.callor.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomClassChar {

	public static void main(String[] args) {
		Random rnd = new Random();
		
		
		float fNum = rnd.nextFloat();
		System.out.println(fNum);
		
		int intNum = (int)((fNum * 65) + 60);
		System.out.println(intNum);

		for(int i = 0 ; i < 10 ; i++) {
			fNum = rnd.nextFloat();
			intNum = (int)((fNum * 26) + 'A');
			System.out.print((char)intNum +",");
		}
		System.out.println();

		for(int i = 0 ; i < 10 ; i++) {
			fNum = rnd.nextFloat();
			intNum = (int)((fNum * 26) + 'a');
			System.out.print((char)intNum +",");
		}
		
		System.out.println();
		for(int i = 0 ; i < 10 ; i++) {
			intNum = rnd.nextInt(26) + 'A';
			System.out.print((char)intNum +",");
		}
		System.out.println();

		
		List<String> nameList = new ArrayList<>();
		for(int i = 0 ; i < 10 ; i++) {

			String str = "";
			for(int j = 0 ; j < 5 ; j++) {
				intNum = rnd.nextInt(26) + 'A';
				str += ""+ (char)intNum;
			}
			nameList.add(str);
			System.out.println(str);
			
		}
		
		for(int i = 0 ; i < nameList.size() ; i++) {
			System.out.println(nameList.get(i));
		}
		
		
		
	}
}
