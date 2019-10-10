package com.callor.java9;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.asList(1, 2, 3).stream(); // (1)
		Arrays.asList(1, 2, 3).parallelStream(); // (2)

		// stream�� ��Ҹ� ��ȸ�ؾ� �Ѵٸ� forEach�� Ȱ���� �� �ֽ��ϴ�.
		System.out.println("forEach");
		Arrays.asList(1, 2, 3).stream().forEach(System.out::println); // 1,2,3

		// stream�� ���� ��Ҹ��� ������ �� �� �ֽ��ϴ�.
		// �Ʒ��� �ڵ�� ����Ʈ�� �ִ� ����� ���� ������ �մϴ�.
		System.out.println("map");
		Arrays.asList(1, 2, 3).stream().map(i -> i * i).forEach(System.out::println); // 1,4,9

		// stream�� ���� ��Һ��� ������ �ε��������� ��Ҹ� ������ ���ο� stream�� ����ϴ�.
		System.out.println("limit");
		Arrays.asList(1, 2, 3).stream().limit(1).forEach(System.out::println); // 1

		// stream�� ���� ��ҷκ��� ������ �ε��������� ��Ҹ� �����ϰ� ���ο� stream�� ����ϴ�.
		System.out.println("skip");
		Arrays.asList(1, 2, 3).stream().skip(1).forEach(System.out::println); // 2,3

		// stream�� ��Ҹ��� �񱳸� �ϰ� �񱳹��� �����ϴ� ��ҷθ� ������ stream�� ��ȯ�մϴ�.
		System.out.println("filter");
		Arrays.asList(1, 2, 3).stream().filter(i -> 2 >= i).forEach(System.out::println); // 1,2

		// stream�� ���ο� �ִ� ��ü���� ������ stream�� ��ȯ�մϴ�.
		System.out.println("flatMap");
		Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9)).stream()
				.flatMap(i -> i.stream()).forEach(System.out::println); // 1,2,3,4,5,6,7,8,9

		// stream�� ���� ��ҷ� ��ȯ�մϴ�.
		System.out.println("reduce");
		System.out.println(Arrays.asList(1, 2, 3).stream().reduce((a, b) -> a - b).get()); // -4

		// ���� �޼ҵ�� �ݷ��� ��ü�� ���� ��ȯ�մϴ�.
		System.out.println("Collectors");
		Arrays.asList(1, 2, 3).stream().collect(Collectors.toList());
		Arrays.asList(1, 2, 3).stream().iterator();
	}

}
