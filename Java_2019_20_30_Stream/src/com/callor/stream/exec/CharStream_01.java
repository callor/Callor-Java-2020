package com.callor.stream.exec;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * 문자 단위 IO클래스, 문자스트림 
 * 뒤에 접미사가 Reader, Writer가 주로 붙는다.
 * Reader와 Writer는 문자 단위 입출력 스트림에서 가장 기본이 되는 클래스다.
 * InputSteam, OutputStream과 마찬가지로 추상클래스로 직접 객체화가 될 수 없다.
 * 
 * 생성자가 중요한 이유는 생성자에 전달한 인자가 무엇이냐에 따라서 읽어 들여야할 대상과 써야 할 대상이 달리지기 때문이다.
 * Reader과 Writer도 InputStream, OutputStream을 생성자에서 받아들인다.
 * 즉 바이트로 읽어들이는 InputStream을 통해 데이터를 읽어들여 문자단위로 읽어들이는 방식으로 변형한다는 것이며, 
 * 바이트로 쓰는 OutputStream을 통해 데이터를 쓰긴 하지만 문자 단위로 쓰는 것처럼 변형한다는 것이다.
 */
public class CharStream_01 {

	
	/*
	 * 	문자 단위로 파일 내용을 읽어 들여 화면에 출력하는 프로그램이다.
	 * 	바이트스트림을 이용한 IO와 거의 같다. 
	 * 마찬가지로 바이트스트림을 이용하는 IO와 문자 스트림을 이용하는 IO에는 
	 * 어떤 클래스들이 있는지만 확인하고 한 두개를 코딩해보면 될 것 같다.
	 * 
	 */
	public static void main(String[] args) {

		if(args.length != 1) {
            System.out.println("사용법 : java StreamReaderTest 파일명");
            System.exit(0);
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream(args[0]);
            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(System.out);
            char[] buffer = new char[512];
            int readcount = 0;
            while((readcount = isr.read(buffer)) != -1) {
                osw.write(buffer,0,readcount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                isr.close();
                osw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
	}

}
