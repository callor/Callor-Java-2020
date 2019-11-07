package com.callor.net.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClientV1 {
	private static final String SERVER_IP = "192.168.219.107";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Socket socket = null;

		try {
			// 2. 서버와 연결을 위한 소켓을 생성
			socket = new Socket();

			// 3. 생성한 소켓을 서버의 소켓과 연결(connect)
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
