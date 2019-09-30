package com.team3.DOMSapi;

import java.sql.Time;
import java.sql.Date;

public class Patient {
	String name;
	Date birthDate;
	String ssn;
	String allergies;
	String preferredDoctor;
	
	public Patient(String patientName, Date birthDay, String social, String allergy, String preferredDoc) {
		name = patientName;
		birthDate = birthDay;
		ssn = social;
		allergies = allergy;
		preferredDoctor = preferredDoc;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String patientName) {
		this.name = patientName;
	}
	
	public String getSSN() {
		return ssn;
	}
	
	public void setSSN(String social) {
		this.ssn = social;
	}
	
	public void requestAppt(Date date, Time time) {
		//request appt
	}
}
