package com.callor.shop.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.shop.config.Values;
import com.callor.shop.model.CartVO;
import com.callor.shop.service.CartServiceV2;

public class CartServiceImplV2 implements CartServiceV2 {

	private List<CartVO> cartList;
	private final Scanner scan;
	private final String saveFileName;

	public CartServiceImplV2() {
		scan = new Scanner(System.in);
		cartList = new ArrayList<CartVO>();
		saveFileName = "src/com/callor/shop/CartList.txt";
	}

	
	private void printHeader() {
		System.out.println(Values.dLine);
		System.out.println("구매자\t상품명\t단가\t수량\t금액");
		System.out.println(Values.sLine);
	}
	
	private void printBody(CartVO cartVO) {
		// cartVO에서 각 인스턴스 변수를 읽어서 출력
		System.out.print(cartVO.getUserName()+"\t" );
		System.out.printf("%s\t",cartVO.getProductName());
		System.out.printf("%d\t",cartVO.getQty());
		System.out.printf("%d\t",cartVO.getPrice());
		System.out.printf("%d\n",cartVO.getTotal());
	}
	
	@Override
	public void inputCart() {
		// TODO 카트 추가 method
		System.out.println(Values.dLine);
		System.out.println("장바구니 추가");
		System.out.println(Values.sLine);

		System.out.println("구매자 이름을 입력하세요");
		System.out.print(">> ");
		String strUserName = scan.nextLine();

		System.out.println("추가할 상품이름을 입력하세요");
		System.out.println(">> ");
		String strProductName = scan.nextLine();

		System.out.println("추가할 상품의 구매 수량을 입력하세요");

		Integer intQty = 0;
		while (true) {
			System.out.println(">> ");
			String strQty = scan.nextLine();
			try {
				intQty = Integer.valueOf(strQty);
			} catch (Exception e) {
				System.out.println("수량은 숫자만 입력하세요");
			}
			if (intQty < 1) {
				System.out.println("수량은 1 이상 입력하세요");
			} else {
				break;
			}
		}

		Integer intPrice = 0;
		while (true) {
			System.out.println(">> ");
			String strPrice = scan.nextLine();
			try {
				intPrice = Integer.valueOf(strPrice);
			} catch (Exception e) {
				System.out.println("가격은 숫자만 입력하세요");
			}
			if (intPrice < 100) {
				System.out.println("가격은 100 이상 입력하세요");
			} else {
				break;
			}
		}
		Integer intTotal = intQty * intPrice;

		CartVO cartVO = new CartVO();
		cartVO.setUserName(strUserName);
		cartVO.setProductName(strProductName);
		cartVO.setQty(intQty);
		cartVO.setPrice(intPrice);
		cartVO.setTotal(intTotal);

		System.out.println(Values.dLine);
		System.out.println("입력한 상품");
		System.out.println(Values.sLine);
		System.out.printf("구매자 :  %s\n", cartVO.getUserName());
		System.out.printf("상품명 :  %s\n", cartVO.getProductName());
		System.out.printf("수량 : %d\n", cartVO.getQty());
		System.out.printf("갸격 : %d\n", cartVO.getPrice());
		System.out.printf("합계: %d\n", cartVO.getTotal());
		System.out.println(Values.dLine);
		System.out.print("추가할까요(YES)?");
		String strYesNo = scan.nextLine();
		if (strYesNo.equals("YES")) {
			cartList.add(cartVO);
			System.out.println("저장완료!!");
		} else {
			System.out.println("저장취소!!");
		}

	}

	@Override
	public void printAllCart() {
		// TODO Auto-generated method stub
		
		this.printHeader();

		// 카트리스트의 상품개수를 
		//		계산하여 nSize에 저장
		int nSize = cartList.size();
		for(int i = 0 ; i < nSize ; i++) {
			CartVO cartVO = cartList.get(i);
			this.printBody(cartVO);
		}
		System.out.println(Values.sLine);

	}

	@Override
	public void printUserCart() {
		// TODO Auto-generated method stub
		System.out.println(Values.dLine);
		System.out.println("구매자별 리스트");
		System.out.println("구매자명 >> ");
		String strUserName = scan.nextLine();
		
		this.printHeader();
		int nSize = cartList.size();
		for(int i = 0 ; i < nSize ; i++) {
			CartVO cartVO = cartList.get(i);
			if(cartVO.getUserName().equals(strUserName)) {
				this.printBody(cartVO);	
			}
		}

	}
	
	@Override
	public void saveCartToFile() {
		
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		try {
			fileWriter = new FileWriter(saveFileName);
			printWriter = new PrintWriter(fileWriter);
			
			for(CartVO vo : cartList) {
				printWriter.printf("%s:%s:%d:%d:%d\n",
						vo.getUserName(),
						vo.getProductName(),
						vo.getPrice(),
						vo.getQty(),
						vo.getTotal());
			}
			printWriter.close();
			fileWriter.close();
			System.out.println("* 장바구니 리스트를 파일에 모두 SAVE 하였습니다 *");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void loadCartFromFile() {
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(saveFileName);
			buffer = new BufferedReader(fileReader);
			
			String reader = new String();
 
			this.cartList = new ArrayList<CartVO>();
			while((reader = buffer.readLine()) != null) {
				// System.out.println(reader);
				String[] carts = reader.split(":");
				CartVO vo = new CartVO();
				vo.setUserName(carts[0]);
				vo.setProductName(carts[1]);
				vo.setPrice(Integer.valueOf(carts[2]));
				vo.setQty(Integer.valueOf(carts[3]));
				
				cartList.add(vo);
			}
			buffer.close();
			fileReader.close();
			System.out.println("* 장바구니 파일을 모두 LOAD 하였습니다 *");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
