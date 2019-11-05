package com.callor.grade.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.callor.grade.persistence.ScoreDTO;
import com.callor.grade.persistence.StudentDTO;
import com.callor.grade.service.start.DbConnection;
import com.callor.grade.utils.DBContract;

/*
 * 추상클래스 선언
 */
public abstract class ObjectService {

	protected Connection dbConn = null;
	
	public ObjectService() {
		// TODO Auto-generated constructor stub
		// 외부에 static 클래스를 만들고 Connections을 가져다 사용한다.
		dbConn = DbConnection.getDBConnection();
	}
	
	// CRUD
	public abstract int insert(List<Object> objList) ;

	// 모든 레코드
	// 1개 이상의 레코드
	public abstract List<Object> selectAll();
	
	// id 값을 매개변수로 받아서
	// 1개의 레코드만 조회하는 method
	public abstract Object findById(long id);
	
	public abstract int update(Object object) ;
	public abstract int delete(long id);
	
}




