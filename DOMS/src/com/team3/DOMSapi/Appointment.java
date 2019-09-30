package com.team3.DOMSapi;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	Date date;
	Time time;

	public Appointment(Date apptDate, Time apptTime) {
		date = apptDate;
		time = apptTime;
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
		//test
	}
}
