package com.callor.bank.exec;

import com.callor.bank.service.BankService;
import com.callor.bank.service.BankServiceImpV1;

public class BankEx_01 {

	public static void main(String[] args) {

		// interface로 선언하고
		// class로 객체를 초기화 하기
		BankService bs = new BankServiceImpV1();
		String bookFile = "src/com/callor/bank/활빈당은행잔고원장.txt";

		try {
			bs.readBook(bookFile);
			bs.viewAcc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
