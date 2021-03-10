package com.callor.exec.sort;

import java.util.Arrays;
import java.util.Comparator;


public class NumberSort {

	/*
	 * 함수 solution은 정수 n을 매개변수로 입력받습니다. 
	 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
	 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
	 */
	public static void main(String[] args) {
		
		Solution so = new Solution();
		long result = so.solution(392919391L);
		System.out.println(result);
		
	}
	
}

class Solution {
    public long solution(long n) {
        
        char[] chars = String.valueOf(n).toCharArray();
        
         for(int i=0;i<(chars.length-1);i++)
        {
            for(int j=i+1;j>0;j--)
            {
                if(chars[j]>chars[j-1])
                {
                    char Temp = chars[j-1];
                    chars[j-1] = chars[j];
                    chars[j] = Temp;
                }
            }
        }
        String sortedString = new String(chars);
        long answer = Long.parseLong(sortedString);
        return answer;
    }
}

class SolutionS {
    public long solution(long n) {
        
    	
    	String str = String.valueOf(n);
        char[] charArray = str.toCharArray();

        Character[] myCharArr = ArrayUtils.toObject(charArray);

        Arrays.sort(myCharArr, new Comparator<Character>() {

            @Override
            public int compare(Character char1, Character char2) {
                return char2.compareTo(char1);
            }
        });
        String sortString = new String(myCharArr);
        long answer = Long.parseLong(sortString);
        return answer;
    }
}

