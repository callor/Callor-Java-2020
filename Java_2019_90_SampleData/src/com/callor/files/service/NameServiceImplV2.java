package com.callor.files.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NameServiceImplV2 extends NameServiceImplV1{

	List<String> korNameList;
	
	public NameServiceImplV2() {
	
		korNameList = new ArrayList<String>();
		
		// Collections.sort(), Collections.shuffle() 등을 사용할때는
		// LinkedList로 초기화 하는 것이 효율적이다
		korNameList = new LinkedList<String>();
		
	}
	
	@Override
	public void writeNameFile(String korNameFile,int length) throws FileNotFoundException {

		if(length < 1) {
			System.out.println("갯수는 1개 이상으로");
			return ;
		}
		
		Random rnd = new Random();
		int nameSize = nameList.size();
		int famSize = famList.size();
		
		System.out.println("=======================");
		System.out.printf("이름표 작성 시작 :  %d\n",
				System.currentTimeMillis());
		
		for(int i = 0 ; i < 10000 ; i++) {
			String strName = famList.get(rnd.nextInt(famSize));
			strName += nameList.get(rnd.nextInt(nameSize));
			korNameList.add(strName);
		}
		System.out.println("-----------------------");
		System.out.printf("List 작성 완료 : %d\n",
				System.currentTimeMillis());
		
		Collections.sort(korNameList);
		System.out.println("-----------------------");
		System.out.printf("정렬 완료 : %d \n",
				System.currentTimeMillis());
	
		PrintWriter fileOut = new PrintWriter(korNameFile);
		for(String s : korNameList) {
			fileOut.println(s);
		}
		fileOut.close();
		
		System.out.println("-----------------------");
		System.out.printf("모두 완료 : %d \n",
				System.currentTimeMillis());

		
		
	}

	
	
}
