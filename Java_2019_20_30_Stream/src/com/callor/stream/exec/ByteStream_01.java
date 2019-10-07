package com.callor.stream.exec;

import java.io.FileInputStream;
import java.io.IOException;
/*
 * 컴퓨터에 존재하는 모든 데이터는 바이트 단위로 구성되어 있다.
 * 바이트 스트림으로 입출력(네트워크든 파일이든)을 할때는 InputStream과 OutputStream의 자식 클래스다.
 * (InputStream과 OutputStream은 추상클래스로 직접 생성할 수 없다. => 상속 눈여겨 봐야함.)
 * 
 * 예를 들어서 "FileInputStream은 InputStream인데 파일로부터 바이트 단위로 입력 받기 위한 스트림이다." 로 정의할 수 있다.
 * 
 * 
 */
public class ByteStream_01 {

	
	/*
	 * 파일의 내용을 읽어 들여 화면에 출력하는 프로그램이다.
	 * 
	 * FileInputStream은 InputStream을 상속받는다. 바이트 단위로 파일을 읽는다.
	 * 
	 * 약간 논점을 흐릴 수 있는데 이 프로그램의 단점은 자바프로그램에서는 바이트 하나씩 읽어드리고 있지만 
	 * 실제로 운영체제는 512 또는 1024바이트씩 읽어오는 것이다. 
	 * 따라서 실제로는 굉장히 많은 입출력이 일어나고 있어 효율적이지 않다.
	 * 
	 * 이 문제를 해결하기 위해서는 버퍼를 두어 한번에 읽는 것이 적절하다.
	 * 
	 * 이 예제에서 중요하게 볼 내용은 I/O에서 일반적인 코딩룰과 바이트 스트림을 이용한다는 것이다.
	 * 
	 * I/O에서 이용하는 룰은
	 * 1. Stream클래스를 null로 선언하고
	 * 2. try블럭에서 생성하고 사용한 후
	 * 3. finally블럭에서 IO스트림을 닫아주는 것이다.
	 * 
	 * 바이트 스트림을 이용하는 클래스는 ByteArray[Input/Output]Stream, 
	 * Data[Input/Output]Stream, Piped[Input/Output]Stream 등이 있다.
	 * 
	 * 결국 중요한 포인트는 바이트 스트림을 받아준다는 것을 생성자를 보면 알 수 있다는 것이다.
	 * (뒤에 접미사가 Stream으로 되어있으면 보통 바이트 스트림이다.)
	 */
	public static void main(String[] args) {

		String imgFile = "src/com/biz/stream/2019_97886-2080.jpg";
		
//		if(args.length != 1) {
//            System.out.println("사용법 : java FileView 파일명");
//        }
        //항상 null로 먼저 정의하고
        FileInputStream fis = null;
        try {
            //try구문에서 입출력스트림 생성
            fis = new FileInputStream(imgFile);
            int i = 0;
            while((i = fis.read()) != -1) {
                System.out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //finally구문에서 스트림 close하기
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


		
	}

}
