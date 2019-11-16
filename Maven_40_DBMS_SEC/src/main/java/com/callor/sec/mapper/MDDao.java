package com.callor.sec.mapper;

import java.util.List;

import com.callor.sec.persistence.MasterDTO;
import com.callor.sec.persistence.MasterDetailVO;

public interface MDDao {
	
	public List<MasterDetailVO> selectAll();
	public int insertMaster(MasterDTO masterDTO);

}
