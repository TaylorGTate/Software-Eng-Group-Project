package com.team3.DOMSapi;
/**
 * Represents an patient manager at a doctor's office.
 * A patient manager can edit and create patients.
 */
public class PatientManager {
	
	int id;
	String name, birthDate;
	
	public PatientManager (int id, String name, String birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	/**
	   * Gets the manager ID of this patient manager.
	   * @return this patient manager's ID.
	   */
	public int getID() {
		return id;
	}
	/**
	   * Changes the manager ID of this patient manager.
	   * @param id This patient manager's new manager ID.  
	   */
	public void setID(int id) {
		this.id = id;
	}
	/**
	   * Gets the first and last name of this Patient manager.
	   * @return this Patient manager's name.
	   */
	public String getName() {
		return name;
	}
	/**
	   * Changes the name of this Patient manager.
	   * @param name This patient manager's new name.  
	   *                Should include both first
	   *                and last name.
	   */
	public void setName(String name) {
		this.name = name;
	}
	
	/*public Boolean isBirthday() {
		return false;
	}*/
	/**
	   * Changes the patient manager's birthday.
	   * @param birthday This patient manager's birthday.  
	   */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	   * Gets the birthday of this patient manager.
	   * @return this patient manager's birthday.
	   */
	public String getBirthDate() {
		return birthDate;
	}
	
	
}