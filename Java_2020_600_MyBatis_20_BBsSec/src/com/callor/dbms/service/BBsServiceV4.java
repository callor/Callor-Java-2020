package com.callor.dbms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class BBsServiceV4 extends BBsServiceV3 {
	
	public void bbsMenu() {
		while(true) {
			System.out.print("내용보기(SQ입력)  W.작성  U.수정  D.삭제  Q.종료 >>");
			String strMenu = scanner.nextLine();
			if(strMenu.equalsIgnoreCase("Q")) {
				return ;
			} else if(strMenu.equalsIgnoreCase("W")) {
				
				this.writeBBS();
				this.viewBBsList();
				
			} else if(strMenu.equalsIgnoreCase("U")) {
				this.updateBBS();
				this.viewBBsList();
			} else if(strMenu.equalsIgnoreCase("D")) {
				this.deleteBBS();
				this.viewBBsList();
			} else {
				try {
					long longSEQ = Integer.valueOf(strMenu);
					this.viewText(longSEQ);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void updateBBS() {
		// 수정할 ID를 입력받고
		// 내용을 한번 보여주고
		// 각 항목을 입력받고
		// Enter를 입력하면 원래 데이터 유지
		// 새로입력하면 새로운 값으로 대치
	}
	
	
	public void bbsMapTest() {
		List<Map<String,Object>> bbsList = bbsDao.selectMap();
		
		for(Map<String,Object> map : bbsList) {
			
			Set<String> keys = map.keySet();
			for(String s : keys) {
				System.out.println(s + " : " + map.get(s));
			}
			
			System.out.println("========================================");
			
			System.out.print(map.get("BBS_ID") + "\t");
			System.out.print(map.get("BBS_DATE") + "\t");
			System.out.print(map.get("BBS_TIME") + "\t");
			System.out.print(map.get("BBS_WRITER") + "\t");
			System.out.print(map.get("BBS_SUBJECT") + "\t");
			System.out.println(map.get("BBS_COUNT"));
			
		}
		
		
		
	}

}
