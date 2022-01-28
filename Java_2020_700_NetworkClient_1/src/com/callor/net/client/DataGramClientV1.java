package com.callor.net.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DataGramClientV1 {
	public static void main(String args[]) {
		DatagramClient client = new DatagramClient();
		client.start();
	}
}

class DatagramClient extends Thread {
	public DatagramClient() {
		super();
	}

	public void run() {
		try {
			while (true) {
				// 전송할 데이터 : 현재 시간
				String data = String.valueOf(System.currentTimeMillis());
				// 전송할 DatagramPacket 생성
				DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length,
						InetAddress.getByName("127.0.0.1"), 9999);
				// DatagramSocket 생성
				DatagramSocket socket = new DatagramSocket();
				// DatagramPacket 전송
				socket.send(packet);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}