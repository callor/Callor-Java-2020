package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.persistence.BookDTO;

public interface BookDao {

	public List<BookDTO> selectAll();

}
