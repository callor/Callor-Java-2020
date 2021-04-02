package com.callor.score.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.Values;

public class ScoreServiceImplV1 implements ScoreService {
	
	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	
	public ScoreServiceImplV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}
	
	public void selectMenu() {
		while(true) {
			Values.dLines(50);
			System.out.println("빛고을 고등학교 성적처리 시스템 2021");
			Values.sLines(50);
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			Values.dLines(50);
			System.out.print("업무선택>> ");
			String strMenu = scan.nextLine();
			
			if(strMenu.equals("QUIT")) {
				break;
			}
			
			Integer intMenu  = null;
			try {
				intMenu = Integer.valueOf(strMenu);
				switch (intMenu) {
				case 1 :
					break;
				case 2:
					break;
				}
			} catch (NumberFormatException e) {
				Values.message("[Message] 업무를 선택해야 합니다");
//				e.printStackTrace();
			}
		}
		System.out.println("업무종료!!!");
		
	}

	@Override
	public void inputScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printScoreList() {
		// TODO Auto-generated method stub
		
	}
	
	

}
