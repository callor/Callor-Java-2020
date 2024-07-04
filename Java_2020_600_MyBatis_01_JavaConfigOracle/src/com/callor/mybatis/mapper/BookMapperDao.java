package com.callor.mybatis.mapper;

import java.util.List;

import com.callor.mybatis.model.BookVO;

public interface BookMapperDao {

	public List<BookVO> selectAll();
	
}
