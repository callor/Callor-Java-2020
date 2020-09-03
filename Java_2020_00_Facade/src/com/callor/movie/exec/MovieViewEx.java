package com.callor.movie.exec;

import com.callor.movie.service.Facade;

public class MovieViewEx {

	public static void main(String[] args) {
        Facade facade = new Facade("콜라","어벤져스");
        facade.view_Movie();
	}
	
}
