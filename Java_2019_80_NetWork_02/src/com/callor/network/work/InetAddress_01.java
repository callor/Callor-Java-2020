package com.callor.network.work;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddress_01 {

	public static void main(String[] args) throws IOException {
		
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver);
		System.out.printf("naver IP : %s\n",naver.getHostAddress());
		System.out.printf("naver HOST : %s\n",naver.getHostName());
		
		InetAddress local = InetAddress.getLocalHost();
		InetAddress loopBack = InetAddress.getLoopbackAddress();
		
		// 컴퓨터 이름과 IP
		System.out.println(local);
		
		// localhost Loopback
		System.out.println(loopBack);
		
		
	}
	
}
