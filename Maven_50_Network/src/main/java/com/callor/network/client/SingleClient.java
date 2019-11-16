package com.callor.network.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


/*
 * 
 * 네트워크에서 Client
 * 필요에 따라서 실행을하여 Server에게 무엇인가 요청을 하고
 * 결과를 기다리는 구조
 *  
 */
public class SingleClient {

	public static void main(String[] args) throws IOException {

		String serverIP = "192.168.123.45"; // client에서 접속하고자하는 서버의 IP
		int serverPort = 8085; // client에서 접속하고자 하는 서버의 Port
		Socket mySocket = new Socket(serverIP,serverPort);
		Scanner scanner = new Scanner(System.in);
		
		// 서버에서 전송되어올 메시지를 수신하기 위해서
		InputStream is = mySocket.getInputStream();
		DataInputStream data = new DataInputStream(is);
		
		// Server에게 메시지를 전송하기 위해서
		OutputStream os = mySocket.getOutputStream();
		
		String msg = "";
		while(true) {
			
			System.out.print(">>");
			String sendMsg = scanner.nextLine();
			
			// 서버에게 보낼 문자열을 byte형식의 배열값을 변환하기 위해
			// 임시로 사용할 메모리 버퍼를 선언
			// 키보드에서 입력된 문자열을 UTF-8 방식으로 encoding하여
			// buffer 배열변수에 저장
			byte[] buffer = sendMsg.getBytes("UTF-8");
			os.write(buffer);
			
			// msg = data.readUTF();
			// System.out.println("Server:" + msg);
			
		}
	}

}
