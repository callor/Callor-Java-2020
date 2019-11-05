package com.callor.grade.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.grade.persistence.ScoreDTO;

public class ObjectServiceV1 extends ObjectService {

	@Override
	public int insert(List<Object> objList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> selectAll() {

		String sql = " SELECT LEVEL FROM DUAL ";
		sql += " CONNECT BY LEVEL <= 20 " ;
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rst = pStr.executeQuery();

			List<Object> objList = new ArrayList<Object>();
			while(rst.next()) {
				// System.out.println(rst.getString(1));
				ScoreDTO sDTO = ScoreDTO.builder()
						.s_id(1)
						.s_subject("메롱").build();
				// objList.add(rst.getInt(1));
				objList.add(sDTO);
				
			}
			pStr.close();
			return objList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
