package com.callor.stream.input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputStream2String {

	public static void main(String[] args) throws IOException {

		String hello = "hello world";
		InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));

		@SuppressWarnings("resource")
		Scanner s = new Scanner(is).useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		System.out.println(result);
		s.close();

	}

}
