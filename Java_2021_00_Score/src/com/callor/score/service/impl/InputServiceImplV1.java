package com.callor.score.service.impl;

import java.util.Scanner;

import com.callor.score.service.InputService;

public class InputServiceImplV1 implements InputService {

	protected final Scanner scan;

	public InputServiceImplV1() {
		scan = new Scanner(System.in);
	}

	public Integer inputValue(String title) {

		while (true) {

			System.out.println("=".repeat(50));
			System.out.println(title + " 값을 입력하세요(QUIT:취소)");
			System.out.print(">> ");
			String strInput = scan.nextLine();
			Integer retNum = 0;

			if (strInput.equals("QUIT")) {
				return null;
			} else {
				try {
					retNum = Integer.valueOf(strInput);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("유효한 정수값이나, QUIT를 입력하세요");
					continue;
				}
			}
			return retNum;
		}
	}

	@Override
	public Integer inputValue() {
		// TODO Auto-generated method stub
	}

	@Override
	public Integer inputValue(String title, int start, int end) {
		// prompt 문자열 다시 생성
		title = String.format("%s (%d ~ %d)", title, start, end);

		while (true) {

			Integer retNum = this.inputValue(title);
			if (retNum != null && retNum < start || retNum > end) {
				System.out.printf("입력값은 %d ~ %d " + "범위 이어야 합니다\n", start, end);
				continue;
			}
			return null;
		}
	}

}
