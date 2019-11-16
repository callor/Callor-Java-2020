package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.persistence.ScoreDTO;

public interface ScoreDao {
	
	public List<ScoreDTO> selectAll();
	

}
