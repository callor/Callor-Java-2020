package com.biz.order.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.order.config.DBConnection;
import com.biz.order.model.OrderVO;

public class MyBatisEx_01 {

	public static void main(String[] args) {
	
		try (SqlSession session = DBConnection.getSqlSessionFactory().openSession(true)) {
			List<OrderVO> orderList = session.selectList("com.biz.order.mapper.OrderDao.selectAll");
			for(OrderVO vo : orderList) {
				System.out.println(vo);
			}

		
		}
		
	}
}
