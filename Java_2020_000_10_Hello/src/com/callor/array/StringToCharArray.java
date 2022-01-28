package com.callor.array;

public class StringToCharArray {

	public static void main(String[] args) {
		String strNation = "대한민국만세";

		char[] charNations = strNation.toCharArray();

		for (int i = 0; i < charNations.length; i++) {
			System.out.printf("%c\t", charNations[i]);
		}
		System.out.println();

		int count = 0;
		for (char c : charNations) {
			System.out.printf("%c\t", c);
			if (++count % 5 == 0)
				System.out.println();

		}
	}
}
