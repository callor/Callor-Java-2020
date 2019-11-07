package com.biz.sec.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.MDDao;
import com.biz.sec.persistence.DetailDTO;
import com.biz.sec.persistence.MasterDetailVO;

public class MasterService {

	protected MDDao mdDao;
	
	{
		
		mdDao = DBConnectionSEC
				.getInstance()
				.openSession(true)
				.getMapper(MDDao.class);
	}
	
	public void masterAndDetail() {
		List<MasterDetailVO> mdList = mdDao.selectAll();
		for(MasterDetailVO vo : mdList) {
			System.out.print(vo.getM_seq() + "\t");
			System.out.print(vo.getM_seq() + "\n");
			
			List<DetailDTO> deList = vo.getDeList();
			if(deList != null) {
				Collections.shuffle(deList);
				for(DetailDTO dto : vo.getDeList()) {
					System.out.print(dto.getD_subject()+"\t");
					System.out.println(dto.getD_ok());
				}
			}
		}
		System.out.println("OK");
	}
	
}
