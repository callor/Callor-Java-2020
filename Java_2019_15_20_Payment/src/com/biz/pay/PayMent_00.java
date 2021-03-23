package com.biz.pay;

/*
 * 화폐매수 계산
 */
public class PayMent_00 {

	public static void main(String[] args) {

		int pay = 3785870;
		int paper = 50000;
		
		// 5만원권 매수
		int count = (int)(pay / paper) ;// 5만원 매수
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper; // 5만원 매수를 제외한 금액
		
		// 만원권 매수
		paper = paper / 5; // 10000
		count = (int)(pay / paper); // 1만원 매수
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper; // 만원권 매수 제외한 금액
		
		// 5천원권 매수
		paper = paper / 2; // 5000원권
		count = (int)(pay /paper);
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper; // 5천원권 제외 금액
		
		paper = paper / 5;
		count = (int)(pay / paper );
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;
		
		paper = paper / 2;
		count = (int)(pay / paper);
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;
		
		paper = paper / 5;
		count = (int)(pay / paper );
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;
		
		paper = paper / 2;
		count = (int)(pay / paper);
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;

		paper = paper / 5;
		count = (int)(pay / paper );
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;

		paper = paper / 2;
		count = (int)(pay / paper);
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;

		paper = paper / 5;
		count = (int)(pay / paper );
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;

		paper = paper / 2;
		count = (int)(pay / paper);
		System.out.println(paper + "원권:" + count);
		pay = pay - count * paper;
		
		
	}

}
