package com.callor.oracle.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn = null;
	
	static {
		
		// String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "user4";
		String password = "user4" ;

		try {
			// JDBC 드라이버를 메모리에 load하여 사용할 준비하라
			// Class.forName(jdbcDriver);
			// JDBC 4.0(Java 6) 이상에서는 사용하지 않아도 된다.
			
			dbConn = DriverManager.getConnection(url, user, password);
			System.out.println("DBConnection OK!!");
//		} catch (ClassNotFoundException | SQLException e) {
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // end static
	public static Connection getDBConnection() {
		return dbConn;
	}
	
}
