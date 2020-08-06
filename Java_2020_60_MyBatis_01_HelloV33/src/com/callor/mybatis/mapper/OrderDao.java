package com.callor.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.mybatis.peristence.OrderVO;

public interface OrderDao {
	
	@Select("SELECT * FROM tbl_order")
	public List<OrderVO> selectAll();
	
	public OrderVO findById(String b_code);
	
	public List<OrderVO> findByName(String b_name);
	
	public int insert(OrderVO bookDTO);
	public int update(OrderVO bookDTO);
	
	public int delete(String b_code);

	
}
