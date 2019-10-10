package com.callor.net.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		  String serverIP = "192.168.0.150";
	        int port = 6974;
	        System.out.println("Connect to " + serverIP + ":" + String.valueOf(port));
	        Socket server = new Socket(serverIP, port);

	        InputStream is = server.getInputStream();
	        DataInputStream dis = new DataInputStream(is);
	        System.out.println("not problem");


	        String data = null;
	        do
	        {
	            data = dis.readUTF();
	            System.out.println("Server : " + data);
	        }while(!data.equals("exit"));
	        System.out.println("Disconnect with server.");
	        dis.close();
	        server.close();
	        
	}

}
