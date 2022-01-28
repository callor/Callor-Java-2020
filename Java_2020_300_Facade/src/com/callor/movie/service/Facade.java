package com.callor.movie.service;

public class Facade {

	private String beverage_Name = "";
	private String Movie_Name = "";

	public Facade(String beverage, String Movie_Name) {
		this.beverage_Name = beverage;
		this.Movie_Name = Movie_Name;
	}

	public void view_Movie() {
		Beverage beverage = new Beverage(beverage_Name);
		RemoteControl remote = new RemoteControl();
		Movie movie = new Movie(Movie_Name);

		beverage.Prepare();
		remote.turn_On();
		movie.Search_Movie();
		movie.Charge_Movie();
		movie.play_Movie();
		remote.turn_Off();
	}

}
