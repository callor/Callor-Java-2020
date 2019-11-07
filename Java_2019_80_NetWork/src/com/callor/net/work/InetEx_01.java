package com.callor.net.work;

import java.io.IOException;
import java.net.InetAddress;

public class InetEx_01 {

	public static void main(String[] args) throws IOException {

		// DNS 정보 얻어오기
		InetAddress callorIP = InetAddress.getByName("www.callor.com");
		
		// getAddress() 의 리턴값 ??
		for(byte b : callorIP.getAddress()) {
			System.out.printf("%c\n",(char)b);
		}

		// domain의 IP 주소
		System.out.printf("callor.com : %s\n",callorIP.getHostAddress());
		
		// 도달 가능 시간 찾기
		// Hope : routre 경로
		// TTL : Hope의 개수
		for(int i = 1 ; i < 100;i++) {
			System.out.printf("Hope : %d = %b\n",i,callorIP.isReachable(i));	
		}
		
		// local 정보 얻어오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.printf("local IP : %s\n",localIp);
		
		
	}

}
