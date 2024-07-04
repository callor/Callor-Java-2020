package com.callor.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.mybatis.model.VisionVO;

public interface VisionMapper {

	@Select("SELECT * FROM tbl_visions")
	public List<VisionVO> selectAll();
	
}
