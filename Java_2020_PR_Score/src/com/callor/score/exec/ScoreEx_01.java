package com.callor.score.exec;

import java.util.Scanner;

import com.callor.config.Lines;
import com.callor.score.service.StudentService;
import com.callor.score.service.StudentServiceImplV1;

public class ScoreEx_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentService studentService = new StudentServiceImplV1();

		
		while(true) {
			System.out.println(Lines.dLine);
			System.out.println("빛고을 대학 학사관리 V1");
			System.out.println(Lines.dLine);
			System.out.println("1. 성적입력");
			System.out.println(Lines.dLine);
			System.out.print("업무선택 >> ");
			String strMenu = scan.nextLine();
			int intMenu = 0 ;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if(intMenu == -1) break;
			else if(intMenu == 1); // 성적입력
			
		}
		
	}

}
