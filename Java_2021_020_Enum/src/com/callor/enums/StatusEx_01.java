package com.callor.enums;

public class StatusEx_01 {
	
	
	
	
	public static void main(String[] args) {
		
		Status status = Status.대기;
		
		if(status == Status.대기) {
			System.out.println("대기중");
		} else if(status == Status.실패) {
			System.out.println("실패함");
		} else if(status == Status.완료) {
			System.out.println("완료됨");
		}
		
		switch (status) {
		case 대기: {
			System.out.println("대기중");
			break;
		}
		case 완료: {
			System.out.println("완료됨");
			break;
		}
		case 실패: {
			System.out.println("실패함");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
		
		if(status == Status.findByEnum("GO")   ) {
			System.out.println("GO");
		} else  
		// enum에 존재하지 않은 값을 사용하면 IllegalArgumentException이 발생한다
		if(status == Status.valueOf("GO")) {
			System.out.println("GO");
		}
	}

}
