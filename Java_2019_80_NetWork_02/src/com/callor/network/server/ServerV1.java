package com.callor.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV1 {

	public static void main(String[] args) throws IOException {

		// Socket 을 만들고
		ServerSocket server = new ServerSocket(8085);
		
		// 누군가 나를 불러줄때까지 기다리기
		System.out.println("Wait....");
		Socket listen = server.accept();
		
		System.out.println("Connect : " + listen.getInetAddress());
		System.out.println("Port : " + listen.getLocalPort());
		
		while(true) { 
			
			// socket으로 부터 InputStream 정보를 가져오기
			// 값을 수신할 준비
			InputStream is = listen.getInputStream();
			
			// 값을 수신할 버퍼변수를 선언
			// 한번에 255바이트씩 가져오겠다.
			byte[] msg = new byte[255];
			
			// 버퍼만큼 데이터를 수신하기
			int msgSize = is.read(msg);
			
			// 수신한 데이터를 다시 UTF-8 디코딩
			String reader = new String(msg,0,msgSize,"UTF-8");
			System.out.println(">> " + reader );
		
		}
		
		
		
		// OutputStream os = listen.getOutputStream();
		// DataOutputStream dos = new DataOutputStream(os);
		
		
		
		
		
	}

}
