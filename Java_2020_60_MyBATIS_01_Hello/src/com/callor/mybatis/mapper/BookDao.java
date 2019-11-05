package com.callor.mybatis.mapper;

import java.util.List;

import com.callor.mybatis.peristence.BookDTO;

public interface BookDao {
	
	public List<BookDTO> selectAll();
	
	public BookDTO findById(String b_code);
	
	public List<BookDTO> findByName(String b_name);
	
	public int insert(BookDTO bookDTO);
	public int update(BookDTO bookDTO);
	
	public int delete(String b_code);

	
}
