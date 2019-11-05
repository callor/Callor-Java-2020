package com.callor.hello.program;

import java.util.ArrayList;
import java.util.List;

import com.callor.hello.domain.BBsVO;

public class HelloEx_01 {

	/*
	 * Java 클래스의 진입점(시작점) method
	 * Java 프로젝트에는 1개의 main() method가 있어야 하며
	 * JVM에 의해서 자동 호출되어 프로젝트를 시작하게 된다.
	 */
	public static void main(String[] args) {

		// 한줄 주석
		/*
		 * 여러줄짜리 주
		 */
		
		/*
		 * 변수를 선언한 후 초기화를 하지 않았을 경우 변수를 읽는 명령에서 오류가 발생한
		 */
		int num; //변수의 선언
		// num = 10; // 변수를 초기화하며 값 10을 저장
		System.out.println(num);
		
		int num1 = 0; // 변수의 선언과 초기화(Clear)
		num1 = 50;
		System.out.println(num1);
		
		
		/*
		 * 클래스를 배열로 선언한 후
		 * 각 배열 요소를 반드시 초기화, 생성을 해 주어야 요소에 접근이 가능하
		 */
		BBsVO[] bbsArray = new BBsVO[10];
		bbsArray[1] = new BBsVO();
		bbsArray[1].setAuth("홍길동");
		System.out.println(bbsArray[1].getAuth());
		
		
		/*
		 * 인터페이스가 있는 클래스는
		 * 인터페이스(List)를 사용하여 객체를 선언하고
		 * 실제사용할 클래스(ArrayList)의 생성자(ArrayList()) 를 사용하여
		 * 객체를 초기화한다(인스턴스 생성) 
		 */
		List<BBsVO> bbsList = new ArrayList<BBsVO>();
		bbsList = new ArrayList<BBsVO>();
		
		/*
		 * 객체에 값을 저장하고
		 * List 에 추가할때는 먼저 
		 * 객체를 생성하고, 값을 세팅한 후 add()메서드로 리스트에 추가한다.
		 */
		BBsVO bbsVO = new BBsVO();
		bbsVO.setAuth("이몽룡");
		bbsList.add(bbsVO);
		
		
		
	}

}
