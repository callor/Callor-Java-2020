package com.callor.builder.exec;

import com.callor.builder.domain.ComputerVO;

public class BuilderEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ComputerVO cVO = ComputerVO.builder()
				.HDD("50G")
				.RAM("16G")
				.GraphicsCardEnabled(true)
				.BluetoothEnabled(true)
				.build();
		System.out.println(cVO.toString());
		
		// builder method를 이용하는 방법
		System.out.println(ComputerVO.builder().build());
		System.out.println(ComputerVO.builder().build());
		System.out.println(ComputerVO.builder().build());
		
		// Builder 생성자를 이용하는 방법
		System.out.println(new ComputerVO.Builder().build());
		System.out.println(new ComputerVO.Builder().build());
		System.out.println(new ComputerVO.Builder().build());
		
		
	}

}
