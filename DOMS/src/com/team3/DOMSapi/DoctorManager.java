package com.team3.DOMSapi;

import java.util.Scanner;

/**
 * Represents an doctor manager at a doctor's office.
 * A doctor manager can create and edit doctors.
 */
public class DoctorManager {
	int manager_id;
	String name;
	String birthDate;

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
	public void setName(String doctorName) {
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
	public void setBirthDate(String birthday) {
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
	public void setID(int managerID) {

		manager_id = managerID;
	}
	
	/**
	   * Patient requests an appointment.
	   * @param numOfDoctors Integer that contains the current number of doctors
	   * @return newDoctor Doctor object that contains the new doctor information
	   */
	public Doctor createDoctor(int numOfDoctors) {
		Scanner input = new Scanner(System.in);
		int newID = numOfDoctors+1;

	    System.out.println("Please enter the doctor's name:");
  		String doctorName = input.nextLine();
  		while (!doctorName.matches("([a-zA-Z.\\s]+)")) {
  			System.out.println("\n** Incorrect input. Please try again. **");
	    		System.out.println("Please enter new doctor name: ");
	    		doctorName = input.nextLine();
  		}	   
	    
    	System.out.println("Please enter birthday: (in the form YYYY-MM-DD)");
	    String doctorBirthDate = input.nextLine();	
        //add error checking for making sure dates are current
        while (!doctorBirthDate.matches("(\\d{4}-\\d{2}-\\d{2})")) {
        	System.out.println("\n** Incorrect input. Please try again. **");
      		System.out.println("Please enter birthday: (in the form YYYY-MM-DD)");
      		doctorBirthDate = input.nextLine();
        }
        
    	System.out.println("Please enter SSN: (in the following format '###-##-####')");
	    String doctorSSN = input.nextLine();	
	    while (!doctorSSN.matches("(\\d{3}-\\d{2}-\\d{4})")){
        	System.out.println("\n** Incorrect input. Please try again. **");
	    	System.out.println("Please enter SSN: (in the following format '###-##-####')");
	    	doctorSSN = input.next();
	    }

		Doctor newDoctor = new Doctor(newID, doctorName, doctorBirthDate, doctorSSN);
		return newDoctor;
	}
	
	/**
	   * Allows the doctor manager to edit the details of the doctor profile
	   * @param currentDoctor Doctor object  
	   * @return updatedPatient Patient object that contains the new details that were supplied by the user
	   */ 
	public Doctor editProfile(Doctor currentDoctor) {
		Scanner input = new Scanner(System.in);
		int docID = currentDoctor.getDocID();
		String doctorName = currentDoctor.getName();
		String docBirthDate = currentDoctor.getBirthDate();
		String docSSN = currentDoctor.getSSN();
		
		Doctor updatedDoctor = currentDoctor;
		
		System.out.println("\t1. Name: " + doctorName + "\n\t2. Birthday: " + docBirthDate + "\n\t3. SSN: " + docSSN);
		System.out.println("What would you like to edit? (input an integer to select)");
  	    String selectedInput = input.next();
    	while (!selectedInput.matches("([1-3])")) {
        	System.out.println("\n** Incorrect input. Please try again. **");
    		System.out.println("What would you like to edit? (input an integer to select)");
	    	selectedInput = input.next();
    	}
	      
	    try {
	    	switch(selectedInput) {
	  	    	case "1"://name
	  	    		System.out.println("Current Name: " + doctorName);
	  	    		System.out.println("Please enter new doctor name: ");
	  	    		input.nextLine();
	  	    		doctorName = input.nextLine();
	  	    		while (!doctorName.matches("([a-zA-Z.\\s]+)")) {
	  	    			System.out.println("\n** Incorrect input. Please try again. **");
		  	    		System.out.println("Please enter new doctor name: ");
		  	    		doctorName = input.nextLine();
	  	    		}
	  	    		updatedDoctor.setName(doctorName);
	  	    		break;
	  	      	case "2"://birthday
	  	      		System.out.println("Current Birthday: " + docBirthDate);
	  	      		System.out.println("Please enter birthday: (in the form YYYY-MM-DD)");
	  	    		input.nextLine();
	  	      		String doctorBirthDate = input.nextLine();	
	  	      		//add error checking for making sure dates are current
	  	      		while (!doctorBirthDate.matches("(\\d{4}-\\d{2}-\\d{2})")) {
	  	      			System.out.println("\n** Incorrect input. Please try again. **");
	  	      			System.out.println("Please enter birthday: (in the form YYYY-MM-DD)");
	  	      			doctorBirthDate = input.nextLine();
	  	      		}
	  	      		updatedDoctor.setBirthDate(doctorBirthDate);
	  	      		break;
	  	      	case "3"://ssn
	  	      		System.out.println("Current SSN: " + docSSN);
	  	      		System.out.println("What would you like to change it to?");
	  	    		input.nextLine();
	  	      		docSSN = input.nextLine();
	  	      		while (!docSSN.matches("(\\d{3}-\\d{2}-\\d{4})")){
	  	      			System.out.println("\n** Incorrect input. Please try again. **");
	  	      			System.out.println("Please enter SSN: (in the following format '###-##-####')");
	  	      			docSSN = input.next();
	  	      		}
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
	
	/**
	   * Allows the doctor manager to edit the details of the doctor profile
	   * @param currentAppt Appointment object 
	   * @param currentDoctor Doctor object  
	   * @return updatedAppt Appointment object that contains the new details that were supplied by the user
	   */ 	
	public Appointment assignDoctorToAppt(Appointment currentAppt, Doctor currentDoctor) {
		Scanner input = new Scanner(System.in);
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
