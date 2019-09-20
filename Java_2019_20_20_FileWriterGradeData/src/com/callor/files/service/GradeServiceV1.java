package com.callor.files.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.files.domain.ScoreVO;

public class GradeServiceV1 implements GradeService {

	protected List<ScoreVO> scList = null;
	
	public GradeServiceV1() {
		scList = new ArrayList<ScoreVO>();
	}

	public void makeScoreFile(String fileName, int length) throws Exception {

		Random rnd = new Random();

		/*
		 * 매개변수로 전달받은 length 만큼
		 * score 정보를 생성하고 scList에 추가
		 */
		for(int i = 0 ; i < length ; i++) {
			String strNum = String.format("A%03d", i+1);
			
			int intKor = rnd.nextInt(50) + 51;
			int intEng = rnd.nextInt(50) + 51;
			int intMath = rnd.nextInt(50) + 51;
			
			ScoreVO scVO = new ScoreVO();
			scVO.setNum(strNum);
			scVO.setKor(intKor);
			scVO.setEng(intEng);
			scVO.setMath(intMath);
			scList.add(scVO);
		}
		
		// 생성된 scList의 성적정보를 file에 기록
		PrintWriter fileOut = null;
		fileOut = new PrintWriter(fileName);

		for(ScoreVO vo : scList) {
			
			// A0001:90:89:78 format으로 작성
			fileOut.printf("%s:%d:%d:%d\n",
					vo.getNum(),
					vo.getKor(),
					vo.getEng(),
					vo.getMath());

			// 현재의 데이터를 안전하게 기록하기 위해서
			// 한사람의 성적을 기록한 후 파일에 강제 저장하도록
			// flush()를 실행
			// 		데이터가 많을때는 성능상에 
			//		불리한 면이 있을수 있다.
			fileOut.flush();
		
		}
		fileOut.close();
	}

	@Override
	public void readNameFile(String nameFile) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeStudentFile(String StudentFile, int length) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
