package com.biz.sec.mapper;

import java.util.List;

import com.biz.sec.persistence.MasterDetailVO;

public interface MDDao {
	
	public List<MasterDetailVO> selectAll();

}
