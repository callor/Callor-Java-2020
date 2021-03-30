package com.callor.score.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;
import com.callor.score.values.Values;

public class ScoreServiceImplKeyInput implements ScoreService {

	private Scanner scan;
	private String[] subList;
	private List<ScoreVO> scoreList;
	public ScoreServiceImplKeyInput() {
		scoreList = new ArrayList<ScoreVO>();
		scan = new Scanner(System.in);
	}
	
	
	@Override
	public void makeScore() {
		// TODO 키보드를 통해 점수를 입력받는다
		
		while(true) {
			
			System.out.println(Values.dLine(50));
			System.out.println("고려 고교 성적처리");
			System.out.println(Values.dLine(50));
			for(int index = 0 ; index < subList.length ; index++) {
				Integer score = -1;
				while(true) {
					System.out.printf("%s 교과목 점수(0 ~ 100, -1:QUIT)\n");
					System.out.print("점수 >> ");
					score = scan.nextInt();
					if(score < 0 || score > 100) {
						System.out.println("점수는 0 ~ 100까지만 입력가능");
					} else {
						break;
					}
				}
				if(score == -1) {
					break;
				}
			}
		}
		
	}

	@Override
	public void saveScoreToFile() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveScoreToFile(String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAllScore() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printStudentScore() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	

}
