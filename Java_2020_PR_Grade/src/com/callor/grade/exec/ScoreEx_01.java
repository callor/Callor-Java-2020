package com.callor.grade.exec;

import java.util.Scanner;

import com.callor.grade.config.Lines;
import com.callor.grade.service.ScoreService;
import com.callor.grade.service.ScoreServiceImplV1;
import com.callor.grade.service.StudentService;
import com.callor.grade.service.StudentServiceImplV1;

public class ScoreEx_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentService studentService = new StudentServiceImplV1();
		ScoreService scoreService = new ScoreServiceImplV1();

		
		while(true) {
			System.out.println(Lines.dLine);
			System.out.println("빛고을 대학 학사관리 V1");
			System.out.println(Lines.dLine);
			System.out.println("1. 학생정보 입력");
			System.out.println("2. 학생 명부 출력");
			System.out.println("3. 성적입력");
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
			else if(intMenu == 1) {
				while(true) {
					if(!studentService.inputStudent()) break;
				}
				studentService.saveFile();
				
			} else if(intMenu == 2) {
				studentService.studentList();
			} else if(intMenu == 3) {
				while(true) {
					if(!scoreService.inputScore()) break;	
				}
				
			}; // 성적입력
		}
	}
}
