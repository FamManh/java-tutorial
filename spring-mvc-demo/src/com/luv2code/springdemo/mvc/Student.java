package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	String firstName;
	String lastName;
	String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("VietNam","VietNam");
		countryOptions.put("Russia","Russia");
		countryOptions.put("Germani","Germani");
		countryOptions.put("Italya","Italya");
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
