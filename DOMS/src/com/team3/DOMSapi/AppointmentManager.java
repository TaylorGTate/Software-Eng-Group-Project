package com.team3.DOMSapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Represents an appointment manager at a doctor's office.
 * A patient manager can approve, deny, or edit appointments requests.
 */
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
	/**
	   * Gets the first and last name of this appointment manager.
	   * @return this appointment manager's name.
	   */
	public String getName() {
		return name;
	}
	/**
	   * Changes the manager ID of this appointment manager.
	   * @param manID This appointment manager's new manager ID.  
	   */
	public static void setManID(int manID) {
		man_id = manID;
	}
	/**
	   * Gets the manager ID of this appointment manager.
	   * @return this appointment manager's ID.
	   */
	public int getManID() {
		return man_id;
	}
	/**
	   * Changes the appointment manager's name.
	   * @param apptMgrName This appointment manager's new name.  
	   */
	public static void setName(String apptMgrName) {
		name = apptMgrName;
	}
	/**
	   * Gets the birthday of this appointment manager.
	   * @return this appointment manager's birthday.
	   */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	   * Changes the appointment manager's birthday.
	   * @param birthday This appointment manager's birthday.  
	   */
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
	/**
	   * Changes the appointment's status to denied.
	   * @param appt Appointment to be denied.  
	   */
	public void denyApptRequest(Appointment appt) {
		//deny appt request method
		//sends notification to patient letting them know the appt has been denied
		//tells patient why it was denied (bad date/time, office closed, etc.)
		appt.status = statuses[2];
	}
	/**
	   * Changes the appointment's status to approved.
	   * @param appt Appointment to be approved.  
	   */
	public void approveApptRequest(Appointment appt) {
		//approve appt request method
		//sends notification to patient letting them know the appt has been approved
		//adds appt to actual appointment calendar
		appt.status = statuses[1];

	}
	/**
	   * Changes the appointment's status to edited.
	   * @param appt Appointment to be edited.  
	   */
	public void editApptRequest(Appointment appt) {
		//edit appt request method
		//sends notification to patient letting them know the appt is still pending and has been edited
		//tells patient what has been changed about their appointment request
		appt.status = statuses[3];

	}
}
