package com.callor.array;

import java.nio.charset.StandardCharsets;

public class BytesToArray {

	public static void main(String[] args) {

		String str = "this is a string";
		byte[] byteValue = str.getBytes(StandardCharsets.UTF_8);

		System.out.println("str : " + str);
		System.out.println("byteValue : " + byteValue);
		System.out.println("byteValue.toString() : " + byteValue.toString());

		str = new String(byteValue, StandardCharsets.UTF_8);
		System.out.println("str : " + str);

	}

}
