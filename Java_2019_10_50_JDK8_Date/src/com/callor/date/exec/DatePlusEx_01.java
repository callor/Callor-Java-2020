package com.callor.date.exec;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePlusEx_01 {

	public static void main(String[] args) throws ParseException {

		// 현재 날짜 추출
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    
	    // 현재 날짜로 부터 2개월 2개일 이후
	    // cal.add(Calendar.DATE, 2);
	    // cal.add(Calendar.MONTH, 2);

	    // 특정 형태의 날짜로 값을 뽑기
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String strDate1 = df.format(cal.getTime());
	    System.out.println("curDate: " + strDate1);

	    cal.add(Calendar.DATE,14);
	    String strDate2 = df.format(cal.getTime());
	    System.out.println("+14 Date: " + strDate2);

	    System.out.println(strDate1.compareTo(strDate2));
	    
	    // 날짜 차이 계산
	    long difTime = df.parse(strDate2).getTime() - df.parse(strDate1).getTime();
	    long difDate = difTime / (60 * 60 * 24 * 1000) ;
	    System.out.println("comp: " + difDate);
	    
	    // 특정일로 부터 날짜 더하기
	    try {
	        Date date = df.parse("2019-10-31");
	         
	        // 날짜 더하기
	        cal.setTime(date);
	        cal.add(Calendar.DATE, 2);
	        cal.add(Calendar.MONTH, 2);
	        System.out.println(df.format(cal.getTime()));
	         
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}

}
