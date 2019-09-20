package com.callor.builder.exec;

import com.callor.builder.domain.ComputerVO;

public class BuilderEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ComputerVO cVO = new ComputerVO.Builder()
				.HDD("50G")
				.RAM("16G")
				.GraphicsCardEnabled(true)
				.BluetoothEnabled(true)
				.build();
		System.out.println(cVO.toString());
	}

}
