package com.callor.bank.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.callor.bank.util.BankInfo;

public class BankServiceImpV2 extends BankServiceImpV1 {

	
	/*
	 * 1. 앞에서 조회된 계좌번호가 유효하지 않으면 method 종료
	 * 		bookVO가 null 이면 계좌번호가 유효하지 않다.
	 * 2. 키보드로 출금액을 입력받고
	 * 3. 음수이면 출금 거부!!
	 * 		입력받은 값 < 0 이면 거부
	 * 4. 잔액 >= 출금 이면 출금 처리
	 * 5. 	아니면 출금 거부
	 */
	@Override
	public void output()  throws Exception{
		// TODO 출금처리
		if(bookVO == null ) return;
		
		System.out.print("출금액>> ");
		String strOutput = scanner.nextLine();
		int intOutput = Integer.valueOf(strOutput);
		if(intOutput < 0) {
			System.out.println("출금액은 0 이상이어야 함!!");
			return;
		}
		// 출금액 > 잔액 ?
		if(bookVO.getBalance() < intOutput) {
			System.out.println("잔액부족!!");
			return;
		}
		bookVO.setBalance(bookVO.getBalance() - intOutput);
		
		// 거래일자, 구분 설정
		// java 1.8에서 새롭게 등장한 날짜 클래스
		// Date 클래스에서 발생한 날짜 관련 여러가지 이슈가
		// 상당부분 해소된 새로운 클래스
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter df 
				= DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String lastDate = localDate.format(df);
		bookVO.setLastDate(lastDate);
		bookVO.setRemark(BankInfo.REMARK.OUTPUT);
		this.accListWrite(BankInfo.REMARK.OUTPUT,intOutput);
		this.bookWrite(bookFile);
	}
	
}
