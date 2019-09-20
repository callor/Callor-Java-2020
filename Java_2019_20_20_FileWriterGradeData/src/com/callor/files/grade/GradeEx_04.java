package com.callor.files.grade;

import com.callor.files.service.GradeService;
import com.callor.files.service.GradeServiceV2;

public class GradeEx_04 {

	public static void main(String[] args) {

		// 이미 있는파일 : 읽을 파일
		String nameFile = "src/com/callor/files/이름파일.txt";
		
		// 새로 작성할 파일
		String studentFile = "src/com/callor/files/학생명부.txt";
		String scoreFile = "src/com/callor/files/성적일람표.txt";

		int intMens = 30; // 몇명분의 정보를 생성할것인가
		
		GradeService gs = new GradeServiceV2();
		
		try {
			
			gs.makeScoreFile(scoreFile, intMens);
			gs.readNameFile(nameFile);
			gs.makeStudentFile(studentFile, intMens);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("샘플 데이터 생성 완료!!!");
		
	}

}







