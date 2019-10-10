package com.team3.DOMSapi;

public class Doctor {
	static String name;
	static String birthDate;
	static String ssn;

	
	public Doctor(String doctorName, String birthDay, String social) {
		name = doctorName;
		birthDate = birthDay;
		ssn = social;
	}
	
	public String getName() {
		return name;
	}
	
	public static void setName(String doctorName) {
		name = doctorName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public static void setBirthDate(String birthday) {
		birthDate = birthday;
	}
	
	public String getSSN() {
		return ssn;
	}
	
	public static void setSSN(String social) {
		ssn = social;
	}
}