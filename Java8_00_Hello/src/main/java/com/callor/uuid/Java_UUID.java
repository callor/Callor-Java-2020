package com.callor.uuid;

import java.util.UUID;

public class Java_UUID {

	
	public static void main(String[] args) {
		
		UUID temp = UUID.randomUUID();
		System.out.println("UUID : " + temp.toString());
		
		String msb = Long.toHexString(temp.getMostSignificantBits());
		String lsb = Long.toHexString(temp.getLeastSignificantBits());
		System.out.println("MSB : " + msb);
		System.out.println("LSB : " + lsb);
		String uuidString = Long.toHexString(temp.getMostSignificantBits())
		     + Long.toHexString(temp.getLeastSignificantBits());
		
		System.out.println("UUID : " + uuidString);
		
	}
	
	
}
