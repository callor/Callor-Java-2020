package com.callor.collections.sets;

import java.util.HashSet;
import java.util.Set;

public class SetEx_01 {

	/*
	 * 
	 * Set, 그 중에서도 HashSet
	 * 
	 * List는 순서를 중요시 여기는 자료구조이다
	 * 
	 * Set은 순서를 신경쓰지 않는다
	 * 
	 * 데이터가 들어있나 그렇지 않나만이 중요한 자료형
	 * 
	 * 이런 상황을 가정해보자 어떤 웹 사이트에서 하루에 접속하는 사람들 수를 구하고자 한다 접속하는 IP를 세면 될텐데
	 * 
	 * 근데 한사람이 여러번 접속하면 한 IP가 여러번 찍힐 것이다. 이건 한번으로 카운트 해줘야 제대로 된 접속자 수를 구할 수 있다.
	 * 
	 * 
	 * 이럴때 사용하는 Collection 이 Set 이다 수학에서의 집합과 같은 자료형이다.
	 * 
	 * Set 인터페이스는 3가지 구현체가 있다.
	 * 
	 * HashSet 순서가 필요없는 데이터를 hash table에 저장. Set 중에 가장 성능이 좋음 TreeSet 저장된 데이터의 값에 따라
	 * 정렬됨. red-black tree 타입으로 값이 저장. HashSet보다 성능이 느림 LinkedHashSet 연결된 목록 타입으로
	 * 구현된 hash table에 데이터 저장. 저장된 순서에 따라 값이 정렬. 셋 중 가장 느림
	 * 
	 * 3개의 클래스가 성능 차이가 나는 이유는 데이터 정렬 때문이다. HashSet은 별도의 정렬 작업이 없어 제일 빠르다
	 * 
	 */
	public static void main(String[] args) {

		SetEx_01 ex = new SetEx_01();
		String[] alphabet = new String[] { "A", "B", "A", "D", "C", "E", "F", "G", "E", "T", "M", "O" };
		System.out.println(ex.getAlphabetKinds(alphabet));
//        A B C D T E F G M O
//        10
		System.out.println(ex.getAlphabetKinds2(alphabet));
//        A B C D T E F G M O
//        10

	}

	public int getAlphabetKinds(String[] alphabet) {
		if (alphabet == null)
			return 0;
		if (alphabet.length == 1)
			return 1;

		HashSet<String> alphabetSet = new HashSet<>();

		for (String spell : alphabet) {
			alphabetSet.add(spell);
		}

		for (String item : alphabetSet) {
			System.out.print(item + " ");
		}
		System.out.println();

		return alphabetSet.size();
	}

	public int getAlphabetKinds2(String[] alphabet) {
		if (alphabet == null)
			return 0;
		if (alphabet.length == 1)
			return 1;

		Set<String> alphabetSet2 = new HashSet<>();

		for (String spell : alphabet) {
			alphabetSet2.add(spell);
		}

		for (String item : alphabetSet2) {
			System.out.print(item + " ");
		}
		System.out.println();

		return alphabetSet2.size();
	}

}
