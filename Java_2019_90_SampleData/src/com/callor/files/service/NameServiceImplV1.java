package com.callor.files.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NameServiceImplV1 implements NameService {

	List<String> nameList;
	List<String> famList;

	// 클래스 이름과 같은 이름의 method이고
	// return type 없다(void, int...)
	public NameServiceImplV1() {
		nameList = new ArrayList<String>();
		famList = new ArrayList<String>();
	}
	
	@Override
	public void readNameList(String nameFile) throws Exception {
		FileReader fileReader = null;
		BufferedReader buffer = null;
		fileReader = new FileReader(nameFile);
		buffer = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			
			reader = buffer.readLine();
			if(reader == null) break;
			nameList.add(reader);
		}
		buffer.close();
		fileReader.close();
		
		//========== debuging code ========
		for(String s : nameList) {
			System.out.println(s);
		}
		//==================================
	}

	// 1:김(金):0000
	@Override
	public void readFamList(String famFile) throws Exception {
		FileReader fileReader = null;
		BufferedReader buffer = null;
		fileReader = new FileReader(famFile);
		buffer = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			
			// reader에서 한글성씨만 추출하기
			String[] fams = reader.split(":");

			// fams[1] 데이터 중에서 첫글자 1개만 필요
			// 1번이나 2번 중 선택
			//--------------------------
			// 1번코드
			String fam = fams[1].substring(0,1);
			//--------------------------

			//--------------------------
			// 2번코드
			String[] fams1 = fams[1].split("");
			fam = fams1[0];
			//--------------------------
			
			famList.add(fam);
		}
		buffer.close();
		fileReader.close();
		
		//--------------
		for(String s : famList) {
			System.out.println(s);
		}
	}

	@Override
	public void writeNameFile(String korNameFile,int length) throws FileNotFoundException {

		// nameList와 famList를 한번 섞어주기
		Collections.shuffle(nameList);
		Collections.shuffle(famList);
		
		int nameSize = nameList.size();
		int famSize = famList.size();
		
		PrintWriter fileOut = new PrintWriter(korNameFile);
		
		String strName = "";
		
		//----------------------------------------
		//1번코드
		for(int i = 0 ; i < 100 ; i++) {
			strName = famList.get(i) + nameList.get(i);
			System.out.println(strName);
			fileOut.println(strName);
		}
		System.out.println("===========================");
		
		//-----------------------------------------
		//2번코드
		Random rnd = new Random();
		for(int i = 0 ; i < 100 ; i++) {
			strName = famList.get(rnd.nextInt(famSize));
			strName += nameList.get(rnd.nextInt(nameSize));
			System.out.println(strName);
			fileOut.println(strName);
		}
		fileOut.close();

	}

}
