package com.team3.DOMSapi;
/**
 * Represents a Doctor working at a doctor's office.
 * A Doctor can be assigned to many appointments.
 */
public class Doctor {
	static String name;
	static String birthDate;
	static String ssn;

	
	public Doctor(String doctorName, String birthDay, String social) {
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
	public static void setName(String doctorName) {
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
	public static void setBirthDate(String birthday) {
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
	public static void setSSN(String social) {
		ssn = social;
	}
}