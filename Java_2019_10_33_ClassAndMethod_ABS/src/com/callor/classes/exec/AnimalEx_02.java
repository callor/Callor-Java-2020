package com.callor.classes.exec;

import com.biz.classes.service.children.Cat;
import com.biz.classes.service.children.Dog;
import com.biz.classes.service.parents.Animal;

public class AnimalEx_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 부모 클래스로 선언을 하고
		// child 클래스로 초기화 생성을 하는 방식
		Animal dog1 = new Dog();
		Animal cat1 = new Cat();

		// dog1의 이름을 setName() method를 호출해서
		// 몽이 로 변경하고 싶다.
		// Animal에는 없고, Dog에는 있는  
		// setName() method를 호출하려면

		((Dog)dog1).setName();
		viewName(dog1);
		
		((Cat)cat1).setName();
		viewName(cat1);

	}
	
	public static void viewName(Animal animal) {
		String name = animal.getName();
		System.out.println(name);
	}

}
