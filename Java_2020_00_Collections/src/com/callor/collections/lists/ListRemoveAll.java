package com.callor.collections.lists;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveAll {
	
	public static void main(String[] args) {
		// movies에서 marvel에 해당하는 항목을 모두 삭제
		// removeAll()을 이용하여 movies 리스트에서 marvel 리스트의 항목들을 제거한다

		List<String>  marvel = new ArrayList<>();
		marvel.add("Iron man");
		marvel.add("Hulk");
		marvel.add("Captain america");
		System.out.println("marvel: " + marvel.toString());

		List<String>  movies = new ArrayList<>();
		movies.add("Untouchable");
		movies.add("Spiderman");
		movies.add("Captain america");
		movies.add("Hulk");
		System.out.println("movies: " + movies.toString());

		movies.removeAll(marvel);
		System.out.println("movies - removeAll(marvel): " + movies.toString());
	}
	

}
