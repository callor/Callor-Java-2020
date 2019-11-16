package com.callor.network.server;

import java.io.InputStream;
import java.net.Socket;

/*
 * 여러 client가 접속을 했을때
 * client별로 thread를 생성하고
 * 메시지 수신을 처리하기 위한 방법
 * 
 * 접속되는 client마다 thread를 생성
 */
public class ServerSubThreadV1 implements Runnable {

	Socket client = null;
	int id = 0;

	public ServerSubThreadV1(Socket client, int id) {
		this.client = client;
		this.id = id;
	}

	public void run() {

		try {
			
			InputStream is = client.getInputStream();
			byte[] reader = new byte[255];
			int msgSize = is.read(reader);
			
			String msg = new String(reader,0,msgSize,"UTF-8");
			System.out.printf("ID(%d) : %s ",this.id,msg);
			
		} catch (Exception e) {
			// TODO: handle exception
			// 클라이언트가 강제로 접속을 멈추면
			// exception이 발생할텐데
			// exception 대신에 USER OUT 메시지를 콘솔에 표시
			System.out.println(this.id + " USER OUT!!");
		}
		
		
	}
	
	
}
