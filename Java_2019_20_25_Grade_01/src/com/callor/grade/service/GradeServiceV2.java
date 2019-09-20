package com.callor.grade.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.grade.domain.StudentVO;

public class GradeServiceV2 {

	private String nameFile = "";
	
	// 선언
	List<StudentVO> stList;

	// 생성자
	// 리턴값(void, int, String)이 없는 method
	// 외부에서 클래스를 사용해서 객체를 생성할때
	// 호출되는 method
	//  	GradeReader02 g = new GradeReader02();
	public GradeServiceV2() {
		
	}
	
	// 2번째 생성자
	//   nameFile 이라는 String형 매개변수를 갖는다.
	//	 GradeReader02 g = new GradeReader02("우리말.txt")
	// 외부에서 파일이름을 전달해서
	// 파일이름에 구속되지 않는 클래스를 만들기 위한
	// 	 방법
	public GradeServiceV2(String nameFile) {
		this.setNameFile(nameFile);
		this.stList = new ArrayList<>();
	}
	
	// Test를 위한 method
	public void makeNames() {
		StudentVO vo = new StudentVO();
		vo.setStrKorName("홍길동");
		stList.add(vo);
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	
}







