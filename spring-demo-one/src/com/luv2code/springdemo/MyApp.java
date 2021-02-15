package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create the object
		FortuneService fortuneService = new HappyFortuneService();
		Coach theCoach = new BaseballCoach(fortuneService);
		// use the object
		System.out.println(theCoach.getDailyFortune());
	}
}
