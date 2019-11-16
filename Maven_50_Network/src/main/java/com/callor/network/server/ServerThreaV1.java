package com.callor.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreaV1 implements Runnable {

	ServerSocket server = null;
	
	public ServerThreaV1(ServerSocket server) {
		this.server = server;
	}
	
	public void run() {
		
		Socket client = null;
		
		// 클라언트 응답대기
		try {
			client = this.server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Client : " 
					+ client.getInetAddress().toString());
		InputStream is = null;
		
		try {
			is = client.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			byte[] reader = new byte[255];
			try {
				int msgSize = is.read(reader);
				String message = new String(reader,0,msgSize,"UTF-8");
				System.out.println(message);
				if(message.equals("-Q")) break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Server STOP!!");
	}
}
