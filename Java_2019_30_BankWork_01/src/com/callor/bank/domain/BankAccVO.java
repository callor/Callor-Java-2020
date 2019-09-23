package com.callor.bank.domain;

/*
 * 은행 계좌정보를 담을 class
 * 계좌번호, num,	String
 * 현잔액, balance,	int
 * 최종거래, lastDate, String
 * 거래방법, remark, String
 * =========================================
 * 계좌번호	현잔액	최종거래	거래방법
 * ----------------------------------------
 * 0001		100000	2019-09-23	입금
 * 0002		150000	2019-09-23	출금
 */
public class BankAccVO {

	private String num;
	private int balance;
	private String lastDate;
	private String remark;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
