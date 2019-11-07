package com.callor.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ChatServerV1 {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10001);
		HashMap<String, Object> hm = new HashMap<String, Object>();
		while (true) {
			System.out.println("접속을 기다립니다.");
			Socket client = server.accept();
			ChatThread chatThread = new ChatThread(client, hm);
			chatThread.start();
		}
	}
}

class ChatThread extends Thread {
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap<String, Object> hm;
	private boolean initFlag = false;

	public ChatThread(Socket sock, HashMap<String, Object> hm) throws IOException {

		this.sock = sock;
		this.hm = hm;
		
		// 접속한 client socket을 출력포트로 설정
		// 메시지 전송용 스트림
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		
		// 접속한 client socket을 입력포트로 설정
		// 메시지 수신용 스트림
		br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		id = br.readLine();
		
		broadcast(id + "님이 접속하셨습니다.");
		System.out.println("접속한 사용자의 아이디 : " + id);
		synchronized (hm) {
			hm.put(this.id, pw);
		}
		initFlag = true;

	}

	public void run() {
		String line = null;
		try {

			while ((line = br.readLine()) != null) {
				if (line.equals("/quit")) {
					break;
				}
				if (line.indexOf("/to") == 0) {
					sendmsg(line);
				} else {
					broadcast(id + " : " + line);
				}
			}
			
			// 채팅이 끝나면 현재 연결정보 삭제
			synchronized (hm) {
				hm.remove(id);
			}
			
			broadcast(id + "님이 접속을 종료했습니다.");
			
			// 연결 소켓 제거
			if (sock != null) {
				sock.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendmsg(String msg) {
		int start = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", start);
		if (end != -1) {
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end + 1);
			Object obj = hm.get(to);
			if (obj != null) {
				PrintWriter pw = (PrintWriter) obj;
				pw.println(id + "님이 다음의 귓속말을 보내셨습니다. : " + msg2);
				pw.flush();
			}
		}
	}

	public void broadcast(String msg) {
		synchronized (hm) {
			
			Set<String> keys = hm.keySet();
			for(String key : keys) {
				PrintWriter pw = (PrintWriter) hm.get(key);
				pw.print(msg);
				pw.flush();
			}
			
			/*
			Collection<Object> collection = hm.values();
			Iterator<?> iter = collection.iterator();
			while (iter.hasNext()) {
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(msg);
				pw.flush();
			}
			*/
			
		}
	}
}
