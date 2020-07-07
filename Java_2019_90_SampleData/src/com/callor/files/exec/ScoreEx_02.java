package com.callor.files.exec;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class ScoreEx_02 {

	public static void main(String[] args)  {
		
		String scoreFile = "src/com/callor/files/subject_score.txt";

		Random rnd = new Random();
		// PrintWriter outPut = null;
		PrintStream outPut = System.out;
		
		try {
			outPut = new PrintStream(scoreFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 200 ; i++) {

			
			int intKor = rnd.nextInt(50) + 51;
			int intEng= rnd.nextInt(50) + 51;
			int intMath= rnd.nextInt(50) + 51;
			int intHistory= rnd.nextInt(50) + 51;
			int intSci = rnd.nextInt(50) + 51;
			
			int intSum = intKor + intEng + intMath + intHistory + intSci;
			float floatAvg = (float)intSum / 5;
					
			// 학번, 국어, 영어, 수학, 국사, 과학, 총점, 평균
			String strScore = String.format("%05d:%d:%d:%d:%d:%d:%d:%5.2f", i + 1,
					intKor,intEng,intMath,intHistory,intSci,intSum, floatAvg);
			System.out.println(strScore);
			outPut.println(strScore);

		}

		outPut.close();

	}

}
