package com.team3.DOMSapi;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	Date apptDate;
	Time apptTime;
	String notes;
	String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
	String status;

	public Appointment(Date date, Time time, String note) {
		apptDate = date;
		apptTime = time;
		notes += "\n"+note;
		status = statuses[0];
	}
	
	public Time getTime() {
		return apptTime;
	}
	
	public void setTime(Time time) {
		this.apptTime = time;
	}
	
	public Date getDate() {
		return apptDate;
	}
	
	public void setDate(Date date) {
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
