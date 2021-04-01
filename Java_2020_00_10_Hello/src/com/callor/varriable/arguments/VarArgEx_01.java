package com.callor.varriable.arguments;

import java.util.Arrays;

/*
 * 가변인자란? 
 * Varargs ( = variable Arguments)
 * 
 * 필요에 따라 매개변수(인수)를 가변적으로 조정할 수 있는 기술.
 * 기존에는 메서드의 매개변수를 고정적으로 지정해 주어야만 했으나 
 * JDK1.5부터는 동적으로 매개변수의 개수를 지정해 줄수 있게 되었다.
 * 
 * 여러 인자를 나열한 예)
 * public String methodName(String str1, String str2, String str3){  }
 * 
 * 가변인자를 사용한 예)
 * public String methodName(String... str) { }
 * 
 * 
 * 가변인수의 대표적인 예는 PrintStream의 printf()와 MessageFormat의 format()이다.
 * 
 * PrintStream 클래스  의 printf 메서드
 * public PrintStream printf(String format, Object... args)
 * 
 * String 클래스  의 format 메서드
 * public static String format(String format, Object... args) 
 * 
 * 예시)
 * System.out.printf("%04d-%02d-%02d (%s)", 2014, 6, 18,new String("javaking"));
 * 결과) 2014-06-18 (javaking)
 * 
 * 
 * 가변인자를 사용할때 한가지 주의해야할점은 오버로딩을 하는경우이다.
 * 그리고 메서드 정의시 가변인자는 제일 마지막에 정의 되어야 한다.
 */

public class VarArgEx_01 {

	public static void main(String[] args) {
		concat("-", "Korea","Republic","of","대한민국","우리나라");
	}
	
	/*
	 * 가변인자 method()
	 * 인자의 개수를 정하지 않고 임의의 개수의 인지를 받을 수 있다.
	 * 이때 인자는 배열로 받아진다.
	 */
    private static String concat(String delim, String... args) {
                
        System.out.println(args); //가변인자는 배열 형태로 받아진다.
        System.out.println("args를 통해 받은 요소들 나열 : "+Arrays.toString(args)); //[100, 200, 300]
        System.out.println("매개변수 개수 : "+ args.length); //3
        
        String result ="";        
        
        //요소와 구분자 결합
        for(int i=0; i<args.length; i++){            
            result += args[i];
            if(i<args.length-1) result += delim;              
        }        
        return result;        
       
        
    }
	
}
