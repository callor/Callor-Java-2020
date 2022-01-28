package com.callor.exec.sort;

public class NumberSort {

	/*
	 * 함수 solution은 정수 n을 매개변수로 입력받습니다. 
	 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
	 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
	 */
	public static void main(String[] args) {
		
		SolutionV1 soV1 = new SolutionV1();
		long result = soV1.solution(3929195654654391L);
		System.out.println(result);
		
		SolutionV1 soV2 = new SolutionV1();
		result = soV2.solution(3929195654654391L);
		System.out.println(result);

		
	}
	
}

