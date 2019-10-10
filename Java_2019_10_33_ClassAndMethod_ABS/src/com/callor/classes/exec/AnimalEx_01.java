package com.callor.classes.exec;

import com.biz.classes.service.children.Cat;
import com.biz.classes.service.children.Dog;
import com.biz.classes.service.parents.Animal;

public class AnimalEx_01 {

	public static void main(String[] args) {

		Animal am = new Animal();
		String name = am.getName();
		System.out.println(name);
		
		Dog dog1 = new Dog();
		name = dog1.getName();
		System.out.println(name);
		
		dog1.setName();
		name = dog1.getName();
		System.out.println(name);
		
		Cat cat1 = new Cat();
		name = cat1.getName();
		System.out.println(name);
		
		cat1.setName();
		name = cat1.getName();
		System.out.println(name);
		
	}
}
