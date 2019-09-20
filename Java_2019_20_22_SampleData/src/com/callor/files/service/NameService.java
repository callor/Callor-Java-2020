package com.callor.files.service;

public interface NameService {
	
	//1. 이름파일을 읽어서 nameList 작성
	public void readNameList(String nameFile)  throws Exception ;
	
	//2. 성씨파일을 읽어서 famList 작성
	public void readFamList(String famFile)  throws Exception ;
	
	//3. nameList와 famList를 적절히 조합하여
	// 한국사람이름 list를 만들어서 파일에 기록
	public void writeNameFile(String korNameFile,int length)  throws Exception ;

	
}
