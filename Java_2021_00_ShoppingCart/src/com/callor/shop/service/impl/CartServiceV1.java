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

import com.callor.shop.config.LayoutService;
import com.callor.shop.model.CartVO;
import com.callor.shop.service.CartService;

public class CartServiceV1 implements CartService {

	private List<CartVO> cartList;
	private final Scanner scan;
	private final String saveFileName;

	public CartServiceV1() {
		cartList = new ArrayList<CartVO>();
		scan = new Scanner(System.in);
		saveFileName = "src/com/callor/shop/CartList.txt";
	}

	@Override
	public void inputCart() {

		System.out.println(LayoutService.dLine);
		System.out.println("쇼핑카트 상품 추가");
		System.out.println(LayoutService.sLine);
		System.out.print("구매자 >> ");
		String strUserName = scan.nextLine();

		System.out.print("상품명 >> ");
		String strProductName = scan.nextLine();

		int intPrice = 0;
		while (true) {
			System.out.print("단가(500원 이상) >> ");
			String strPrice = scan.nextLine();
			try {
				intPrice = Integer.valueOf(strPrice);
				if (intPrice < 500) {
					System.out.println("단가는 500원 이상으로 입력하세요");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("단가는 숫자만 입력할 수 있습니다.");
			}
		}
		int intQty = 0;
		while (true) {
			System.out.print("수량(1개 이상) >> ");
			String strQty = scan.nextLine();
			try {
				intQty = Integer.valueOf(strQty);
				if (intPrice < 1) {
					System.out.println("수량은 1개 이상 입력하세요.");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("수량은 숫자만 입력할 수 있습니다.");
			}
		}

		CartVO cartVO = new CartVO();
		cartVO.setUserName(strUserName);
		cartVO.setProductName(strProductName);
		cartVO.setPrice(intPrice);
		cartVO.setQty(intQty);
		cartVO.setTotal(intPrice * intQty);
		cartList.add(cartVO);
	}

	@Override
	public void printAllCart() {
		this.printHeader();

		for (CartVO vo : cartList) {
			this.printData(vo);
		}
		System.out.println(LayoutService.dLine);
	}

	@Override
	public void printUserCart() {

		System.out.println(LayoutService.dLine);
		System.out.println("출력할 구매자 이름을 입력하세요");
		System.out.println(LayoutService.sLine);
		System.out.print("이름 >> ");
		String userName = scan.nextLine();

		this.printHeader();
		for (CartVO vo : cartList) {
			if (vo.getUserName().equals(userName)) {
				this.printData(vo);
			}
		}
		System.out.println(LayoutService.dLine);
	}

	private void printHeader() {
		System.out.println(LayoutService.dLine);
		System.out.println("구매자\t상품명\t단가\t수량\t금액");
		System.out.println(LayoutService.sLine);
	}

	private void printData(CartVO vo) {
		System.out.printf("%s\t%s\t%d\t%d\n", vo.getUserName(), vo.getProductName(), vo.getPrice(), vo.getQty(),
				vo.getTotal());
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
