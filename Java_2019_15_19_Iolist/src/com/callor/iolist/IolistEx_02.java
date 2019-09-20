package com.callor.iolist;

import com.callor.iolist.service.IolistService;
import com.callor.iolist.service.IolistServiceImpV2;

public class IolistEx_02 {

	public static void main(String[] args) {

		IolistService is = new IolistServiceImpV2();
		
		String fileName = "src/com/callor/iolist/매입매출정보.txt";
		try {
			is.read(fileName);
			is.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
