package com.team3.DOMSapi;
/**
 * Represents an doctor manager at a doctor's office.
 * A doctor manager can create and edit doctors.
 */
public class DoctorManager {
	static int manager_id;
	static String name;
	static String birthDate;

	
	public DoctorManager(int managerID, String docName, String birth_date) {
		manager_id = managerID;
		name = docName;
		birthDate = birth_date;
	}
	/**
	   * Gets the first and last name of this doctor manager.
	   * @return this doctor manager's name.
	   */
	public String getName() {
		return name;
	}
	/**
	   * Changes the name of this doctor manager.
	   * @param Name This doctor manager's new name.  
	   *                Should include both first
	   *                and last name.
	   */
	public static void setName(String Name) {
		name = Name;
	}
	/**
	   * Gets the birthday of this doctor manager.
	   * @return this doctor manager's birthday.
	   */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	   * Changes the doctor manager's birthday.
	   * @param birthday This doctor manager's birthday.  
	   */
	public static void setBirthDate(String birthday) {
		birthDate = birthday;
	}
	/**
	   * Gets the manager ID of this doctor manager.
	   * @return this doctor manager's ID.
	   */
	public int getID() {
		return manager_id;
	}
	/**
	   * Changes the manager ID of this doctor manager.
	   * @param managerID This doctor manager's new manager ID.  
	   */
	public static void setID(int managerID) {
		manager_id = managerID;
	}
}
