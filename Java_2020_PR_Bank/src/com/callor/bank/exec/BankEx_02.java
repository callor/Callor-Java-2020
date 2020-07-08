package com.callor.bank.exec;

import com.callor.bank.service.BankService;
import com.callor.bank.service.BankServiceImplV3;

public class BankEx_02 {

	public static void main(String[] args) {
		
		BankService bService = new BankServiceImplV3();
		bService.listBalance();
		
	}
}
