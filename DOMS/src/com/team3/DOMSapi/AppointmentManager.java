package com.team3.DOMSapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentManager {
	static int man_id;
	static String name;
	static String birthDate;
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

	
	public AppointmentManager(int manID, String apptMgrName, String apptMgrBirthDate) {
		man_id = manID;
		name = apptMgrName;
		birthDate = apptMgrBirthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public static void setManID(int manID) {
		man_id = manID;
	}
	
	public int getManID() {
		return man_id;
	}
	
	public static void setName(String apptMgrName) {
		name = apptMgrName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public static void setBirthDate(String birthday) {
		birthDate = birthday;
	}
	
	/*
	public boolean isBirthday(Patient patient) {
		final DateFormat dateFormat = new SimpleDateFormat("MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println(currentDate);
		if (patient.birthDate == currentDate) {
			return true;
		}
		else {
			return false;
		}
	}
	*/
	
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
