package com.callor.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.book.model.BookVO;

public class BookServiceImpV2 implements BookService {

	Scanner scan; // 키보드에서 값 입력받기 위한 준비
	
	// 입력받은 도서 정보 리스트 저장할 준비
	List<BookVO> bookList; 
	
	// 생성자 메서드
	// scan과 bookList를 사용할수 있도록 초기화, 생성
	public BookServiceImpV2() {
		scan = new Scanner(System.in);
		
		// 클래스를 사용하려고 code를 작성했는데
		// 오류가 난다
		// Ctrl + Shift + O : 자동 import 실행
		bookList = new ArrayList<BookVO>();
	}
	
	// service.input(30); 30개 데이터를 입력받아라
	public void input(int count) {
		for(int i = 0 ; i < count ; i++) {
			System.out.println("=======================================");
			System.out.println((i+1) + "번째 도서정보 입력");
			System.out.println("=======================================");
			try {
				this.input();	
			} catch (NumberFormatException e) {
				i--;
				continue;
			}
		}
	}
	
	@Override
	public void input() {

		System.out.print("도서번호> ");
		String strNum = scan.nextLine();
		
		System.out.print("도서명> ");
		String strName = scan.nextLine();

		System.out.print("저자> ");
		String strWriter = scan.nextLine();
		
		System.out.print("출판사> ");
		String strComp = scan.nextLine();
		
		/*
		 * 이 App에서 사용자가 데이터를 입력하는 중에
		 * 가격이나, 출판연도를 숫자가 아닌 문자열을
		 * 입력하게 되면 문자열을 숫자로 바꾸는 과정에서
		 * NumberFormatException 이 발생할 것이다.
		 * 
		 * 이 App에서 NumberFormatException은 발생할 확율이
		 * 매우(0.0000001%) 높다.
		 * 
		 * 이럴경우 사용자가 입력하는 과정에서
		 * 약간의 실수만 하게 되어도
		 * 앞에서 입력햇던 모든 데이터를 잃게 된다.
		 * 
		 * 개발자 입장에서는 별다른 의미가 없고
		 * 추가 코드가 없어서 좋겠지만
		 * 사용자 입장에서는 매우 불편한 코드가 된다.
		 * 
		 * 사용자 입장에서 좋은 코드를 작성하기위해
		 * 개발자는 이런 상황에서
		 * 발생할 수 있는 exception을 예측하고
		 * 적절한 해결방법을 만들어야 한다.
		 * = exception handling 이라고 한다.
		 * 
		 * 1.만약 사용자가 가격이나, 출판연도를 
		 * 		문자열을 포함하여
		 * 입력할 경우 안내 메시지를 보여주고, 
		 * 		다음 값을 입력하도록
		 * 유도 하는 코드를 작성
		 * 
		 */
		
		System.out.print("가격> ");
		String strPrice = scan.nextLine();

		int intPrice = 0;
		try {
			intPrice = Integer.valueOf(strPrice);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("가격에 문자열이 포함됨!!");
			System.out.println("현재 도서 정보를 다시 입력해 주세요");
			
			// 호출한 곳으로 exception 전달하고 method 종료
			throw new NumberFormatException();
			// return;
		}
		
		System.out.print("출판연도> ");
		String strPubYear= scan.nextLine();
		int intPubYear = 0;
		try {
			intPubYear = Integer.valueOf(strPubYear);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("출판연도에 문자열이 포함됨!!");
			System.out.println("현재 도서 정보를 다시 입력해 주세요");
			
			// 호출한 곳으로 exception 전달하고 method 종료
			throw new NumberFormatException();
			// return;
		}
		
		
		// 1. 키보드로 입력받은 데이터를 vo를 생성하여 저장
		BookVO bookVO = new BookVO();
		bookVO.setStrNum(strNum);
		bookVO.setStrName(strName);
		bookVO.setStrComp(strComp);
		bookVO.setStrWriter(strWriter);
		
		bookVO.setIntPrice(intPrice);
		bookVO.setIntPubYear(intPubYear);
		
		// 2. 생성한 vo를 bookList 에 추가
		bookList.add(bookVO);
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void view(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void view(String strName) {
		// TODO Auto-generated method stub

	}

}
