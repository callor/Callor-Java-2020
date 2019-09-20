package com.biz.grade.exec;

import java.util.Map;

import com.biz.grade.domain.ScoreVO;
import com.biz.grade.domain.StudentVO;
import com.biz.grade.service.GradeServiceV1;
import com.biz.grade.service.ScoreServiceV1;
import com.biz.grade.service.StudentServiceV1;

public class GradeEx_01 {

	public static void main(String[] args) {

		StudentServiceV1 stService = new StudentServiceV1();
		ScoreServiceV1 scService = new ScoreServiceV1();
		
		String stdFileName ="src/com/biz/grade/학생명부.txt" ;
		String scoreFileName = "src/com/biz/grade/score.txt" ;
		
		try {
			stService.read(stdFileName);
			
			scService.read(scoreFileName);
			scService.total();
			scService.rank();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,ScoreVO> scList = scService.getScList();
		Map<String,StudentVO> stdList = stService.getStdList();
		
		// 기본생성자를 호출하여 gs객체를 생성
		GradeServiceV1 gs = new GradeServiceV1();

		// scList를 생성자에게 보내서
		// gs객체를 생성하면서 scList 값을 초기화
		gs = new GradeServiceV1(scList);
		
		// scList와 stdList를 생성자에게 보내서
		// gs객체를 생성하면서 scList와 stdList 값을 초기화
		gs = new GradeServiceV1(scList,stdList);
		
		gs.list();
		
		
	}

}
