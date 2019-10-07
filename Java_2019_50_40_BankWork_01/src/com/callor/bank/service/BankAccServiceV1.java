package com.callor.bank.service;

import java.util.Scanner;

import com.callor.bank.domain.BankAccVO;

/*
 * 1개의 계좌에 대한 처리를 수행할 클래스
 */
public class BankAccServiceV1 implements BankAccService{

	BankAccVO bankAccVO;
	Scanner scanner;

	public BankAccServiceV1(String strNum, int intBalance) {
		scanner = new Scanner(System.in);
		bankAccVO = new BankAccVO();
		bankAccVO.setNum(strNum);
		bankAccVO.setBalance(intBalance);
	}
		
	/*
	 * 키보드에서 계좌번호를 입력받아서
	 * vo에 담긴 계좌번호가 일치하면
	 * 		계좌 내용을 보여주고 true를 return
	 * 그렇지 않으면
	 * 		false를 return 
	 */
	@Override
	public boolean viewAcc() {
		System.out.print("계좌번호>>");
		// 키보드에서 계좌번호를 입력받기.
		String strAccNum = scanner.nextLine();
		if(!strAccNum.equals(bankAccVO.getNum())) {
			System.out.println("계좌번호가 오류!!");
			return false;
		}
		System.out.println("=================");
		System.out.println("계좌번호:"+bankAccVO.getNum());
		System.out.println("최종잔액:"+bankAccVO.getBalance());
		System.out.println("최종거래:"+bankAccVO.getLastDate());
		System.out.println("비고:"+bankAccVO.getRemark());
		System.out.println("=================");
		return true;
	}
	
	@Override
	public void input() {
		// 계좌정보가 맞으면 입금진행
		if(this.viewAcc()) {

			System.out.print("입금액");
			// 키보드에서 입금액 입력받기
			String strInput = scanner.nextLine();
			int intInput = Integer.valueOf(strInput);
			
			// 입력받은 입금액을 총잔액에 합산(+)하기
			// bankAccVO에 담긴 balance를 getter하여 input값과 합산하고
			// bankAccVO에 balance를 setter 하기
			bankAccVO.setBalance(bankAccVO.getBalance() + intInput);
		};
	}
	
	@Override
	public void output() {
		if(this.viewAcc()) {
			System.out.print("출금액");
			// 키보드에서 출금액 입력받기
			String strOutput = scanner.nextLine();
			int intOutput = Integer.valueOf(strOutput);
			
			// 총잔액과 출금액을 비교하여
			// 총잔액 >= 출금액 이면
			int intBalance = bankAccVO.getBalance();
			if(intBalance >= intOutput) {
				// 입력받은 출금액을 총잔액에서 감산(-)하기
				intBalance -= intOutput;
				bankAccVO.setBalance(intBalance);
			}
		}
	}

	@Override
	public void bankBookList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeAccBook(String bookFileName) {
		// TODO Auto-generated method stub
		
	}
	
}
