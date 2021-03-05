package com.callorscor.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callorscor.model.ScoreVO;
import com.callorscor.service.ScoreService;
import com.callorscor.values.Values;

public class ScoreServiceImplV1 implements ScoreService {

	private List<ScoreVO> scoreList;
	private final String scoreFileName;
	
	
	public ScoreServiceImplV1() {
		this("src/com/callorscor/exec/score.txt");
	}

	public ScoreServiceImplV1(String scoreFileName) {
		this.scoreFileName = scoreFileName;
		scoreList = new ArrayList<ScoreVO>();
	}


	@Override
	public void maikScore() {
		// scoreList = new ArrayList<ScoreVO>();
		
		/*
		 *  트릭 : 전체리스트를 삭제하기
		 *  removeAll은 매개변수로 지정된 리스트와 일치하는 항목을 삭제한다
		 *  자기 자신을 매개변수로 지정하여 전체 리스트를 삭제해 준다
		 */
		scoreList.removeAll(scoreList);
		Random rnd = new Random();
		for(int i = 0 ; i < 20 ; i ++) {
			String strNum = String.format("%03d",i+1);
			int score[] = new int[5];
			for(int j = 0 ; j < score.length ; j++) {
				score[j] = rnd.nextInt(100) + 1;
			}
			ScoreVO scoreVO = new ScoreVO(strNum,score[0],score[1],score[2],score[3],score[4]);
			scoreList.add(scoreVO);
		}
	}

	@Override
	public void saveScoreToFile() throws IOException {
		this.saveScoreToFile(this.scoreFileName);
	}

	@Override
	public void saveScoreToFile(String fileName) throws IOException {
		FileWriter fileWriter = null;
		PrintWriter printer = null;	
		
		fileWriter = new FileWriter(scoreFileName);
		printer = new PrintWriter(fileWriter);
		
		for(ScoreVO scoreVO : scoreList) {
			printer.print(scoreVO.getNum() + ":");
			printer.print(scoreVO.getKor() + ":");
			printer.print(scoreVO.getEng() + ":");
			printer.print(scoreVO.getMath() + ":");
			printer.print(scoreVO.getMusic() + ":");
			printer.println(scoreVO.getHistory());
		}
		printer.close();
		fileWriter.close();


	}

	@Override
	public void printAllScore() throws IOException {

		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		fileReader = new FileReader(this.scoreFileName);
		buffer = new BufferedReader(fileReader);
		
		scoreList.removeAll(scoreList);
		
		while(true) {
			String reader = buffer.readLine();
			if(reader == null) break;
			
			String[] scores = reader.split(":");
			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setNum(scores[0]);
			scoreVO.setKor(Integer.valueOf(scores[1]));
			scoreVO.setEng(Integer.valueOf(scores[2]));
			scoreVO.setMath(Integer.valueOf(scores[3]));
			scoreVO.setMusic(Integer.valueOf(scores[4]));
			scoreVO.setHistory(Integer.valueOf(scores[5]));
			scoreList.add(scoreVO);
		}
		buffer.close();
		fileReader.close();
		
		this.sumAndAvg();
		this.printScore();
	}
	
	private void sumAndAvg() {
		for(ScoreVO vo : scoreList) {
			
			int total = vo.getKor();
			total += vo.getEng();
			total += vo.getMath();
			total += vo.getMusic();
			total += vo.getHistory();
			
			float avg = (float)total / 5;
			
			vo.setTotal(total);
			vo.setAvg(avg);
		}
	}
	
	private void printScore() {
		System.out.println(Values.dLine);
		System.out.println("빛나라 고교 성적일람표 2021");
		System.out.println(Values.dLine);
		System.out.println();
		
		System.out.println(Values.dLine);
		System.out.println("순번\t국어\t영어\t수학\t음악\t국사\t총점\t평균");
		System.out.println(Values.sLine);
		
		for(ScoreVO vo : scoreList) {
			System.out.print(vo.getNum() + "\t");
			System.out.printf("%3d\t",vo.getKor());
			System.out.printf("%3d\t",vo.getEng());
			System.out.printf("%3d\t",vo.getMath());
			System.out.printf("%3d\t",vo.getMusic());
			System.out.printf("%3d\t",vo.getHistory());
			System.out.printf("%3d\t",vo.getTotal());
			System.out.printf("%3.2f\n",vo.getAvg());
		}
		System.out.println(Values.dLine);
	}
	

	@Override
	public void printStudentScore() {
		// TODO Auto-generated method stub

	}

}
