package com.callor.jdbc.exec;

import java.util.List;

import com.callor.jdbc.domain.ScoreVO;
import com.callor.jdbc.service.ScoreJDBCServiceV3;

public class JdbcEx_06 {

	public static void main(String[] args) {

		ScoreJDBCServiceV3 sc = new ScoreJDBCServiceV3();
		
		List<ScoreVO> scoreList = sc.findById(30);
		for(ScoreVO s : scoreList) {
			System.out.println(s);
		}
		
		
	}

}
