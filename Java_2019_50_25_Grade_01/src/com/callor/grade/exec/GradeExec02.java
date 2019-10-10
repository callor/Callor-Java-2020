package com.callor.grade.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.grade.domain.ScoreVO;
import com.callor.grade.domain.StudentVO;
import com.callor.grade.service.GradeServiceV1;
import com.callor.grade.utill.Score;

public class GradeExec02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strFile = "src/com/callor/grade/우리말이름.txt";
		GradeServiceV1 gr = new GradeServiceV1(strFile);
		gr.studentInfoRead();
		
		List<ScoreVO> scoreList = new ArrayList<>();
		List<StudentVO> stList = gr.getStList();
		for(StudentVO vo : stList) {
			ScoreVO svo = new ScoreVO();
			svo.setStrNum(vo.getStrNum());
			svo.setIntKor(Score.makeScore());
			svo.setIntEng(Score.makeScore());
			svo.setIntMath(Score.makeScore());
			int intSum = svo.getIntKor();
			intSum += svo.getIntEng();
			intSum += svo.getIntMath();
			svo.setIntSum(intSum);
			svo.setFloatAvg(intSum / 3.0f);
			scoreList.add(svo);
			
			System.out.println(vo);
		}
		
		System.out.println("==================================");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------");
		for(StudentVO vo : stList) {
			System.out.print(vo.getStrNum() + "\t");
			System.out.print(vo.getStrKorName() + "\t");
			
			// 학번에 대한 학생의 점수를 별도로 검색하여 표시
			for(ScoreVO sv : scoreList) {
				if(vo.getStrNum().equals(sv.getStrNum())) {
					System.out.print(sv.getIntKor() + "\t");
					System.out.print(sv.getIntEng() + "\t");
					System.out.print(sv.getIntMath() + "\t");
					System.out.print(sv.getIntSum() + "\t");
					System.out.print(sv.getFloatAvg() + "\t");
					break;
				}
			}
			System.out.println();
		}
		System.out.println("================================");
		
	}
}
