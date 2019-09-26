package com.callor.iolist.domain;
/*
 * 매입매출정보.txt의 파일을 읽어서
 * 매입매출 리스트를 출력하는 프로젝트
 * 
 * ======================================
 * 거래일자	상품명	구분	단가	수량
 * --------------------------------------
 * 
 * 출력결과
 * ==============================================================
 * 거래일자 상품명 구분  수량 매입단가 매출단가 매입금액 매출금액
 * -------------------------------------------------------------- 
 */
public class IolistVO {

	private String strDate;
	private String strPName;
	private String strIO;
	private int intPrice;
	private int intQty;
	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrPName() {
		return strPName;
	}
	public void setStrPName(String strPName) {
		this.strPName = strPName;
	}
	public String getStrIO() {
		return strIO;
	}
	public void setStrIO(String strIO) {
		this.strIO = strIO;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public int getIntQty() {
		return intQty;
	}
	public void setIntQty(int intQty) {
		this.intQty = intQty;
	}
	@Override
	public String toString() {
		return "IolistVO [strDate=" + strDate + ", strPName=" + strPName + ", strIO=" + strIO + ", intPrice=" + intPrice
				+ ", intQty=" + intQty + "]";
	}

	
	
	
}
