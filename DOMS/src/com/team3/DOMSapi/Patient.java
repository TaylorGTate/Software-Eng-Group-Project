package com.team3.DOMSapi;

public class Patient {
	static String name;
	static String birthDate;
	static String ssn;
	static String allergies;
	static String preferredDoctor;
	static String bloodType;
	
	public Patient(String patientName, String birthDay, String social, String allergy, String preferredDoc, String blood) {
		name = patientName;
		birthDate = birthDay;
		ssn = social;
		allergies = allergy;
		preferredDoctor = preferredDoc;
		bloodType = blood;
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
	
	public String getAllergies() {
		return allergies;
	}
	
	public static void updateAllergies(String allergy) {
		allergies += "\n"+allergy;
	}
	
	public String getDoctor() {
		return preferredDoctor;
	}
	
	public static void setDoctor(String docName) {
		preferredDoctor = docName;
	}
	
	public String getBloodType() {
		return bloodType;
	}
	
	public static void setbloodType(String blood) {
		bloodType = blood;
	}
	
	public void requestAppt(String date, String time) {
		//request appt
	}
}
