package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Represents a Doctor working at a doctor's office.
 * A Doctor can be assigned to many appointments.
 */
public class Doctor {
	static int docID;
	static String name;
	static String birthDate;
	static String ssn;

	
	public Doctor(int doc_id, String doctorName, String birthDay, String social) {
		docID = doc_id;
		name = doctorName;
		birthDate = birthDay;
		ssn = social;
	}
	/**
	   * Gets the first and last name of this Doctor.
	   * @return this Doctor's name.
	   */
	public String getName() {
		return name;
	}
	 /**
	   * Changes the name of this Doctor.
	   * @param doctorName This Doctor's new name.  
	   *                Should include both first
	   *                and last name.
	   */
	public void setName(String doctorName) {
		name = doctorName;
	}
	/**
	   * Gets the birthday of this Doctor.
	   * @return this Doctor's birthday
	   */
	public String getBirthDate() {
		return birthDate;
	}
	 /**
	   * Changes the birthday of this Doctor.
	   * @param birthday This Doctor's birthday.  
	   */
	public void setBirthDate(String birthday) {
		birthDate = birthday;
	}
	/**
	   * Gets the unique SSN of this Doctor.
	   * @return this Doctor's SSN.
	   */
	public String getSSN() {
		return ssn;
	}
	 /**
	   * Changes the SSN of this Doctor.
	   * @param social This Doctor's SSN.  
	   */
	public void setSSN(String social) {
		ssn = social;
	}
	
	public int getDocID() {
		return docID;
	}
	
	public void setDocID(int doc_ID) {
		docID = doc_ID;
	}
	
	public Patient editUserProfile(Patient currentPatient, Scanner input) {
		Patient updatedPatient = null;
		
		updatedPatient = currentPatient.editProfile(input);
		
		return updatedPatient;
	}
	
	public Appointment editApptNotes(Appointment currentAppt, Scanner input) {
		int apptID = currentAppt.getApptID();
		String apptDate = currentAppt.getDate();
		String apptTime = currentAppt.getTime();
		String apptNotes = currentAppt.getNotes();
		String apptStatus = currentAppt.getStatus();
		Appointment updatedAppt = null;
		
        System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes+ "\n\t4. Appt Status: " + apptStatus);

		System.out.println("Current Appt Notes: " + apptNotes);
		System.out.println("What would you like to change the notes to?");
		input.nextLine();
		apptNotes = input.nextLine();
		currentAppt.setNotes(apptNotes);
		
		updatedAppt = currentAppt;
		
		return updatedAppt;
	}
}