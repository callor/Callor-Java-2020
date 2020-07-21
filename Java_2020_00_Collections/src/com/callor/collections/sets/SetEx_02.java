package com.callor.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx_02 {

	public static void main(String[] ar){
        String[] alphabet = new String[]{
                "A", "B", "A", "D", "C", "E", "F", "G", "E",
                "T", "M", "O"
        };
        SetEx_02 ex = new SetEx_02();
        ex.printHashSet(alphabet);
    }

    public void printHashSet(String[] str){
    	
    	
        Set<String> alpha = new HashSet<>();
        for(String item: str){
            alpha.add(item);
        }

        Iterator<String> iter = alpha.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
//        A B C D T E F G M O
        System.out.println();
        System.out.println();

        if(alpha.contains("Z")){
            System.out.println("alpha set contains \"Z\"");
        }else{
            System.out.println("alpha set does not contain \"Z\"");
        }
//        alpha set does not contain "Z"
        Iterator<String> iter2 = alpha.iterator();
        while(iter2.hasNext()){
            System.out.print(iter2.next() + " ");
        }
//        A B C D T E F G M O
        System.out.println();
        System.out.println();

        if(alpha.contains("A")){
            alpha.remove("A");
            System.out.println("\"A\" is removed from set alpha");
        }else{
            System.out.println("alpha set does not contains \"A\"");
        }
//        "A" is removed from set alpha
        Iterator<String> iter3 = alpha.iterator();
        while(iter3.hasNext()){
            System.out.print(iter3.next() + " ");
        }
//        B C D T E F G M O
    }
}
