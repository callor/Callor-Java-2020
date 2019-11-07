package com.callor.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DataGramServerV1 {
	public static void main(String args[]) throws SocketException {
		DatagramServer server = new DatagramServer();
		server.start();
	}
}

class DatagramServer extends Thread {
	private DatagramSocket socket;

	public DatagramServer() throws SocketException {
		super();
		// DatagramPacket을 받기 위한 Socket 생성
		// 9999 : Listen할 Port
		socket = new DatagramSocket(9999);
	}

	public void run() {
		while (true) {
			try {
				// 데이터를 받을 버퍼
				byte[] inbuf = new byte[256];
				// 데이터를 받을 Packet 생성
				DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
				// 데이터 수신
				// 데이터가 수신될 때까지 대기됨
				socket.receive(packet); // 수신된 데이터 출력
				System.out.println("received length : " + packet.getLength() + ", received data : "
						+ new String(packet.getData(), 0, packet.getLength()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
