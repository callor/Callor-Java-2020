package com.callor.collections.queues;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * 
 * Queue
 * 먼저 들어간게 먼저 나온다!
 * 
 * 한줄로 ATM을 사용하는 상황으로 보면 된다.
 * 
 * 먼저 온 사람이 먼저 ATM을 사용하고 나오는 형식이다.
 * 
 * IT에서 FIFO의 상황을 찾자면…
 */

public class QueueEx_01 {
	public static void main(String[] ar){
		QueueEx_01 ex = new QueueEx_01();
        ex.checkLinkedList();
    }

    public void checkLinkedList(){
        
    	
    	LinkedList<String> ll = new LinkedList<>();
        ll.add("Teemo");
        System.out.println(ll);
//        [Teemo]
        ll.add("Jinx");
        System.out.println(ll);
//        [Teemo, Jinx]
        ll.addFirst("Zed"); // LinkedList
        System.out.println(ll);
//        [Zed, Teemo, Jinx]
        ll.add(1, "Rengar");
        System.out.println(ll);
//        [Zed, Rengar, Teemo, Jinx]
        System.out.println(ll.set(0, "Gnar") + " is changed to Gnar");
//        Zed is changed to Gnar
        System.out.println(ll);
//        [Gnar, Rengar, Teemo, Jinx]
        System.out.println("ll.getFirst() = " + ll.getFirst());
//        ll.getFirst() = Gnar
        System.out.println("ll.indexOf(\"Teemo\") = " + ll.indexOf("Teemo"));
//        ll.indexOf("Teemo") = 2
        System.out.println("ll.removeFirst() = " + ll.removeFirst());
//        ll.removeFirst() = Gnar
        System.out.println(ll);
//        [Rengar, Teemo, Jinx]

        System.out.println();
        
        
//        Iterator는 다음 데이터만을 검색할 수 있었다
//        ListIterator는 이 단점을 보완해 이전 메소드도 검색가능한 인터페이스 이다.
        ListIterator<String> li = ll.listIterator();
        if(li.hasNext()){
            System.out.println("li.next() = " + li.next());
        }
//        li.next() = Rengar
        System.out.println("li.next() = " + li.next());
//        li.next() = Teemo
        System.out.println("li.previous() = " + li.previous());
//        li.previous() = Teemo
        System.out.println("li.previous() = " + li.previous());
//        li.previous() = Rengar
    }

	
}
