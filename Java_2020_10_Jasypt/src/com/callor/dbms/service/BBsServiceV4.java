package com.callor.dbms.service;

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

}
