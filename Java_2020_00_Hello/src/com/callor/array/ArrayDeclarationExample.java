package com.callor.array;

import java.io.IOException;
import java.util.Arrays;

public class ArrayDeclarationExample {

	
	  public static void main(String[] args) throws IOException {

	        //How to declare and initialize an array in Java
	        int[] array1 = new int[5];
	        int[] array2 = {1,2,3,4,5};
	        int[] array3 = new int[]{1,2,3,4,5};
	        
	        //Multidimensional array declaration
	        int[][] array4 = new int[2][3];

	        System.out.println("array1 : " + array1);
	        System.out.println("array2 : " + array2);
	        System.out.println("array3 : " + array3);
	        System.out.println("array4 : " + array4);
	        System.out.println("a1 Arrays_toString() : " + Arrays.toString(array1));
	        System.out.println("a2 Arrays_toString(): " + Arrays.toString(array2));
	        System.out.println("a3 Arrays_toString(): " + Arrays.toString(array3));
	        System.out.println("a4 Arrays_toString() 2차원 배열 : " + Arrays.deepToString(array4));
	        
	    }
	
}
