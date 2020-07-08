package com.callor.hello.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.hello.model.ScoreVO;
import com.callor.hello.service.ScoreServiceV2;

public class ScoreEx_01 {
	public static void main(String[] args) {
		
		List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
		Random rnd = new Random();
		
		ScoreVO scoreVO ;
		for(int i = 0 ; i < 10 ; i++) {
			
			// VO 인스턴스를 초기화, 다시 생성하라
			scoreVO = new ScoreVO(); 
		
			// (필드변수에)값을 세팅하고
			scoreVO.setNum("" + i);
			scoreVO.setKor(rnd.nextInt(50) + 51);
			scoreVO.setMath(rnd.nextInt(50) + 51);
			scoreVO.setEng(rnd.nextInt(50) + 51);
			
			// 리스트에 추가
			scoreList.add(scoreVO);
		}
		
		ScoreServiceV2 scoreService = new ScoreServiceV2();
		scoreService.stSum(scoreList);
		scoreService.stAvg();
		scoreService.scoreList();
		
	}
}
