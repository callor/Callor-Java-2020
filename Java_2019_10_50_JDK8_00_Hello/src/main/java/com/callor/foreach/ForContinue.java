package com.callor.foreach;

import java.util.Random;

public class ForContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rnd = new Random();
		int[] lottos = new int[6];
		for(int i = 0 ; i < 6 ; i++) {
			
			int num = rnd.nextInt(45) + 1;
			int index ;
			for(index = 0 ; index < lottos.length; index++) {
				if(lottos[index] == num) {
					break;
				}
			}
			if(index >= lottos.length) {
				lottos[i] = num;
			} else {
				i--;
				// continue;
			}
		}
		
		for(int i : lottos) {
			System.out.print(i+"\t");
		}
		
		
	}

}
