package com.callor.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.shop.config.Values;
import com.callor.shop.model.CartVO;
import com.callor.shop.service.CartService;

public class CartServiceImplV1 implements CartService {

	private List<CartVO> cartList;
	private final Scanner scan;


	public CartServiceImplV1() {
		cartList = new ArrayList<CartVO>();
		scan = new Scanner(System.in);
	}

	@Override
	public void inputCart() {

		System.out.println(Values.dLine);
		System.out.println("쇼핑카트 상품 추가");
		System.out.println(Values.sLine);
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
		System.out.println(Values.dLine);
	}

	@Override
	public void printUserCart() {

		System.out.println(Values.dLine);
		System.out.println("출력할 구매자 이름을 입력하세요");
		System.out.println(Values.sLine);
		System.out.print("이름 >> ");
		String userName = scan.nextLine();

		this.printHeader();
		for (CartVO vo : cartList) {
			if (vo.getUserName().equals(userName)) {
				this.printData(vo);
			}
		}
		System.out.println(Values.dLine);
	}

	private void printHeader() {
		System.out.println(Values.dLine);
		System.out.println("구매자\t상품명\t단가\t수량\t금액");
		System.out.println(Values.sLine);
	}

	private void printData(CartVO vo) {
		System.out.printf("%s\t%s\t%d\t%d\n", vo.getUserName(), vo.getProductName(), vo.getPrice(), vo.getQty(),
				vo.getTotal());
	}

}
