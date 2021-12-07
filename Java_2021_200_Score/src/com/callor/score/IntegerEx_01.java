package com.callor.score;

import java.util.ArrayList;
import java.util.List;

public class IntegerEx_01 {
	


	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		List<String> strList = new ArrayList<String>();

		Integer num = 300;
		intList.add(num);
		
		num = 200;
		intList.add(num);
		
		System.out.println(intList);
		
		String str = new String("대한민국");
		strList.add(str);
		
		str = "우리나라";
		strList.add(str);
		
		System.out.println(strList);
		
	}

}
