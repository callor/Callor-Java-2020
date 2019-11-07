package com.callor.net.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientV1 {

	public static void main(String[] args) throws Exception {
//		if (args.length != 2) {
//			System.out.println("사용법 : java ChatClient id 접속할 서버 ip");
//			System.exit(1);
//		}
		
		Socket sock = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endflag = false;
		
		String serverIP = "192.168.0.8";
		sock = new Socket(serverIP, 10001);// 아아디,포트
		
		pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		pw.println(serverIP);
		pw.flush();
		
		InputThread it = new InputThread(sock, br);
		it.start();
		
		String line = null;
		while ((line = keyboard.readLine()) != null) {
			pw.println(line);
			pw.flush();
			if (line.equals("/quit")) {
				endflag = true;
				break;
			}
		}
		System.out.println("클라이언트 접속 종료");
		pw.close();
		br.close();
		sock.close();

	}
}

class InputThread extends Thread {
	private Socket sock = null;
	private BufferedReader br = null;

	public InputThread(Socket sock, BufferedReader br) {
		this.sock = sock;
		this.br = br;
	}

	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
