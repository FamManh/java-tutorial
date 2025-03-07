package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are the same
		boolean result = theCoach == alphaCoach;
		
		// print out the results
		System.out.println(result);
		
		System.out.println("Memmory location for theCoach" + theCoach);
		
		System.out.println("Memmory location for theCoach" + alphaCoach);
		
		// close the context 
		context.close();
	}

}



















