package com.callor.score;

import com.callor.score.service.impl.InputServiceImplV1;

public class NumberEx_01 {
	public static void main(String[] args) {
		InputServiceImplV1 nsV1 = new InputServiceImplV1();
		Integer retNum = nsV1.inputValue("새우깡");
		System.out.println("새우깡 가격 : " + retNum);
	}
}
