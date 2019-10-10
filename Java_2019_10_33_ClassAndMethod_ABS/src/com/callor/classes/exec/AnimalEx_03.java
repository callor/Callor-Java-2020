package com.callor.classes.exec;

import com.biz.classes.service.children.Cat;
import com.biz.classes.service.children.Dog;
import com.biz.classes.service.parents.Animal;

public class AnimalEx_03 {

	public static void main(String[] args) {

		Animal am = new Animal();
		Dog dog1 = new Dog();
		Cat cat1 = new Cat();
		
		// Animal 클래스를 매개변수로 받는 method
		viewName(am); 	// viewName(Animal..)
		
		dog1.setName();
		viewName(dog1); // viewName(Dog..)
		
		cat1.setName();
		viewName(cat1); // viewName(Cat..)
		
	}
	public static void viewName(Animal animal) {
		String name = animal.getName();
		System.out.println(name);
	}
	/*
	public static void viewName(Dog dog) {
		String name = dog.getName();
		System.out.println("Dog");
		System.out.println(name);
	}
	*/
	public static void viewName(Cat cat) {
		String name = cat.getName();
		System.out.println("Cat");
		System.out.println(name);
	}
	

	
}
