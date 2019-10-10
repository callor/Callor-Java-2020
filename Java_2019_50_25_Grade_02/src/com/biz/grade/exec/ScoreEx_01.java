package com.biz.grade.exec;

import com.biz.grade.service.ScoreServiceV1;

public class ScoreEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreServiceV1 sc = new ScoreServiceV1();
		String scoreFileName = "src/com/biz/grade/score.txt";
		
		try {
			sc.read(scoreFileName);
			sc.list();
			
			sc.total();
			sc.listTotal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
