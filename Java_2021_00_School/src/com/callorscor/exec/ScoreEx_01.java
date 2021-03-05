package com.callorscor.exec;


import java.io.IOException;

import com.callorscor.service.MenuService;
import com.callorscor.service.ScoreService;
import com.callorscor.service.impl.MenuServiceImplV1;
import com.callorscor.service.impl.ScoreServiceImplV1;

public class ScoreEx_01 {
	
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "src/com/callorscor/exec/score.txt";
		MenuService mService = new MenuServiceImplV1();
		ScoreService sService = new ScoreServiceImplV1(fileName);
		
		while(true) {
			Integer selectMenu = mService.selectMenu();
			if(selectMenu == null) break;
			else if(selectMenu == 1) {
				sService.maikScore();
			} else if(selectMenu == 2) {
				sService.saveScoreToFile();
			} else if(selectMenu == 3) {
				sService.printAllScore();

			}
		}
	}

}
