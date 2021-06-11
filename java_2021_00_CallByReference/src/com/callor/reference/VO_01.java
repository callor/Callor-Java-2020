package com.callor.reference;

public class VO_01 {

	
	public static void main(String[] args) {
		
		ValueObject vo = new ValueObject();
		vo.name = "성춘향";
		
		System.out.print("전달하기 전 VO : ");
		System.out.println(vo.toString());
		
		// vo를 매개변수로 전달
		updateVO(vo);
		
		/*
		 * 매개변수로 전달받은 VO의 일부 속성(필드변수, 인스턴스변수)를 변경하면
		 * 전달하기 전 원래의 VO 데이터가 변경된다
		 */
		System.out.print("updateVO() 호출한 후 VO : ");
		System.out.println(vo.toString());
		
		newVO(vo);

		/*
		 * 매개변수로 전달받은 VO를
		 * 새로 생성(new ValueObject()) 한 후
		 * 		일부 속성(필드변수, 인스턴스변수)를 변경하였을 경우
		 * 이때는
		 * 		전달하기 전 원래의 VO 데이터가 변경되지 않는다
		 */
		System.out.print("newVO() 호출한 후 VO : ");
		System.out.println(vo.toString());
		
	}
	
	
	public static void updateVO(ValueObject vo) {
		
		vo.num = 200;
		vo.str = "대한민국";
		vo.name = "홍길동";
		
	}
	
	public static void newVO(ValueObject vo) {
		vo = new ValueObject();
		vo.num = 100;
		vo.str = "우리나라";
		vo.name = "이몽룡";

	}
}
