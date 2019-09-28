package com.biz.method;

public class MethosEx_02 {

	/*
	 * 1. 콘솔에 대한민국만세 문자열을 10번 출력
	 * 2. 가. 콘솔에 대한민국만세를 5번 출력하고,
	 * 	  나. 줄을 하나 표시하고
	 * 	  다. 다시 콘술에 대한민국만세를 3번 출력
	 * 3. 마음이 바뀌어서 대한민국만세 문자열 대신에
	 * 		Republic of Korea를 같은 방법으로 콘솔에 출력하고자 한다.
	 */
	public static void main(String[] args) {
		
		//3번까지 코드를 수행하고 봤더니
		// 또 문자열을 변경할 일이 있을 것 같다.
		String strNation = "Respublic of Korea";

		//1
		for(int i = 0 ; i < 10 ; i++) {
			// System.out.println("대한민국만세");
			System.out.println(strNation);
		}
		//2
		for(int i = 0 ; i < 5 ; i++) {
			// System.out.println("대한민국만세");
			System.out.println(strNation);
		}
		System.out.println("=================");
		for(int i = 0 ; i < 3 ; i++) {
			// System.out.println("대한민국만세");
			System.out.println(strNation);
		}
		
		
	}

}
