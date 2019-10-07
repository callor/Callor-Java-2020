package com.biz.iolist.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IolistService {
	
	protected List<String> proList ;
	protected List<BuyVO> buyList;
	
	/*
	 * readProduct() method를 실행하여 proList를 생성한 후
	 * proList를 사용하여
	 * 
	 * 상품매입정보를 생성
	 * 1. 날짜 : 2019-09-26
	 * 2. 단가(부가세제외단가) 
	 * 		: (상품정보의 상품단가)에서 부가세를 제외한 금액
	 * 3. 부가세 : (상품정보의 상품단가) - (2번에서 계산한)단가
	 * 4. 수량은 : 10개 부터 100개까지의 임의 수
	 * 5. 합계 : 단가(부가세제외단가) * 수량
	 * 
	 * 상품명, 상품매입정보를 BuyVO에 담고
	 * 		20개를 생성하여 buyList에 추가하기
	 */
	public void buyMake() {
		
		Random rnd = new Random();
		int nSize = proList.size();
		
		// pro = 상품이름:단가
		for(int i = 0 ; i < 20 ; i++) {
			
			// proList개수의 범위내에서 정수 1개를 임의 생성하라
			int index = rnd.nextInt(nSize);
			
			// 임의의 상품정보 추출하기
			String strProduct = proList.get(index);
			
			String[] pros = strProduct.split(":");
			// pros[0] 상품명, pros[1] 단가
			
			BuyVO  bVO = new BuyVO();
			bVO.setProName(pros[0]);
			
			// 상품정보에있는 금액을 일단 bVO의 price 에 담기
			bVO.setPrice(Integer.valueOf(pros[1]));

			// 계산식을 사용해서 부가세 별도 단가 계산,
			// 부가세 계산 총액 계산
			
			// 부가세 별도 단가 생성
			int intPrice = Integer.valueOf(pros[1]);
			intPrice = (int)(intPrice / 1.1); // 부가세 별도 금액 계산
			int intVat = bVO.getPrice() - intPrice;
			
			int intQty = rnd.nextInt(90) + 10; // 난수로 수량 생성
			int intTotal = intPrice * intQty;
			
			// 상품단가를 부가세 별도 단가로 변경
			bVO.setPrice(intPrice);
			bVO.setVat(intVat);
			bVO.setTotal(intTotal);
			
			// buyList 담기
			buyList.add(bVO);
			
		}
	}
	
	/*
	 * 상품정보.txt 파일을 읽어서
	 * 상품이름:가격 형식의 문자열을 리스트 생성하는 곳
	 * 
	 * proList에는 다음과 같은 문자열들이 리스트로 만들어져 있을 것이다
	 * 		상품이름:가격
	 */
	public void readProduct(String proFileName) throws Exception {
		
		proList = new ArrayList<String>();
		FileReader fileReader = new FileReader(proFileName);
		BufferedReader buffer = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			
			if(reader.length() < 1) continue;
			proList.add(reader);
			
		}
		buffer.close();
		fileReader.close();

	}
}
