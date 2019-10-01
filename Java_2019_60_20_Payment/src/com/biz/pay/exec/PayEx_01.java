package com.biz.pay.exec;

public class PayEx_01 {

	public static void main(String[] args) {

		int 급여 = 3758750;
		int 권명 = 50000; // 대한민국 화폐단위 최상위 금액
		int sw = 1;

		while(true) {

			if(급여 < 5) break;
			// 최초에 권명 50000 이므로
			// 매수는 5만원권 매수가 된다.
			int 매수 = (int)(급여 / 권명);
			System.out.printf("%d 원권 : %d\n",권명,매수);
			급여 -= (매수 * 권명);
			if(sw > 0) {
				권명 /= 5;	
			} else {
				권명 /= 2;
			}
			sw *= (-1);
		}
	}

}
