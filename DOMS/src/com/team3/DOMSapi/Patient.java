package com.team3.DOMSapi;

import java.sql.Time;
import java.sql.Date;

public class Patient {
	String patientName;
	Date birthDate;
	String ssn;
	String allergies;
	String preferredDoctor;
	
	public Patient(String name, Date birthDay, String social, String allergy, String preferredDoc) {
		patientName = name;
		birthDate = birthDay;
		ssn = social;
		allergies = allergy;
		preferredDoctor = preferredDoc;
	}
	
	public String getName() {
		return patientName;
	}
	
	public void setName(String name) {
		this.patientName = name;
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
