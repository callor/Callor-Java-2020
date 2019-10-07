package com.callor.stream.exec;

import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.callor.stream.domain.BookVO;

/*
 * 객체 스트림 
 * 객체 스트림은 우리가 어떤 객체 그대로 통신하고 싶을 때 사용하는 방법이다.
 * 
 * 객체를 통신할 때는 요구 조건이 있다. 바로 객체가 직렬화가 가능해야 한다.
 * 객체를 직렬화하는 방법은 Serializable 인터페이스를 implements 하는 방법으로 가능하다.
 * Serializable 인터페이스는 오버라이드하는 메소드가 없는 마크 인터페이스로 그냥 implements하면 된다.
 * 
 * - 마샬링 : 데이터를 바이트스트림으로 만들어 TCP와 같은 통신 채널을 통해 전송하거나 
 * 스트림으로 써줄 수 있는 형태로 바꾸는 과정
 * 
 * 마샬링 될 수 있는 데이터는 기본자료형(boolean, byte, char, short, int, long, float, double)과 
 * Serializable 인터페이스를 구현하고 있는 객체만 가능하다.
 * 
 * - 언마샬링 : 마샬링과 반대로 전송받은 데이터를 원래의 형태로 변환하는 과정을 뜻한다.
 */

public class ObjectStreamBook {

	/*
	 * 객체통신에서는 writeObject()를 할 때 하나의 객체만을 보낼 수 있다. 
	 * 따라서 여러 Book을 보낼 때 ArrayList를 사용해서 list 객체에 묶어서 보냈다.
	 * 
	 * 만약 파일이 아닌 네트워크에 보냈다면 수신자도 똑같이 Book클래스가 어떻게 구성되어있는지 알아야 파싱이 가능하다.
	 * 
	 * (JSON이 왜 좋은지 알 것 같다.)
	 * 
	 * 미리 서두에 말을 안했는데 객체스트림의 기본 클래스는 ObjectInputStream과 ObjectOutputStream이다.
	 */
	public static void main(String[] args) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        ArrayList<BookVO> list = new ArrayList<>();
        BookVO b1 = new BookVO("a0001","자바완성","정프로",10000);
        BookVO b2 = new BookVO("a0002","IO완성","정아마추어",20000);
        BookVO b3 = new BookVO("a0003","NIO완성","정코딩",30000);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        
        try {
            fout = new FileOutputStream("src/com/biz/stream/booklist.dat");
            oos = new ObjectOutputStream(fout);
            
            oos.writeObject(list);
            oos.reset();
            System.out.println("저장완료");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                fout.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


	
}
