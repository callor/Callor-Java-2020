package com.callor.score.exec;


import java.io.IOException;

import com.callor.score.service.MenuService;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;
import com.callor.score.service.impl.MenuServiceImplV1;
import com.callor.score.service.impl.ScoreServiceImplV1;
import com.callor.score.service.impl.StudentServiceImplV1;
import com.callor.score.values.Values;

public class SchoolEx_01 {
	
	
	public static void main(String[] args) throws IOException {
		
		String scoreFileName = "src/com/callor/score/exec/score.txt";
		String studentFileName = "src/com/callor/score/exec/student.txt";
		
		MenuService mService = new MenuServiceImplV1();
		ScoreService sService = new ScoreServiceImplV1(scoreFileName);
		StudentService stService = new StudentServiceImplV1(studentFileName);
		
		while(true) {
			Integer selectMenu = mService.selectMenu();
			if(selectMenu == null) break;
			else if(selectMenu == Values.MENU_MAKE) {
				sService.maikScore();
			} else if(selectMenu == Values.MENU_SAVE) {
				sService.saveScoreToFile();
			} else if(selectMenu == Values.MENU_PRINT) {
				sService.printAllScore();
			} else if(selectMenu == Values.MENU_STUDENT_SEARCH) {
				stService.loadStudentFromFile();
				stService.searchStudent();

			}
		}
	}

}
