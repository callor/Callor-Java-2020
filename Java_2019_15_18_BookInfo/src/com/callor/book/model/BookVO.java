package com.callor.book.model;

/*
 * 도서정보 관리 어플에서 사용할 클래스
 * 
 * 추상화 단계
 * 	1. 도서명 : name, String, strName
 * 	2. 저자 : writer, String, strWriter
 * 	3. 출판사 : company, String, strComp
 * 	4. 도서가격 : price, int, intPrice
 * 	5. 출판연도 : year, int, intYear
 * 	6. ISBN(Internation Serial Book Number) : num, String, strNum
 */

// VO : Value Object
//	 		데이터를 담는 최소 클래스
//			1권의 도서 정보를 담는 바구니역할을 하는 클래스
// VO 클래스를 만들때
// 1. 추상화 단계 : 어떤 맴버변수(필드)를 만들것인가
// 2. 맴버변수를 선언하고

// 3. 정보은닉 : 맴버변수의 접근제한자를 
//			private으로 선얼

// 4. 캡슐화 : 은닉된 맴버변수를 접근할수 있는 통로를 설정
//			getter() setter() method를 생성, 선언

//			만약 vo.strName = "java" 라는 코드로
//			vo 클래스의 strName 변수에 java 문자열을 저장하려고 할때
//			strName 변수를 private으로 만들면
//			setter() 메서들 통해서 값을 저장해야 한다.

//			즉, vo.setStrName("java") 라는 코드를 사용해야한다.
//	 		우리의 목적은 strName이라는 맴버변수에
//			java라는 문자열을 저장하는 것 뿐이다.

//			결국 목적은 하나이지만
//			변수에 직접 접근하느냐
//			setter() method를 통해서 접근하느냐 의 차이이며
//			vo 클래스의 setter() 메서드가
//			내부적으로 어떤 일(연산)을 수행하는지
//			몰라도
//			목적은 달성 할수 있다.

public class BookVO {

	private String strNum;

	private String strName;
	private String strWriter;
	private String strComp;
	private int intPrice;
	private int intPubYear;

	// strNum 변수의 값을 읽기
	// String num = vo.getStrNum()
	public String getStrNum() {
		return strNum;
	}

	// setStrNum("9700001")
	// 맴벼변수 strNum = "9700001" 이런 코드를
	// 실행한 것과 같다
	public void setStrNum(String strNum) {

		// 캡슐화
		// setStrNum() method에 아래와 같은 코드가 있더라도
		// 외부에서는 아무런 관심 없다.
		int sum = 30 + 40 + 50 + 60 + 70;
		sum += 30;
		sum -= 20;

		// this.strNum 는 맴버변수를 가리킨다
		// = strNum는 매개변수의 값을
		// 맴버변수에 할당하라
		this.strNum = strNum;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getStrWriter() {
		return strWriter;
	}

	public void setStrWriter(String strWriter) {
		this.strWriter = strWriter;
	}

	public String getStrComp() {
		return strComp;
	}

	public void setStrComp(String strComp) {
		this.strComp = strComp;
	}

	public int getIntPrice() {
		return intPrice;
	}

	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	public int getIntPubYear() {
		return intPubYear;
	}

	public void setIntPubYear(int intPubYear) {
		this.intPubYear = intPubYear;
	}

}
