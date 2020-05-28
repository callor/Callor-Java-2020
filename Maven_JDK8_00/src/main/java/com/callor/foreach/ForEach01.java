package com.callor.foreach;

import java.util.List;

import org.jooq.lambda.Seq;

/**
 * Hello world!
 */
public class ForEach01
{
	public static void main(String[] args) {
        int max = 3;
  
        getString(1);

        /*
         * Seq dependency
         *	<dependency>
         *		<groupId>org.jooq</groupId>
         *		<artifactId>jool</artifactId>
         *		<version>0.9.14</version>
         *	</dependency>
         */
        
        List<String> alphabet = Seq
            .rangeClosed('A', 'Z')
            .map(Object::toString)
            .toList();
  
        Seq.rangeClosed(1, max)
           .flatMap(length ->
               Seq.rangeClosed(1, length - 1)
                  .foldLeft(Seq.seq(alphabet), (s, i) -> 
                      s.crossJoin(Seq.seq(alphabet))
                       .map(t -> t.v1 + t.v2)))
           .forEach(System.out::println);
    }
	
	// 엑셀 셀 주소 리스트 만들기
	private static String getString(int n) {
	    char[] buf = new char[(int) Math.floor(Math.log(25 * (n + 1)) / Math.log(26))];
	    for (int i = buf.length - 1; i >= 0; i--) {
	        n--;
	        buf[i] = (char) ('A' + n % 26);
	        n /= 26;
	    }
	    return new String(buf);
	}
	
	
}
