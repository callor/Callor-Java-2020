package com.callor.files.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class ScoreEx_01 {

	public static void main(String[] args)  {

		String[] subArray = {"국어","영어","수학","과학","국사"};
		String scoreFile = "src/com/callor/files/score.txt";

		Random rnd = new Random();
		PrintWriter outPut = null;
		try {
			outPut = new PrintWriter(scoreFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 200 ; i++) {

			String subject = subArray[i % subArray.length];
			int score = rnd.nextInt(50) + 51;
					
			// 학번, 과목, 점수
			String strScore = String.format("%05d:%s:%d", i + 1,subject, score);

			System.out.println(strScore);
			outPut.println(strScore);

		}

		outPut.close();

	}

}
