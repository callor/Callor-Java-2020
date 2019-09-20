package com.callor.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedReader_04 {

	public static void main(String[] args) {

		String[] names = new String[200];
		
		String nameFile = "src/com/callor/files/영어이름들.txt";
		
		FileReader fr ;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(nameFile);
			buffer = new BufferedReader(fr);
			for(int i = 0 ; i < names.length ; i++) {
				String nameLine = buffer.readLine();
				if(nameLine == null) break;
				names[i] = nameLine;
			} // 배열에 담기
			
			// 파일읽기를 끝내고 다른 코드를 계속 실행해할경우
			// 가급적(원칙적으로) buffer와 fr을 close()한다.
			buffer.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try end
		
		//=======================================
		// names 배열의 임의 위치에 있는 문자열을
		// : 을 기준으로 잘라서
		// 우리말 이름을 보여주고
		// 영어이름을 입력받아
		// 맞추는 코드를 작성하시오
		int namesC = names.length;
		int intIndex = (int)(Math.random() * namesC);
		
		// names[intIndex] =  1:ABC:에이씨
		String[] arrName = names[intIndex].split(":");

		// arrName[0] = 숫자
		// arrName[1] = 영문자
		// arrName[2] = 우리말
//		System.out.println(arrName[0]);
//		System.out.println(arrName[1]);
//		System.out.println(arrName[2]);
		
		try {
			
			System.out.print("[" + arrName[2] + "]");
			System.out.println("에 해당하는 영어 이름은?");
			Scanner scanner = new Scanner(System.in);
			System.out.print(">> ");
			String inputName = scanner.nextLine();
			if(arrName[1].equalsIgnoreCase(inputName)) {
				System.out.println("맞았습니다");
			} else {
				System.out.println("아쉽네요");
				 System.out.println(names[intIndex]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("문제 출제 오류");
		}
		
		
		
		
		//============================
		 
	}

}





