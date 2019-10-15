package com.team3.DOMSapi;
/**
 * Represents a patient at a doctor's office.
 * A patient can have many appointments.
 */
public class Patient {
	static String name;
	static String birthDate;
	static String ssn;
	static String allergies;
	static String preferredDoctor;
	static String bloodType;
	
	public Patient(String patientName, String birthDay, String social, String allergy, String preferredDoc, String blood) {
		name = patientName;
		birthDate = birthDay;
		ssn = social;
		allergies = allergy;
		preferredDoctor = preferredDoc;
		bloodType = blood;
	}
	/**
	   * Gets the first and last name of this Patient.
	   * @return this Patient's name.
	   */
	public String getName() {
		return name;
	}
	/**
	   * Changes the name of this Patient.
	   * @param patientName This patient's new name.  
	   *                Should include both first
	   *                and last name.
	   */
	public static void setName(String patientName) {
		name = patientName;
	}
	/**
	   * Gets the birthday of this patient.
	   * @return this patient's birthday.
	   */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	   * Changes the birthday of this patient.
	   * @param birthday This patient's birthday.  
	   */
	public static void setBirthDate(String birthday) {
		birthDate = birthday;
	}
	/**
	   * Gets the SSN of this patient.
	   * @return this patient's SSN.
	   */
	public String getSSN() {
		return ssn;
	}
	/**
	   * Changes the SSN of this patient.
	   * @param social This patient's SSN.  
	   */
	public static void setSSN(String social) {
		ssn = social;
	}
	/**
	   * Gets the allergies of this patient.
	   * @return this patient's allergies.
	   */
	public String getAllergies() {
		return allergies;
	}
	/**
	   * Updates the allergies of this patient.
	   * @param allergy This patient's allergies.  
	   */
	public static void updateAllergies(String allergy) {
		allergies += "\n"+allergy;
	}
	/**
	   * Gets the preferred doctor of this patient.
	   * @return this patient's preferred doctor.
	   */
	public String getDoctor() {
		return preferredDoctor;
	}
	/**
	   * Changes the preferred doctor of this patient.
	   * @param docName This patient's preferred doctor.  
	   */
	public static void setDoctor(String docName) {
		preferredDoctor = docName;
	}
	/**
	   * Gets the blood type of this patient.
	   * @return this patient's blood type.
	   */
	public String getBloodType() {
		return bloodType;
	}
	/**
	   * Changes the blood type of this patient.
	   * @param blood This patient's blood type.  
	   */
	public static void setbloodType(String blood) {
		bloodType = blood;
	}
	/**
	   * Patient requests an appointment date and time.
	   * @param date This patient's requested appointment date  
	   * @param time This patient's requested appointment time
	   */
	public void requestAppt(String date, String time) {
		//request appt
	}
}
