package com.callor.sec.mapper;

import java.util.List;

import com.callor.sec.persistence.CbtDTO;

public interface CbtDao {
	
	public List<CbtDTO> selectAll();

}
