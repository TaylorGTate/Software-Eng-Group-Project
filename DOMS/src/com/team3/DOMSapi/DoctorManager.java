package com.team3.DOMSapi;

import java.util.Scanner;

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
	
	//empty constructor
	public DoctorManager() {
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
	public static void setName(String doctorName) {
		name = doctorName;
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
	
	/**
	   * Patient requests an appointment.
	   * @param Scanner input  
	   * @param numOfDoctors Integer that contains the current number of doctors
	   * @return newDoctor Doctor object that contains the new doctor information
	   */
	public Doctor createDoctor(int numOfDoctors, Scanner input) {
		int newID = numOfDoctors+1;

	    System.out.println("Please enter the doctor's name:");
	    input.nextLine();
	    String doctorName = input.nextLine();	    
        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
	    String doctorBirthDate = input.nextLine();	
        System.out.println("Please enter SSN:");
	    String doctorSSN = input.nextLine();	

		Doctor newDoctor = new Doctor(newID, doctorName, doctorBirthDate, doctorSSN);
		return newDoctor;
	}
	
	/**
	   * Allows the doctor manager to edit the details of the doctor profile
	   * @param input Scanner object  
	   * @return updatedPatient Patient object that contains the new details that were supplied by the user
	   */ 
	public Doctor editProfile(Doctor currentDoctor, Scanner input) {
		int docID = currentDoctor.getDocID();
		String docName = currentDoctor.getName();
		String docBirthDate = currentDoctor.getBirthDate();
		String docSSN = currentDoctor.getSSN();
		
		Doctor updatedDoctor = currentDoctor;
		updatedDoctor.setDocID(docID);
		
		System.out.println("\t1. Name: " + docName + "\n\t2. Birthday: " + docBirthDate + "\n\t3. SSN: " + docSSN);
		System.out.println("What would you like to edit? (input an integer to select)");
	    int selectedInput = input.nextInt();
	      
	    try {
	    	switch(selectedInput) {
	  	    	case 1://name
	  	    		System.out.println("Current Name: " + docName);
	  	    		System.out.println("What would you like to change it to?");
	  	    		input.nextLine();
	  	    		docName = input.nextLine();
	  	    		updatedDoctor.setName(docName);
	  	    		break;
	  	      	case 2://birthday
	  	      		System.out.println("Current Birthday: " + docBirthDate);
	  	      		System.out.println("What date would you like to change it to?");
	  	      		input.nextLine();
	  	      		docBirthDate = input.nextLine();
	  	      		updatedDoctor.setBirthDate(docBirthDate);
	  	      		break;
	  	      	case 3://ssn
	  	      		System.out.println("Current SSN: " + docSSN);
	  	      		System.out.println("What would you like to change it to?");
	  	      		input.nextLine();
	  	      		docSSN = input.nextLine();
	  	      		updatedDoctor.setSSN(docSSN);
	  	      		break;
	  	      	default:
	  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
		
		return updatedDoctor;
	}
	
	public Appointment assignDoctorToAppt(Appointment currentAppt, Doctor currentDoctor, Scanner input) {
		int apptID = currentAppt.getApptID();
		String apptDate = currentAppt.getDate();
		String apptTime = currentAppt.getTime();
		String apptNotes = currentAppt.getNotes();
		String preferredDoc = currentAppt.getPreferredDoc();
		Appointment updatedAppt = currentAppt;
		Doctor currentDoc = currentDoctor;
		
		try {
            System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes+ "\n\t4. Preferred Doctor: " + preferredDoc);
      		preferredDoc = currentDoc.getName();
      		System.out.println("The new preferred doctor is: " + preferredDoc);
            updatedAppt.setPreferredDoc(preferredDoc);

		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return updatedAppt;
	}
}
