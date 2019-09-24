package com.callor.bank.service;
/*
 * BankService에서 할일이 아직 명확히 정의되지 않아서
 * 빈(blank) interface를 만들고
 * 실지 class 만들면서 interface 정의를 수행
 * 
 * 1. 잔고원장(파일)으로 부터 계좌들의 잔고 리스트를 가져와서
 * 		리스트로 생성을 하고
 * 2. 각 계좌별로 입, 출금을 수행하고
 * 3. 다시 잔고원장에 입, 출금 내역을 반영
 * 
 * 4. 각 계좌별로 입,출금 내역(List)를 파일로 저장
 * 
 */
/*
 * interface는 method의 정의만 있고
 * ==> method prototype 정의
 * method가 구체적으로 무슨일을 하는지 모른다.
 * 다만,
 * 구현될 method의 return type과 매개변수의 형식만 지정을 한다.
 */
public interface BankService {
	
	// 잔고원장으로 부터 계좌들의 잔고 리스트를 가져와서
	// 리스트로 생성
	// obj.readBook("거래원장.txt") 형식으로 호출될 method
	public void readBook(String bookFile) throws Exception; // {} 없고 코드 없는
	
	// 계좌번호를 입력받아서
	// 계좌의 정보(잔액, 최종거래일자 등등..)을 보여주는 method
	public void viewAcc() ;
	
	// 조회된 계좌번호에 해당하는 계좌에
	// 키보드로 부터 입금액을 입력받아서 입금 처리하는 method
	public void input() throws Exception;
	
	// 출금처리 method
	public void output() throws Exception;

	// 입,출금이 완료되었을때 원장 정보를 업데이트 하는 method
	public void bookWrite(String bookFile) throws Exception;
	
	// 각 계좌별로 입출금 내역을 파일에 저장하자
	public void accListWrite(String remark, int money) throws Exception ;
	
}




