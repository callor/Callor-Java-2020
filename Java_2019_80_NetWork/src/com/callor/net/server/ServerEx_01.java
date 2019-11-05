package com.callor.net.server;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerEx_01 {

	
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        ServerSocket MSS = null;
	 
	        try {
	            MSS = new ServerSocket();
	            MSS.bind(new InetSocketAddress(InetAddress.getLocalHost(), 4040));
	 
	            System.out.println("--SERVER Close : input num");
	            System.out.println("--SERVER Waiting...");
	            ConnectThreadV1 cnt = new ConnectThreadV1(MSS);
	            // cnt.start();
	            cnt.run();
	 
	            int temp = input.nextInt();
	 
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	 
	        try {
	            MSS.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	 
	    }// MAIN


	
}
