package com.callor.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectThreadV1 implements Runnable {
	
	ServerSocket MSS;
    int Count = 1;
 
    ConnectThreadV1(ServerSocket MSS) {
        this.MSS = MSS;
    }
 
    @Override
    public void run() {
        while (true) {
			int intId = (int)(Math.random() * 100);
			
		    Socket SS = null;
			try {
				SS = MSS.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Socket SS = new Socket();
		    System.out.println("--" + intId + " user login");
		    ServerThreadV1 ust = new ServerThreadV1(SS, Count);

		    // Runnable을 직접 호출하지 말고 Thread 대리자를 사용하라
		    // ust.run();
		    Thread thread = new Thread(ust);
		    thread.start();
		    
		    Count++;
		}
    }
}
