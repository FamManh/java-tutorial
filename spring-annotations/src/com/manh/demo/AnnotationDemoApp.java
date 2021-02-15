package com.manh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();

				
	
	}

}
