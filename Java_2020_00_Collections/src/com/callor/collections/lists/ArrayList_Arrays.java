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
		String[] strNationsCopy = (String[]) strNationList.toArray();
		
		for(String s : strNationsCopy) {
			System.out.print(s + " ");
		}
		
		
	}
	
	
}
