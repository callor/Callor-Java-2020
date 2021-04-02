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

	protected String[] subList;

	public ScoreServiceImplV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		subList = new String[] { "국어", "영어", "수학", "과학", "국사" };
	}

	public void selectMenu() {
		while (true) {
			Values.dLines(50);
			System.out.println("빛고을 고등학교 성적처리 시스템 2021");
			Values.sLines(50);
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			Values.dLines(50);
			System.out.print("업무선택>> ");
			String strMenu = scan.nextLine();

			if (strMenu.equals("QUIT")) {
				break;
			}

			
			
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
				switch (intMenu) {
				case 1:
					this.inputScore();
					break;
				case 2:
					this.printScoreList();
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
		// TODO 성적입력 Main

		while (true) {
			Values.dLines(50);
			System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
			Values.dLines(50);
			String strName = scan.nextLine();
			if (strName.equals("QUIT")) {
				return;
			}

			Values.dLines(50);
			System.out.println(strName + " 학생이름의 성적을 입력하세요");
			System.out.println("\t성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT");
			Values.sLines(50);

//			Integer intKor = this.inputScore("국어");
//			Integer intEng = this.inputScore("영어");
//			Integer intMath = this.inputScore("수학");
//			Integer intSci = this.inputScore("과학");
//			Integer intHist = this.inputScore("국사");

			Integer[] intScores = new Integer[ subList.length ];
			for (int index = 0; index < subList.length; index++) {
				intScores[index] = this.inputScore(subList[index]);
				if (intScores[index] == null)
					return;
			}

			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setName(strName);
			scoreVO.setKor(intScores[0]);
			scoreVO.setEng(intScores[1]);
			scoreVO.setMath(intScores[2]);
			scoreVO.setSci(intScores[3]);
			scoreVO.setHist(intScores[4]);

			this.scoreTotalAndAvg(scoreVO);
			this.addScore(scoreVO);

		}
	}

	@Override
	public void printScoreList() {
		// TODO 성적리스트 출력
		
		int nLines = 80;
		
		System.out.println("빛고을 고교 성적 리스트");
		Values.dLines(nLines);
		System.out.print("순번\t이름\t");
		for(String subject : subList) {
			System.out.printf("%4s\t",subject);	
		}
		System.out.println("총점\t\t평균");
		Values.sLines(nLines);
		
		
		int[] intSubTotal = new int[subList.length];
		int allTotal = 0;
		float allAvg = 0;
		
		int nSeq = 0;
		for(ScoreVO scoreVO : scoreList) {
			
			intSubTotal[ 0 ] += scoreVO.getKor();
			intSubTotal[ 1 ] += scoreVO.getEng();
			intSubTotal[ 2 ] += scoreVO.getMath();
			intSubTotal[ 3 ] += scoreVO.getSci();
			intSubTotal[ 4 ] += scoreVO.getHist();
			
			allTotal += scoreVO.getTotal();
			allAvg += scoreVO.getAvg();
			
			System.out.print(++nSeq + "\t");
			System.out.print(scoreVO.getName()+"\t");
			System.out.printf("%7d\t",scoreVO.getKor());
			System.out.printf("%7d\t",scoreVO.getEng());
			System.out.printf("%7d\t",scoreVO.getMath());
			System.out.printf("%7d\t",scoreVO.getSci());
			System.out.printf("%7d\t",scoreVO.getHist());
			System.out.printf("%7d\t",scoreVO.getTotal());
			System.out.printf("%3.2f\n",scoreVO.getAvg());
		}
		Values.sLines( nLines );
		System.out.print("총점\t\t");
		for(int total : intSubTotal) {
			System.out.printf("%7d\t",total);
		}
		
		System.out.printf("%7d\t",allTotal);
		System.out.print(allAvg);
		System.out.printf("%3.2f\n",(allAvg/scoreList.size()));
		Values.dLines(  nLines );

	}

	private Integer inputScore(String subject) {
		while (true) {
			System.out.print(subject + ">> ");
			String strScore = scan.nextLine();
			if (strScore.equals("QUIT"))
				return null;

			Integer intScore = Integer.valueOf(strScore);
			if (intScore < 0 || intScore > 100) {
				Values.message("성적은 0 ~ 100까지 범위이어야 합니다");
			} else {
				return intScore;
			}
		}
	}

	private void scoreTotalAndAvg(ScoreVO scoreVO) {
		Integer intTotal = scoreVO.getKor();
		intTotal += scoreVO.getEng();
		intTotal += scoreVO.getMath();
		intTotal += scoreVO.getSci();
		intTotal += scoreVO.getHist();
		
		float floatAvg = Float.valueOf(intTotal) / subList.length;

		scoreVO.setTotal(intTotal);
		scoreVO.setAvg(floatAvg);

	}

	private void addScore(ScoreVO scoreVO) {
		this.scoreList.add(scoreVO);
		this.addViewScore();
	}

	private void addViewScore() {
		// TODO 마지막 입력된 학생의 성적을 출력

		ScoreVO scoreVO = this.scoreList.get(this.scoreList.size() - 1);
		this.addViewScore(scoreVO);
	}

	@SuppressWarnings("unused")
	private void addViewScore(int index) {
		// TODO List의 index를 전달받아 출력

		ScoreVO scoreVO = this.scoreList.get(index);
		this.addViewScore(scoreVO);
	}

	private void addViewScore(ScoreVO scoreVO) {
		// TODO ScoreVO 객체를 받아 성적출력

		Values.dLines(50);
		System.out.printf("%s 홍길동 학생의 성적이 추가 되었습니다\n", scoreVO.getName());
		Values.dLines(50);

		System.out.printf("국어 : %s \n", scoreVO.getKor());
		System.out.printf("영어 : %s \n", scoreVO.getEng());
		System.out.printf("수학 : %s \n", scoreVO.getMath());
		System.out.printf("과학 : %s \n", scoreVO.getSci());
		System.out.printf("국사 : %s \n", scoreVO.getHist());
		Values.dLines(50);
	}

}
