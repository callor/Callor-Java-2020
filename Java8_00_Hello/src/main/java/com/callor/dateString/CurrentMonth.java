package com.callor.dateString;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentMonth {
	
    /**
     * Get / Find Current Month In Java
     */
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM"); 
        System.out.println("Current Month: "+ dateFormat.format(new Date())); 
    }

}
