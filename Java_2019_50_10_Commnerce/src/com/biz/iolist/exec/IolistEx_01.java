package com.biz.iolist.exec;

import com.biz.iolist.service.MakeProductServiceV1;

public class IolistEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeProductServiceV1 ms = new MakeProductServiceV1();
		
		String strProFileName = "src/com/biz/iolist/과자이름.txt";
		String strProWriteFile = "src/com/biz/iolist/상품정보.txt";
		
		try {
			ms.getProductList(strProFileName, strProWriteFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
