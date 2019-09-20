package com.callor.files.grade;

import java.io.IOException;

import com.callor.files.service.FileGradeService;
import com.callor.files.service.FileGradeServiceV2;

public class GradeEx_02 {

	public static void main(String[] args) {

		FileGradeService fg = new FileGradeServiceV2();
		String scoreFile = "src/com/biz/files/score.txt";

		try {
			fg.read(scoreFile);
			fg.total();
			fg.list();
			
		} catch (NumberFormatException e) {
			/*
			 * FileGradeService.read() method가 실행되는 중에
			 * 만약 문자열형 숫자를 숫자로 바꾸는 과정에서
			 * exception이 발생하면
			 * 		throw new NumberFormatException으로
			 * 		exception을 toss 하고
			 * main()에서는 해당 exception에 대해서
			 * 다른 exception과 처리를 분리할수 있다.
			 */
			System.out.println("데이터 파일을 확인하세요!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
