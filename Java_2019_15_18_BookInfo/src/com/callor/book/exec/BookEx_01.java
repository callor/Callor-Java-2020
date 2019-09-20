package com.callor.book.exec;

import com.callor.book.model.BookVO;

public class BookEx_01 {

	public static void main(String[] args) {

		// 도서정보 1개를 데이터로 만들기
		BookVO bookVO = new BookVO();

		// 도서정보 데이터 저장
		bookVO.setStrNum("970001");
		bookVO.setStrName("Do It Java");
		bookVO.setStrWriter("박은종");
		bookVO.setStrComp("이지퍼블리싱");
		bookVO.setIntPrice(25000);
		bookVO.setIntPubYear(2018);
		
		// 저장된 정보를 확인
		System.out.println("ISBN : " + bookVO.getStrNum());
		System.out.println("도서명 : " + bookVO.getStrName());
		System.out.println("저자 : " + bookVO.getStrWriter());
		System.out.println("출판사 : " + bookVO.getStrComp());
		System.out.println("가격 : " + bookVO.getIntPrice());
		System.out.println("출판연도 : " + bookVO.getIntPubYear());
		
	}
	
}
