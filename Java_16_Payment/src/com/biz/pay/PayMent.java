package com.biz.pay;

/*
 * 화폐매수 계산
 */
public class PayMent {

	public static void main(String[] args) {

		int pay = 3785870;
		int mo = 50000;
		
		// 5만원권 매수
		int count = (int)(pay / mo) ;// 5만원 매수
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo; // 5만원 매수를 제외한 금액
		
		// 만원권 매수
		mo = mo / 5; // 10000
		count = (int)(pay / mo); // 1만원 매수
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo; // 만원권 매수 제외한 금액
		
		// 5천원권 매수
		mo = mo / 2; // 5000원권
		count = (int)(pay /mo);
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo; // 5천원권 제외 금액
		
		mo = mo / 5;
		count = (int)(pay / mo );
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;
		
		mo = mo / 2;
		count = (int)(pay / mo);
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;
		
		mo = mo / 5;
		count = (int)(pay / mo );
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;
		
		mo = mo / 2;
		count = (int)(pay / mo);
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;

		mo = mo / 5;
		count = (int)(pay / mo );
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;

		mo = mo / 2;
		count = (int)(pay / mo);
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;

		mo = mo / 5;
		count = (int)(pay / mo );
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;

		mo = mo / 2;
		count = (int)(pay / mo);
		System.out.println(mo + "원권:" + count);
		pay = pay - count * mo;
		
		
	}

}
