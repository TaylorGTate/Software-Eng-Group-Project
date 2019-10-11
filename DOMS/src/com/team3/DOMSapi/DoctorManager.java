package com.team3.DOMSapi;

public class DoctorManager {
	static int manager_id;
	static String name;
	static String birthDate;

	
	public DoctorManager(int managerID, String docName, String birth_date) {
		manager_id = managerID;
		name = docName;
		birthDate = birth_date;
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
	
	public int getID() {
		return manager_id;
	}
	
	public static void setID(int managerID) {
		manager_id = managerID;
	}
}
