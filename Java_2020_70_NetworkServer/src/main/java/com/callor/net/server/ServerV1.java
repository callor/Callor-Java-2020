package com.callor.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerV1 {
	
	public static final int PORT = 6077;
    public static void main(String[] args) {
 
    	// Client에서 들어오는 요청을 기다리는 서버소켓 구현 class
        ServerSocket serverSocket = null;

        // is > isr > buffer
        // pw > osw > os
        
        // byte단위 입력 Stream
        InputStream is = null;
        
        // InputStream을 char 단위로 읽고 쓰는 Reader 인터페이스의 보조 스트림
        InputStreamReader isr = null;
        
        // Buffer를 통해 char 단위로 읽고 쓰는 보조 스트림
        BufferedReader br = null;
 
        // byte단위로 출력 Stream
        OutputStream os = null;

        // byte단위로 쓰는 Outputstream에 대한 특정 인코딩의 char 단위로 읽고 쓰는 보조스트림
        OutputStreamWriter osw = null;
        
        // text로 대표되는 객체들을 출력하는 보조 스트림
        PrintWriter pw = null;
        
        // 키보드 입력 스트림
        Scanner sc = new Scanner(System.in);
 
        try {
        	
            // 1. Server Socket 생성
            serverSocket = new ServerSocket();
 
            // 2. Binding : Socket에 SocketAddress(IpAddress + Port) 바인딩 함
            // 		localHost의 IP Address 를 바인
            InetAddress inetAddress = InetAddress.getLocalHost();
            String localhost = inetAddress.getHostAddress();
 
            serverSocket.bind(new InetSocketAddress(localhost, PORT));
 
            System.out.println("[server] binding " + localhost);
 
            // 3. accept(클라이언트로 부터 연결요청을 기다림)
            Socket socket = serverSocket.accept();

            // 클라이언트의 IP 주소 정보를 추
            InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            
            System.out.println("[server] connected by client");
            System.out.println("[server] Connect with " + socketAddress.getHostString() + " " + socket.getPort());
 
            while (true) {
 
                // inputStream 가져와서 (주 스트림) StreamReader와 BufferedReader로 감싸준다 (보조 스트림)
                is = socket.getInputStream();
                isr = new InputStreamReader(is, "UTF-8");
                br = new BufferedReader(isr);
 
                // outputStream 가져와서 (주 스트림) StreamWriter와 PrintWriter로 감싸준다 (보조 스트림)
                os = socket.getOutputStream();
                osw = new OutputStreamWriter(os, "UTF-8");
                pw = new PrintWriter(osw, true);
 
                String buffer = null;

                // 클라이언트로 부터 데이터가 들어오기를 기다린다.
                buffer = br.readLine(); // Blocking
                if (buffer == null) {
 
                    // 정상종료 : remote socket close()
                    // 메소드를 통해서 정상적으로 소켓을 닫은 경우
                    System.out.println("[server] closed by client");
                    break;
 
                }
 
                System.out.println("[server] recived : " + buffer);
                pw.println(buffer);
 
            }
 
            // 3.accept(클라이언트로 부터 연결요청을 기다림)
            // .. blocking 되면서 기다리는중, connect가 들어오면 block이 풀림
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
 
            try {
 
                if (serverSocket != null && !serverSocket.isClosed())
                    serverSocket.close();
 
            } catch (Exception e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
 
}
