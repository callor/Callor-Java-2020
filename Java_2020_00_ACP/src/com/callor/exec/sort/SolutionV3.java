package com.callor.exec.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionV3 {

	public long solution(long n) {

		// 정수를 문자열로 변경한 후 문자열 배열로 만들고
		// Arrays.sort() 메서드를 사용하여 정렬수행
		String str = String.valueOf(n);
		String[] nums = str.split("");
		
		Arrays.sort(nums,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		
		// str = new String(nums);
		return 0;
		
	}
	
}
