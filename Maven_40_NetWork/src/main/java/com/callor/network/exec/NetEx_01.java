package com.callor.network.exec;

import java.io.IOException;
import java.net.InetAddress;

public class NetEx_01 {

	public static void main(String[] args) throws IOException {

		/* 
		 * Inet.getByName()
		 * www.naver.com : Domain Name 을
		 * DNS에게 조회하여 IP Address를 가져오는 method
		 * 
		 */
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver);
	
		InetAddress callor = InetAddress.getByName("callor.com");
		System.out.println(callor);

		InetAddress daum = InetAddress.getByName("daum.net");
		System.out.println(daum);

		// ip Address만 추출하는 method
		System.out.println(naver.getHostAddress());
		
		// domain 만 추출하는 method
		System.out.println(naver.getHostName());
		
		// 내 컴퓨터 NIC(Network Inteface Card, 랜카드)에 설정된 IP
		InetAddress local = InetAddress.getLocalHost();
		
		// 내 컴퓨터 내부의 App 들이 서로 통신을 하거나
		// 통신 test 용으로 만들어진 특별한 IP
		InetAddress loopBack = InetAddress.getLoopbackAddress();
		
		System.out.println("local : " + local);
		System.out.println("loopBack : " + loopBack );
		
		/*
		 *  port
		 *  TCP/IP 프로토콜에서 1개의 IP 주소에 다수의 어플리케이션이
		 *  통신할수 있도록 하는 구조
		 *  0 ~ 65535까지 사용할수 있고
		 *  그중 0 ~ 1023까지는 임의로 사용하수 없도록 정해져 있다
		 *  사용자 port를 임의로 설정하여 사용하면
		 *  1개의 컴퓨터에서 여러개의 통신어플리케이션을 작동시킬수 있다.
		 */
		
	}

}
