package com.callor.files.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.callor.files.domain.ScoreVO;

public class FileGradeServiceV2 extends FileGradeServiceV1 {

	@Override
	public void read(String fileName) throws IOException {

		FileReader fileReader ;
		BufferedReader buffer;
		
		fileReader = new FileReader(fileName);
		buffer = new BufferedReader(fileReader);
		
		// 문자열 변수를 아무것도 없는 값으로 clear를 할때는
		// = "" 보다 new String() 생성자를 사용하자
		// String reader = "";
		String reader = new String();
		while(true) {
			
			reader = buffer.readLine();
			if(reader == null) break;
			/*
			 * score.txt의 한줄을 읽은 후
			 * 학번, 국어, 영어, 수학 항목으로 분해를 한다.
			 * scores[0] : 학번
			 * scores[1] : 국어
			 * scores[2] : 영어
			 * scores[3] : 수학
			 */
			String[] scores = reader.split(":");
			String strNum = scores[0];

			int intKor = 0;
			int intEng = 0;
			int intMath = 0;
			
			try {
				intKor = Integer.valueOf(scores[1]);
				intEng = Integer.valueOf(scores[2]);
				intMath = Integer.valueOf(scores[3]);
			} catch (Exception e) {
				// System.out.println(strNum + "번 학생의 점수 확인!!");
				// break;
				// 어떤 exception이 발생했는지
				// 호출하는 곳에 구체적으로 알려주는 방법
				throw new NumberFormatException();
			}
			
			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setStrNum(strNum);
			scoreVO.setIntKor(intKor);
			scoreVO.setIntEng(intEng);
			scoreVO.setIntMath(intMath);
			
			scoreList.add(scoreVO);
			
		}
		buffer.close();
		fileReader.close();
	
	} // end read

	/*
	 * Ovverride 키워드는 java 1.5 이후에는 
	 * 선택적으로 사용할 수 있다.
	 */
	@Override
	public void total() {

		for(ScoreVO vo : scoreList) {
			
			int intTotal = vo.getIntKor();
			intTotal += vo.getIntEng();
			intTotal += vo.getIntMath();
			
			vo.setIntTotal(intTotal);
			vo.setIntAvg(intTotal / 3);
		}
	}
	
	
	public void list() {
		System.out.println("======================================");
		System.out.println("성적일람표");
		System.out.println("======================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------");
		
		for(ScoreVO vo : scoreList) {
			
			System.out.print(vo.getStrNum() + "\t");
			System.out.printf("%3d\t", vo.getIntKor());
			System.out.printf("%3d\t", vo.getIntEng());
			System.out.printf("%3d\t", vo.getIntMath());
			
			System.out.printf("%5d\t", vo.getIntTotal());
			System.out.printf("%3d\n", vo.getIntAvg());
		}
		System.out.println("========================================");
	}
	
}
