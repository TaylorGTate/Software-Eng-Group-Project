package com.team3.DOMSapi;

public class DoctorManager {
	static Integer manager_id;
	static String name;
	static String birthDate;

	
	public DoctorManager(Integer manager_id, String name, String birth_date) {
		manager_id = manager_id;
		name = name;
		birthDate = birthDate;
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
	
	public Integer getID() {
		return manager_id;
	}
	
	public static void setID(Integer manager_id) {
		manager_id = manager_id;
	}
}
