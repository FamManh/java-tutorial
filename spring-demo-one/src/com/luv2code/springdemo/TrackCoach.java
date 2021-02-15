package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run ahard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: " + this.fortuneService.getFortune();
	}

	
	// add an init method 
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doStartupStuff ");
	}
	
	
	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff ");
	}
}





















