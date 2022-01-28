package com.callor.grade.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.callor.grade.config.DBConnection;
import com.callor.grade.config.DBContract;
import com.callor.grade.config.DBContract.DBConn;
import com.callor.grade.persistence.domain.ScoreDTO;
import com.callor.grade.persistence.domain.ScoreVO;

public abstract class ScoreServiceV2 {

	protected Connection dbConn = null;

	//ScoreServiceV2 생성자
	public ScoreServiceV2() {
		this.dbConn = DBConnection.getDBConnection();
	}
	
	public abstract List<ScoreVO> selectAll() ;
	public abstract ScoreVO findById(long id);
	
	// 학생이름으로 검색하기
	public abstract List<ScoreVO> findByStName(String stName);
	
	public abstract int insert(ScoreDTO scoreDTO) ;
	public abstract int update(ScoreDTO scoreDTO) ;
	public abstract int delete(long id);

	public abstract List<ScoreVO> findByStNum(String strStNum);

	public abstract List<ScoreVO> findBySubject(String strSubject);
	
}
