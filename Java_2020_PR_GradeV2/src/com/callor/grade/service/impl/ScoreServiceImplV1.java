package com.callor.grade.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.grade.config.DBContract;
import com.callor.grade.config.Lines;
import com.callor.grade.domain.Score;
import com.callor.grade.domain.Student;
import com.callor.grade.service.ScoreService;
import com.callor.grade.service.StudentService;

public class ScoreServiceImplV1 implements ScoreService {

	protected List<Score> scoreList;
	protected String fileName;
	protected Scanner scan;
	
	protected String[] strSubject;
	protected int subjectLength;
	
	protected StudentService studentService;
	
	public ScoreServiceImplV1() {
		this("src/com/callor/grade/exec/data/score.txt");
	}
	
	public ScoreServiceImplV1(String fileName) {
		this.scan = new Scanner(System.in);
		
		this.strSubject = new String[]{"국어","영어","수학","음악"};
		this.subjectLength = this.strSubject.length;
		
		this.scoreList = new ArrayList<Score>();
		this.fileName = fileName;
		this.studentService = new StudentServiceImplV1();
		this.studentService.loadStudent();
		
	}

	@Override
	public void loadScore(String scoreFile) {
		this.fileName = scoreFile;
		this.loadScore();
	}

	@Override
	public void loadScore() {
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			String reader = "";
			while((reader = buffer.readLine()) != null) {
				
				String[] scores = reader.split(":");
				Score score = new Score();
				
				score.setNum(scores[ DBContract.SCORE.SC_NUM ]);
				score.setKor(Integer.valueOf(scores[ DBContract.SCORE.SC_KOR ]));
				score.setEng(Integer.valueOf(scores[ DBContract.SCORE.SC_ENG ]));
				score.setMath(Integer.valueOf(scores[ DBContract.SCORE.SC_MATH ]));
				score.setMusic(Integer.valueOf(scores[ DBContract.SCORE.SC_MUSIC ]));
				
				scoreList.add(score);
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("성적정보 loading 오류!!!");
		} catch (IOException e) {
			System.out.println("성적정보파일 읽기 오류!!!");
		}
	}

	private Integer scoreCheck(String score) {
		
		if(score.equals("END")) return -1;
		
		Integer intScore = null;
		try {
			intScore = Integer.valueOf(score);
		} catch (Exception e) {
			System.out.println("점수는 정수만 가능합니다.");
			System.out.println("점수를 다시 입력해 주세요!!");
			return null;
		}
		
		if(intScore < 0 || intScore > 100) {
			System.out.println("점수는 0 ~ 100까지만 가능합니다");
			System.out.println("점수를 다시 입력해 주세요!!");
			return null;
		}
		return intScore;
		
	}
	
	@Override
	public boolean inputScore() {

		Score score = new Score();
		
		System.out.print("학번(END:종료) >> ");
		String sc_num = scan.nextLine();
		if(sc_num.equals("END")) return false;
		
		int intNum = 0;
		try {
			intNum = Integer.valueOf(sc_num);
		} catch (Exception e) {
			System.out.printf("입력한 문자열 %s\n",sc_num);
			System.out.println("학번은 (5자리이내) 숫자로만 입력하세요");
			return true;
		}
		
		sc_num = String.format("%05d", intNum);
		Student student = studentService.findByNum(sc_num);
		
		if(student == null) {
			System.out.println(Lines.dLine);
			System.out.printf("＠ ＠ 학생명부에 [%s] 학번이 없습니다\n",sc_num);
			System.out.println(Lines.dLine);
			return true;
		}
		score.setNum(sc_num);
		
		Integer[] intScore = new Integer[ subjectLength ];
				
		for(int i = 0 ; i < strSubject.length ; i++) {
			System.out.printf("%s(END:종료)",strSubject[i]);
			String sc_score = scan.nextLine();
			intScore[i] = this.scoreCheck(sc_score);
			
			if(intScore[i] == null ) {
				i--;
				continue;
			} else if(intScore[i] == -1) return false;
		}
		
		
		score.setKor(intScore[0]);
		score.setEng(intScore[1]);
		score.setMath(intScore[2]);
		score.setMusic(intScore[3]);
		scoreList.add(score);
		this.saveScoreVO(score);
		return true;
	}

	@Override
	public void scoreList() {
		if(scoreList == null || scoreList.size() < 1) {
			System.out.println("★ ★ ★ 출력할 성적 일람표가 없습니다");
			this.loadScore();
			// return;
		};
		
		int[] totalSum = new int[subjectLength];
		System.out.println(Lines.dLine);
		System.out.println("성적 일람표");
		System.out.println(Lines.dLine);
		System.out.println("학번\t|이름\t|국어\t|영어\t|수학\t|음악\t|총점\t|평균\t|");
		System.out.println(Lines.sLine);
		
		for(Score score: scoreList) {
			
			Student stVO = studentService.findByNum(score.getNum());
			
			System.out.printf("%s\t|",score.getNum());
			System.out.printf("%s\t|",stVO == null ? "[없음]" : stVO.getName());
			System.out.printf("%6d\t|",score.getKor());
			System.out.printf("%6d\t|",score.getEng());
			System.out.printf("%6d\t|",score.getMath());
			System.out.printf("%6d\t|",score.getMusic());
			
			System.out.printf("%6d\t|",score.getSum());
			System.out.printf("%5.1f\t|\n",score.getAvg());
			
			totalSum[0] += score.getKor();
			totalSum[1] += score.getEng();
			totalSum[2] += score.getMath();
			totalSum[3] += score.getMusic();
		}
		System.out.println(Lines.dLine);
		System.out.printf("%8s\t|","과목총점");
		int sumAndSum = 0;
		for(int sum : totalSum) {
			System.out.printf("%6d\t|",sum);
			sumAndSum += sum;
		}
		System.out.printf("%s\t|x\t|\n",sumAndSum);
		
		System.out.printf("%8s\t|","과목평균");
		float avgAndAvg = 0f;
		for(int sum : totalSum) {
			float avg = (float)sum / scoreList.size();
			System.out.printf("%5.2f\t|",avg);
			avgAndAvg += avg;
		}
		System.out.printf("x\t|%5.2f\t|\n",avgAndAvg / totalSum.length);
		System.out.println(Lines.dLine);
		
		
		System.out.println("출력이 완료되었습니다 아무키나 누르세요.....");
		scan.nextLine();		
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void calcSum() {
		for(Score scoreVO : scoreList) {
			int sum = scoreVO.getKor();
			sum += scoreVO.getEng();
			sum += scoreVO.getMath();
			sum += scoreVO.getMusic();
			scoreVO.setSum(sum);
		}
	}

	@Override
	public void calcAvg() {
		for(Score scoreVO : scoreList) {
			int sum = scoreVO.getSum();
			float avg = (float)sum / subjectLength;
			scoreVO.setAvg(avg);
		}
	}

	@Override
	public void saveScoreVO(Score score) {
		FileWriter fileWriter = null;
		PrintWriter pWriter = null;

		try {
			fileWriter = new FileWriter(this.fileName,true);
			pWriter = new PrintWriter(fileWriter);
			
			pWriter.printf("%s:", score.getNum());
			pWriter.printf("%d:", score.getKor());
			pWriter.printf("%d:", score.getEng());
			pWriter.printf("%d:", score.getMath());
			pWriter.printf("%d\n", score.getMusic());
			pWriter.flush();
			pWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

}
