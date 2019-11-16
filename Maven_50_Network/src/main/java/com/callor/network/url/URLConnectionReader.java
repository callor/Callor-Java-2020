package com.callor.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader {
	public static void main(String[] args) throws IOException {

		// 일부 홈페이지(Site)는 주소를 직접 URL로 요청을하면
		// 주소변환 과정등의 문제로 접속이 불가능 하다.
		// 이때는 주소를 UTF-8로 encoding을 수행해 주어야 한다.
		String naverURL = "https://callor.com/index.html";
		
		URL naver = new URL(naverURL);
		URLConnection naverOpen = naver.openConnection();
		naverOpen.setDoInput(true);
		
		// 실제로 사용하지 않아도 **Stream이 작동될때마다 내부적으로
		// 자동으로 수행되는 코드
		
		BufferedReader buffer 
		= new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));
		
		String reader = "";
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
		buffer.close();
		
	}

}
