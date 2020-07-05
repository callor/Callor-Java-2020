package com.callor.files.service;

public interface StudentService {
	
	//1. 이름리스트 파일을 읽어서 nameList 작성
	public void readNameList(String nameFile)  throws Exception ;
	
	//2. 지방자치단체주소 파일을 읽어서 addrList  작성
	public void readAddrList(String addrFile) throws Exception;
	
	//3 학번, 학년, 반, 주소를 추가하여 
	// studentlist를 만들어서 파일에 기록
	public void writeStudentFile(String studentFile,int length)  throws Exception ;

	
}
