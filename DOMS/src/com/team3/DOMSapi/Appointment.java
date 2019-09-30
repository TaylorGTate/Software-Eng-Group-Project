package com.team3.DOMSapi;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	Date date;
	Time time;
	String notes;
	String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
	String status;

	public Appointment(Date apptDate, Time apptTime, String note) {
		date = apptDate;
		time = apptTime;
		notes += "\n"+note;
		status = statuses[0];
	}
	
	public Time getTime() {
		return time;
	}
	
	public void setTime(Time apptTime) {
		this.time = apptTime;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date apptDate) {
		this.date = apptDate;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setnotes(String note) {
		this.notes += "\n"+note;
	}
}
