package com.team3.DOMSapi;

import java.sql.Date;

public class AppointmentManager {
	String name;
	Date birthDate;
	String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

	
	public AppointmentManager(String apptMgrName, Date apptMgrBirthDate) {
		name = apptMgrName;
		birthDate = apptMgrBirthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String apptMgrName) {
		this.name = apptMgrName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthday) {
		this.birthDate = birthday;
	}
	
	public boolean isBirthday(Patient patient) {
		//if patient.birthDate == today 
		return true;
		//else
		//return false;
	}
	
	public void denyApptRequest(Appointment appt) {
		//deny appt request method
		//sends notification to patient letting them know the appt has been denied
		//tells patient why it was denied (bad date/time, office closed, etc.)
		appt.status = statuses[2];
	}
	
	public void approveApptRequest(Appointment appt) {
		//approve appt request method
		//sends notification to patient letting them know the appt has been approved
		//adds appt to actual appointment calendar
		appt.status = statuses[1];

	}
	
	public void editApptRequest(Appointment appt) {
		//edit appt request method
		//sends notification to patient letting them know the appt is still pending and has been edited
		//tells patient what has been changed about their appointment request
		appt.status = statuses[3];

	}
}
