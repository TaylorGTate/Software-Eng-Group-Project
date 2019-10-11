package com.team3.DOMSapi;

public class PatientManager {
	
	int id;
	String name, birthDate;
	
	public PatientManager (int id, String name, String birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/*public Boolean isBirthday() {
		return false;
	}*/
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	
}