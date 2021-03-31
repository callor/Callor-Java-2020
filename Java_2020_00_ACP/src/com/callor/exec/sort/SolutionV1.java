package com.callor.exec.sort;

public class SolutionV1 {

	public long solution(Long n) {

		char[] chars = String.valueOf(n).toCharArray();

		for (int i = 0; i < (chars.length - 1); i++) {
			for (int j = i + 1; j > 0; j--) {
				if (chars[j] > chars[j - 1]) {
					char Temp = chars[j - 1];
					chars[j - 1] = chars[j];
					chars[j] = Temp;
				}
			}
		}
		String sortedString = new String(chars);
		long answer = Long.parseLong(sortedString);
		return answer;
	}

}
