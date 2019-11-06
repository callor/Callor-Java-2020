package com.callor.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


/*
 * 
 * Writing to a URL Connection
 * 
 * URLConnection 객체를 사용하여 OutputStream 객체를 얻어서 
 * ObjectOutputStream을 생성한 다음 
 * URL로 원하는 데이터를 posting 한 뒤에 
 * 서버에서 처리한 결과를 
 * URLConnection객체의 InputStream을 받아서 BufferedReader로 읽는 프로그램입니다.
 * 
 */
public class Reverse {

	public static void main(String[] args) throws Exception {

		String strURL = "https://callor.com/index.html";
		String stringToReverse = URLEncoder.encode(strURL, "UTF-8");

		URL url = new URL(strURL);
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write("string=" + stringToReverse);
		out.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String decodedString;
		while ((decodedString = in.readLine()) != null) {
			System.out.println(decodedString);
		}
		in.close();
	}
}
