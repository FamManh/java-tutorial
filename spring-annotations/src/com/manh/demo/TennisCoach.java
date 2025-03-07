package com.manh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	
	@Autowired
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		super();
		System.out.println(">> inside default constructor");
	}
	
	// define a setter method
//	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setForturnService() method");
		this.fortuneService = theFortuneService;
	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		super();
//		this.fortuneService = fortuneService;
//	}

	
	@Override
	public String getDailyWorkout() {
		return "Practice your backland volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getFortune();
	}
	
	

}
