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

import com.callor.shop.model.CartVO;
import com.callor.shop.service.CartServiceV2;

/*
 * CartServiceImplV1 클래스를 상속받고
 * 새로운 확장 클래스를 만들기 위해 CartServiceV2 인터페이스를 imp 했다
 * 
 */
public class CartServiceImplV3 extends CartServiceImplV1 implements CartServiceV2 {

	private List<CartVO> cartList;
	private final Scanner scan;
	private final String saveFileName;

	public CartServiceImplV3() {
		scan = new Scanner(System.in);
		cartList = new ArrayList<CartVO>();
		saveFileName = "src/com/callor/shop/CartList.txt";
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
