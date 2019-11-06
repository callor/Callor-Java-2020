package com.callor.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/*
 * Connecting to a URL
 * 
 * URL 객체를 생성한 다음 openConnection method를 사용하여 
 * URLConnection 객체를 생성할 수 있습니다. 
 *
 * URLConnection.connect method를 사용하여 Connection을 초기화 할 수 있는데 
 * 매번 명시적으로 호출하지 않아도 됩니다. 
 * getInputStream, getOutputStream 같은 method를 호출할 때 암묵적으로 호출하기 때문입니다.
 * 
 */
public class URLConnectionReader {

	public static void main(String[] args) throws Exception {

		URL callor = new URL("https://callor.com/");
		
		/*
		 * openConnection() 을 생성한 후
		 * 이후에 getInputStream, getOutputStream같은 method를 호출하면
		 * 암묵적으로 connect() method가 호출된다
		 */
		URLConnection callorOpen = callor.openConnection();
		callorOpen.connect(); // 사용하지 않아도 된다.
		
		BufferedReader in = new BufferedReader(new InputStreamReader(callorOpen.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();

	}
}
