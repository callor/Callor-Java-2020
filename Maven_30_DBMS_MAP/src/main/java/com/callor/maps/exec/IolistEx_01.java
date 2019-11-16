package com.callor.maps.exec;

import org.apache.ibatis.session.SqlSession;

import com.callor.maps.config.DBConnection;
import com.callor.maps.mapper.IolistDao;

public class IolistEx_01 {

	public static void main(String[] args) {
		
		SqlSession sqlSession = DBConnection
				.getSqlSessionFactory()
				.openSession(true);
		
		IolistDao iolistDao = sqlSession.getMapper(IolistDao.class);
		
	}
}
