package com.callor.mybatis.service;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.mybatis.config.DBConnection;
import com.callor.mybatis.mapper.OrderDao;
import com.callor.mybatis.peristence.OrderVO;

public class OrderServiceV1 {
	
	SqlSession sqlSession = null;
	Scanner scanner = null;
	OrderDao orderDao = null;
	
	public OrderServiceV1() {
		this.sqlSession = DBConnection
					.getSqlSessionFactory()
					.openSession(true);
		scanner = new Scanner(System.in);
		
		this.orderDao = sqlSession.getMapper(OrderDao.class);
	}
	
	public void searchName() {
		
		while(true) {
			
			System.out.println("=======================");
			System.out.println("주문서 관리 v2");
			System.out.println("=======================");
			System.out.print("주문번(-Q:quit) >> ");
			String strName = scanner.nextLine();
			
			if(strName.equals("-Q")) break;
			
			// orderDao dao = sqlSession.getMapper(orderDao.class);
			List<OrderVO> bookList = orderDao.findByName(strName);
			for(OrderVO dto : bookList) {
				System.out.println(dto.toString());
			}
		}
	}

}
