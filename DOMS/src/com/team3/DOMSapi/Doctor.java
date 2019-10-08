package com.team3.DOMSapi;

public class Doctor {
	static String name;
	static String birthDate;
	static String ssn;

	
	public Doctor(String patientName, String birthDay, String social) {
		name = patientName;
		birthDate = birthDay;
		ssn = social;
	}
	
	public String getName() {
		return name;
	}
	
	public static void setName(String patientName) {
		name = patientName;
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