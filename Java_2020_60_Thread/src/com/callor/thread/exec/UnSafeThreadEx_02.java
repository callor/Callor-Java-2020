package com.callor.thread.exec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.callor.thread.exec.datas.LazySingle;

public class UnSafeThreadEx_02 {
	
	static DateFormat unsafeDateFormat = new SimpleDateFormat("yyyy/MM/dd");
	static LazySingle ls = LazySingle.getInstance();
	public static void main(String[] args) throws InterruptedException{
        
        Thread thread1 = new Thread(() ->{
        	ls.sum = 0;
            for(int i=0;i<100;i++){
            	ls.sum += i + 1;
            }
            System.out.println(ls.sum);
        });
        
        Thread thread2 = new Thread(() ->{
        	ls.sum = 0;
            for(int i=0;i<100;i++){
            	ls.sum += i + 1;
            }
            System.out.println(ls.sum);
        });
        
        thread1.start();
        thread1.sleep(1000);
        thread2.start();
    }


	
}
