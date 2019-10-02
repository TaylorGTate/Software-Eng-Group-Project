package com.team3.DOMSapi;

import java.sql.Time;
import java.sql.Date;

public class Patient {
	String name;
	Date birthDate;
	String ssn;
	String allergies;
	String preferredDoctor;
	String bloodType;
	
	public Patient(String patientName, Date birthDay, String social, String allergy, String preferredDoc, String blood) {
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
	
	public void setName(String patientName) {
		this.name = patientName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthday) {
		this.birthDate = birthday;
	}
	
	public String getSSN() {
		return ssn;
	}
	
	public void setSSN(String social) {
		this.ssn = social;
	}
	
	public String getAllergies() {
		return allergies;
	}
	
	public void updateAllergies(String allergy) {
		this.allergies += "\n"+allergy;
	}
	
	public String getDoctor() {
		return preferredDoctor;
	}
	
	public void setDoctor(String docName) {
		this.preferredDoctor = docName;
	}
	
	public String getBloodType() {
		return bloodType;
	}
	
	public void setbloodType(String blood) {
		this.bloodType = blood;
	}
	
	public void requestAppt(Date date, Time time) {
		//request appt
	}
}
