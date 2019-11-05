package com.callor.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerThreadV1 implements Runnable{
	
	Socket SS;
    int ID;
    public ServerThreadV1(Socket SS, int ID) {
        this.SS = SS;
        this.ID = ID;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                InputStream IS = SS.getInputStream();
                byte[] bt = new byte[256];
                int size = IS.read(bt);
 
                String output = new String(bt, 0, size, "UTF-8");
                System.out.println(ID + "> " + output);
            }
        } catch (IOException e) {
            System.out.println("--" + ID + " user OUT");
        }
    }

}
