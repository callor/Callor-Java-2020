package com.callor.dbms.dao;

import java.util.List;
import java.util.Map;

import com.callor.dbms.persistence.BBsDTO;

public interface BBsDao {
	
	public List<BBsDTO> selectAll();
	public List<Map<String,Object>> selectMap();
	
	public BBsDTO findById(long bs_id);
	
	public int insert(BBsDTO bbsDTO);
	public int update(BBsDTO bbsDTO);
	
	public int delete(long bs_id);
	
}
