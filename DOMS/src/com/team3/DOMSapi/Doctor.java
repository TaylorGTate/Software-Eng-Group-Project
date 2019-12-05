package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Represents a Doctor working at a doctor's office.
 * A Doctor can be assigned to many appointments.
 */
public class Doctor {
	int docID;
	String name;
	String birthDate;
	String ssn;
	
	public Doctor(int doc_id, String doctorName, String birthDay, String social) {
		docID = doc_id;
		name = doctorName;
		birthDate = birthDay;
		ssn = social;
	}
	
	//empty constructor
	public Doctor() {
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
	
	/**
	   * Allows the doctor to edit the user profile
	   * @param input Scanner object 
	   * @param currentPatient Patient object of the patient to be edited  
	   * @return updatedPatient Patient object that contains the new details that were supplied by the doctor
	   */ 
	public Patient editUserProfile(Patient currentPatient, Scanner input) {
		Patient updatedPatient = new Patient();
		
		updatedPatient = currentPatient.editProfile(input);
		
		return updatedPatient;
	}
	
	/**
	   * Allows the doctor to edit the notes of their user's appt
	   * @param input Scanner object 
	   * @param currentAppt Appointment object of the appt to be edited  
	   * @return updatedAppt Appointment object that contains the new details that were supplied by the doctor
	   */ 
	public Appointment editApptNotes(Appointment currentAppt, Scanner input) {
		int apptID = currentAppt.getApptID();
		String apptDate = currentAppt.getDate();
		String apptTime = currentAppt.getTime();
		String apptNotes = currentAppt.getNotes();
		String apptStatus = currentAppt.getStatus();
		Appointment updatedAppt = new Appointment();
		
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