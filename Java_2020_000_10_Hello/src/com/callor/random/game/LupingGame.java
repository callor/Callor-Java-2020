package com.callor.random.game;

import java.util.Random;
import java.util.Scanner;

/*
 * Random Class를 사용하여 1 ~ 100까지의 임의의 정수를 만들고
 * 키보드로 정수를 입력받아 수를 맞추는 게임
 * 
 * 입력한값(inputNum)와 Random수(rndNum)와 비교하여
 * rndNum > inputNum : 작은값 입력
 * rndNum < inputNum : 큰값 입력
 * rndNum == inputNum : 맞았어요
 * 
 * 반복문으로 실행
 * 
 */
public class LupingGame {

	public static void main(String[] args) {

		Random rnd = new Random();
		Scanner scan = new Scanner(System.in);

		String dLine = String.format("%020d",0).replace("0", "=");
		String sLine = String.format("%020d",0).replace("0", "-");
		
		int rndNum = rnd.nextInt(100) + 1;
		int yesCount = 0;
		while(true) {
			
			System.out.print("숫자입력(-1:끝내기) >>");
			int inputNum = scan.nextInt();
			if(inputNum < 0) {
				System.out.println("Good Bye !!!");
				break;
			}
			
			if(inputNum == rndNum) {
				System.out.println(dLine);
				System.out.println("맞았어요 참잘했어요 !!!");
				System.out.printf("%d 번 만에 맞추었네요\n",++yesCount);
				System.out.println(sLine);
				if(yesCount < 3) {
					System.out.println("대단한 예지력 입니다 !!");
				} else if(yesCount > 4 && yesCount < 10) {
					System.out.println("조금만 더 분발해 봐요!!");
				} else {
					System.out.println("많이 노력해야 하겠어요 @_@");
				}
				System.out.println(dLine);
				yesCount = 0;
				
			} else if(inputNum > rndNum) {
				System.out.println("너무 큰 값을 입력했어요!!!");
			} else if(inputNum < rndNum) {
				System.out.println("너무 작은 값을 입력했어요 !!");
			}
			yesCount ++;
			
		}
		scan.close();
		
	}

}
