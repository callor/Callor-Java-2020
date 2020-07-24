package com.callor.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

public interface MapperDao {

	@Select("SELECT COUNT(*) FROM MyBooks")
    public int getNumberOfBooks();
}
