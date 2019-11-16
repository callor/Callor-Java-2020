package com.callor.maps.service;

import java.util.List;
import java.util.Map;

import com.callor.maps.config.DBConnection;
import com.callor.maps.mapper.IolistDao;

public class IolistServiceV1 {

	IolistDao ioDao = null;
	
	public IolistServiceV1() {

		ioDao = DBConnection
					.getSqlSessionFactory()
					.openSession(true)
					.getMapper(IolistDao.class);
	}
	
	public void selectMapListView() {
		
		List<Map<String,Object>> iolist = ioDao.selectAll();
		
		for(Map<String,Object> io : iolist) {
			
			System.out.print(io.get("IO_SEQ").toString() + "\t" );
			System.out.print(io.get("IO_DATE").toString() + "\t" );
			System.out.print(io.get("IO_INOUT").toString() + "\t" );
			System.out.print(io.get("IO_QTY").toString() + "\t" );
			System.out.print(io.get("IO_PRICE").toString() + "\t" );
			System.out.print(io.get("IO_TOTAL").toString() + "\t" );
			System.out.print(io.get("IO_PCODE").toString() + "\t" );
			System.out.print(io.get("IO_DCODE").toString() + "\n" );
			
		}
		
		
		
		
		
	}

	
}
