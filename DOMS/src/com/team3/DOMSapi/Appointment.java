package com.team3.DOMSapi;

public class Appointment {
	static int apptID;
	static String patientSSN;
	static String apptDate;
	static String apptTime;
	static String notes;
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
	static String status;

	public Appointment(int ID, String pSSN, String date, String time, String note, String stat) {
		apptID = ID;
		patientSSN = pSSN;
		apptDate = date;
		apptTime = time;
		notes = note;
		status = stat;
	}
	
	public int getApptID() {
		return apptID;
	}
	
	public static void setApptID(int id) {
		apptID = id;
	}
	
	public String getSSN() {
		return patientSSN;
	}
	
	public static void setSSN(String social) {
		patientSSN = social;
	}
	
	public String getTime() {
		return apptTime;
	}
	
	public static void setTime(String time) {
		apptTime = time;
	}
	
	public String getDate() {
		return apptDate;
	}
	
	public static void setDate(String date) {
		apptDate = date;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public static void setNotes(String note) {
		notes = note;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static void setStatus(String stat) {
		for (int i = 0; i < statuses.length; i++) {
			if (stat.equals(statuses[i])) {
				status = statuses[i];
				break;
			}
		}
	}
}
