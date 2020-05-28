package com.callor.dbms.exec;

import com.callor.dbms.service.BBsServiceV3;

public class BbsEx_03 {

	public static void main(String[] args) {

		BBsServiceV3 bbs = new BBsServiceV3();
		bbs.viewBBsList();
		bbs.bbsMenu();
	}

}
