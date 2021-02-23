package com.callor.array.applications;

import java.util.Random;
import java.util.Scanner;

/*
 * 정수형 배열 100개를 선언하고
 * 1 ~ 10까지의 난수를 생성하여 저장
 * 
 * 키보드로 1 ~ 10까지의 정수를 입력받아
 * 해당 값이 들어 있는 배열 요소를 출력
 */
public class ArrayEx_01 {

	public static void main(String[] args) {
		// Random 클래스를 사용하여 rnd 객체를 선언하고
		// = new Random() 명령을 사용하여
		// rnd 객체를 인스턴스화(化..으로 만든다) 시킨다
		// rnd : Random 클래스의 인스턴스
		Random rnd = new Random();

		// rnd 인스턴스의 nextInt() method를 호출(실행)하라
		// 매개변수값으로 100을 전달하라

		// Random 클래스의 nextInt() method에
		// 정수 100을 전달하고 실행하여
		// return 하는 결과를 num 변수에 저장하라
		// num 변수에는 0 ~ 99까지 중 1개의 숫자가
		// 저장 될 것이다.
		int num = rnd.nextInt(100);

		// num 변수에는 1 ~ 100까지 중 1개의 숫자가
		// 저장 될 것이다
		num = rnd.nextInt(100) + 1;

		// 정수 100개를 저장할 배열변수를 선언
		// 생성(초기화 : 사용할 준비를 하라) 하라
		int[] intNums = new int[100];

		// 0 ~ (intNums.length - 1) 횟수만큼
		// 반복문을 실행하겠다
		for (int i = 0; i < intNums.length; i++) {

			// intNums의 i 번째 위에 정수 100을 저장하라

			// i 값은 0 ~ (intNums.length - 1)까지
			// 값을 갖게 되므로 전체 배열 100개에
			// 정수 100을 저장하라
			intNums[i] = 100;

		}

		/*
		 * 0 ~ intNums.length 까지의 정수를 만들어서 intNums의 위치값으로 정하고
		 * 1 ~ 10까지의 임의 숫자를 생성하여 intNums의 배열에 채워 넣어라
		 */
		for (int i = 0; i < intNums.length; i++) {

			// Random 클랫의 nextInt() method를
			// 호출하면서 정수 10을 전달하고
			// return 된 결과에 1을 더하라
			// 1 ~ 10까지 중 임의 숫자 1개를
			// 만들어라
			// 임의로 생성된 숫자를
			// intNums의 i 번째 위치에 저장하라
			intNums[i] = rnd.nextInt(10) + 1;
		}
		
Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 1 ~ 10까지 중 숫자 입력!");
		System.out.print("숫자 >> ");
		int keyNum = scan.nextInt();

		// intNums는 어떤 값이 저장되어 있는지 모른다
		// 단 1 ~ 10 까지의 숫자들이 들어 있을 것이다
		// intNums 배열에 저장된 숫자들 중에서
		// 키보드로 입력받은 값( keyNum에 저장되어 있다 )과
		// 같은 값들이 몇번(몇개) 저장되어 있는지
		// 알고 싶다
		
		int count = 0; // 몇개인지 개수를 헤아릴 변수 
		for(int i = 0 ; i < intNums.length ; i++) {
			
			// if(intNums[i] == keyNum) {  }
			boolean bYes = intNums[i] == keyNum;
			if(bYes) {
				// 카운드를 세서...
				count ++;
				System.out.printf("%d, ",intNums[i] );
			}
		}
		System.out.println();
		System.out.println(keyNum + "의 갯수 : " + count);
		
		
		System.out.printf( "값 %d가 저장된 위치!!!\n",keyNum);
		for(int positon = 0 ; positon < intNums.length ; positon++) {
			if(intNums[positon] == keyNum) {
				System.out.print(positon + ", ") ;
			}
		}
		System.out.println();
		
		
		System.out.printf( "값 %d가 최초로 나타난 위치!!!\n",keyNum);
		for(int positon = 0 ; positon < intNums.length ; positon++) {
			if(intNums[positon] == keyNum) {
				System.out.println(positon) ;
				break;
			}
		}
		
		
		int lastPos = 0;
		System.out.printf( "값 %d가 마지막으로 나타난 위치!!!\n",keyNum);
		for(int positon = 0 ; positon < intNums.length ; positon++) {
			if(intNums[positon] == keyNum) {
				System.out.printf("%d, ",positon) ;
				// 키보드로 입력한 값이 일치할때마다
				// 그 위치를 lastPos에 저장한다.
				lastPos = positon;
			}
		}
		System.out.println();
		// 여기 오면 lastPos에 저장된 값은
		// 가장 마지막으로 lastPos = position이 실행된
		// 결과만 담고 있다
		System.out.println(lastPos);
		

	}

}
