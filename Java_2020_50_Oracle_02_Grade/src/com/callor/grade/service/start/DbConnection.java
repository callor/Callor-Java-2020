package com.callor.grade.service.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.callor.grade.utils.DBContract;

public class DbConnection {
	
	/*
	 *  static 키워드
	 *  static 키워드가 붙은 변수, 메서드...은
	 *  프로젝트가 실행되는 순간 생성되어
	 *  누군가 사용하든 안하든 메모리에 존재하게 된다.
	 *  static 변수, 메서드는 이미 생성된 상태가 되고
	 *  static 변수와 메서드를 감싸고 있는 클래스도 
	 *  자동으로 static 클래스가 되어 프로젝트 시작과 동시에
	 *  생성이된다.
	 *  
	 *  따라서 외부에서 사용하고자 할때는
	 *  별도로 객체로 생성하지 않고
	 *  클래스.변수, 클래스.메서드()형식으로 사용한다.
	 *  
	 */
	private static Connection dbConn = null;
	
	/*
	 * 
	 * static 생성자
	 * static {}
	 * 보통 static 무명 메서드 라고도 하며
	 * static 클래스의 생성자 역할을 한다.
	 * 
	 * 즉, 자동으로 코드들이 실행되며
	 * static 변수들을 초기화 하는 코드가 작성된다.
	 */
	static {
		String jdbcDriver = DBContract.DbConn.JdbcDriver;
		String url = DBContract.DbConn.URL;
		String userName = DBContract.DbConn.USER;
		String password = DBContract.DbConn.PASSWORD;
		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // end static

	public static Connection getDBConnection() {
		return dbConn;
	}
	

}
