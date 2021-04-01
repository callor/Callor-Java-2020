package com.callor.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FunctionEx {
	
	public static void main(String[] args) {
		
		
		List<Coffee> coffee = new ArrayList<Coffee>();
		
		coffee.add(new Coffee("아메리카노",4000,"어름"));
		coffee.add(new Coffee("카페라떼",4500,"우유"));
		coffee.add(new Coffee("에스프레소",3000,""));
		coffee.add(new Coffee("카푸치노",6000,"계피"));
		coffee.add(new Coffee("카페모카",5000,"초코"));
		
		Optional<Coffee> coff = coffee.stream()
				.filter(Coffee::isOption)
				.findAny();
//				.findFirst();
		
		coff.stream().forEach(System.out::println);
		System.out.println(coff);
		
	}
	

}
class Coffee {
	public Coffee(String coffee, int price, String option) {
		this.coffee = coffee;
		this.price = price;
		this.option = option;
	}
	String coffee;
	int price;
	String option;
	
	public String getCoffee() {
		return this.coffee;
	}
	
	public boolean isOption(){
		System.out.println("isOption " + this.option);
		return this.option.equals("초코");
	}

	@Override
	public String toString() {
		return "Coffee [coffee=" + coffee + ", price=" + price + ", option=" + option + "]";
	}
	
	
}

