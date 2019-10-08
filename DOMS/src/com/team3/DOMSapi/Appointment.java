package com.team3.DOMSapi;

public class Appointment {
	int apptID;
	String patientSSN;
	String apptDate;
	String apptTime;
	String notes;
	String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
	String status;

	public Appointment(int ID, String pSSN, String date, String time, String note, String status) {
		apptID = ID;
		patientSSN = pSSN;
		apptDate = date;
		apptTime = time;
		notes = note;
		status = statuses[0];
	}
	
	public String getTime() {
		return apptTime;
	}
	
	public void setTime(String time) {
		this.apptTime = time;
	}
	
	public String getDate() {
		return apptDate;
	}
	
	public void setDate(String date) {
		this.apptDate = date;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setnotes(String note) {
		this.notes += "\n"+note;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String stat) {
		for (int i = 0; i < statuses.length; i++) {
			if (stat.equals(statuses[i])) {
				status = statuses[i];
				break;
			}
		}
	}
}
