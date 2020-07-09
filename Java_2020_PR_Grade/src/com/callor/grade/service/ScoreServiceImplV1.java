package com.callor.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.grade.config.DBContract;
import com.callor.grade.config.Lines;
import com.callor.grade.domain.Score;
import com.callor.grade.domain.Student;

public class ScoreServiceImplV1 implements ScoreService {

	protected List<Score> scoreList;
	protected String fileName;
	protected Scanner scan;
	
	protected StudentService studentService;
	
	public ScoreServiceImplV1() {
		this("src/com/callor/score/score.txt");
	}
	
	public ScoreServiceImplV1(String fileName) {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<Score>();
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
		
		String[] strSubject = {"국어","영어","수학","음악"};
		Integer[] intScore = new Integer[ strSubject.length ];
				
		for(int i = 0 ; i < strSubject.length ; i++) {
			System.out.printf("%s(END:종료)",strSubject[i]);
			String sc_score = scan.nextLine();
			intScore[i] = this.scoreCheck(sc_score);
			
			if(intScore[i] == -1) return false;
			else if(intScore[i] == null ) {
				i--;
				continue;
			}
		}
		
		score.setKor(intScore[0]);
		score.setEng(intScore[1]);
		score.setMath(intScore[2]);
		score.setMusic(intScore[3]);
		scoreList.add(score);
		
		return true;
	}

	@Override
	public void scoreList() {
		if(scoreList == null || scoreList.size() < 1) {
			System.out.println("★ ★ ★ 출력할 성적 일람표가 없습니다");
			this.loadScore();
			// return;
		};
		
		System.out.println(Lines.dLine);
		System.out.println("성적 일람표");
		System.out.println(Lines.dLine);
		System.out.println("학번\t|이름\t|국어\t|영어\t|수학\t음악\t총점\t평균\t|");
		System.out.println(Lines.sLine);
		
		for(Score score: scoreList) {
			System.out.printf("%s\t|",score.getNum());
			System.out.printf("%s\t|","이름");
			System.out.printf("%d\t|",score.getKor());
			System.out.printf("%d\t|",score.getEng());
			System.out.printf("%d\t|\n",score.getMath());
			System.out.printf("%d\t|\n",score.getMusic());
			
			System.out.printf("%d\t|\n",score.getSum());
			System.out.printf("%d\t|\n",score.getAvg());
		}
		System.out.println(Lines.dLine);
		System.out.println("출력이 완료되었습니다 아무키나 누르세요.....");
		scan.nextLine();		
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	

}
