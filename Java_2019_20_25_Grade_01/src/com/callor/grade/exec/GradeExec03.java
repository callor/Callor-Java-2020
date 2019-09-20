package com.callor.grade.exec;

import com.callor.grade.service.GradeServiceV2;

public class GradeExec03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 우리말이름.txt 파일에서 이름을 읽어서
		// List로 생성해서 보관하고 있는 클래스
		GradeServiceV2 g = new GradeServiceV2();

		// 생성된 g 객체의 이름을 list에 추가하는
		// method를 실행
		g.makeNames();
		
		makeName();

	}
	
	public static void makeName() {
		
	}

}




