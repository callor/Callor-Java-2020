package com.callor.classes.exec;

public class ClassEx_03 {

	public static void main(String[] args) {

		int num1 = 30;
		int num2 = 40;
		
		// num1에 저장된 값과 num2에 
		// 저장된 값을 서로 바꾸고 싶다
		int _temp = num1;
		num1 = num2;
		num2 = _temp;
		
		/*
		 * 두개의 숫자 변수에 담긴 값을
		 * 서로 교환하는 method를 만들겠다
		 * 그리고 method가 실행된 후
		 * 교환된 값을 다시 가져오는 방법 찾기
		 */
		swap(num1, num2);
		
		int[] nums = new int[2];

		nums[0] = 40;
		nums[1] = 50;
		
		System.out.printf("nums[0] : %d, nums[1] : %d\n",
				nums[0],nums[1]);
		swap(nums);
		System.out.printf("nums[0] : %d, nums[1] : %d\n",
				nums[0],nums[1]);
	}
	
	public static void swap(int num1, int num2) {
		int _temp = num1;
		num1 = num2;
		num2 = _temp;
	}

	public static void swap(int[] nums) {
		int _temp = nums[0];
		nums[0] = nums[1];
		nums[1] = _temp;
	}

	
}
