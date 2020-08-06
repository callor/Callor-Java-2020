package com.callor.mybatis.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.callor.mybatis.config.DBConnection;
import com.callor.mybatis.mapper.OrderDao;
import com.callor.mybatis.peristence.OrderVO;

public class MyBatisEx_01 {

	public static void main(String[] args) {

		/*
		 * JDBC의 다양한 클래스를 대신하여 Java 어플리케이션과 DBMS간의 연결 Connection을 대신 관리해줄 클래스, 객체선언
		 * session 네트워크 환경에서 지점과 지점사이가 다양한 방법으로 연결되고 데이터를 주고받을 준비가 된 통료
		 */
		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);

		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);

		
		System.out.println("MyBatis Java Exam");
		List<OrderVO> orderList = orderDao.selectAll();
		for (OrderVO dto : orderList) {
			System.out.println(dto.toString());
		}

	}
}
