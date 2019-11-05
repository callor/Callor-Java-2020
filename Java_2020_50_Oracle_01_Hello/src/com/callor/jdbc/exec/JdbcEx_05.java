package com.callor.jdbc.exec;

import java.util.List;

import com.callor.jdbc.domain.ScoreVO;
import com.callor.jdbc.service.ScoreJDBCServiceV2;

public class JdbcEx_05 {

	public static void main(String[] args) {

		ScoreJDBCServiceV2 sc = new ScoreJDBCServiceV2();
		
		List<ScoreVO> stdList = sc.findByName("'갈한수' OR 1 = 1");
		for(ScoreVO sVO : stdList) {
			System.out.println(sVO.toString());
		}
	}

}
