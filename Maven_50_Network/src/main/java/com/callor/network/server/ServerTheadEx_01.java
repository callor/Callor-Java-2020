package com.callor.network.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerTheadEx_01 {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket();
		InetSocketAddress iSocket = new InetSocketAddress(8085);
		server.bind(iSocket);
		
		ServerThreaV1 tServer = new ServerThreaV1(server);
		Thread tRun = new Thread(tServer);
		tRun.start();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("Server>>");
			String strSend = scanner.nextLine();
			System.out.println("Server:" + strSend);
		}
	}
}
