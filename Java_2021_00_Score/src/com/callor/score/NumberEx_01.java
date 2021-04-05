package com.callor.score;

import com.callor.score.service.NumberServiceV1;

public class NumberEx_01 {
	
	public static void main(String[] args) {
		NumberServiceV1 nsV1 = new NumberServiceV1();
		Integer retNum = nsV1.inputNum("새우깡");
		System.out.println("새우깡 가격 : " + retNum);
	}
	

}
