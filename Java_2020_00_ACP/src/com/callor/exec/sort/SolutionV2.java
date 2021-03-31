package com.callor.exec.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionV2 {
	public long solution(long n) {

		// 정수를 문자열로 변경한 후 문자 배열로 만들고
		// Arrays.sort() 메서드를 사용하여 정렬수행

		String str = String.valueOf(n);
		char[] charArray = str.toCharArray();

		Character[] myCharArr = new Character[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			myCharArr[i] = charArray[i];
		}
		Arrays.sort(myCharArr, new Comparator<Character>() {

			@Override
			public int compare(Character char1, Character char2) {
				return char1.compareTo(char2);
			}
		});
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = myCharArr[i];
		}
		String sortString = new String(charArray);
		long answer = Long.parseLong(sortString);
		return answer;
	}
}
