package com.callor.collections.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList_Arrays {

	public static void main(String[] args) {
		
		
		String[] strNations = {"대한민국","우리나라","조선","고려","신라","백제","고구려","가야","발해"};
		
		
		// 배열을 리스트로
		List<String> strNationList = new ArrayList<String>(Arrays.asList(strNations));
		
		// 리스트를 배열로
		// toArray() 매개변수로 length가 0인 type 변수를 전달해 주어야 한다.
		String[] strNationsCopy = strNationList.toArray(new String[0]);
		
		for(String s : strNationsCopy) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println(String.format("%0100d",0).replace("0", "="));
		
	}
	
	
}
