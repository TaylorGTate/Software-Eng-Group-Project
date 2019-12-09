package com.team3.DOMSapi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a patient at a doctor's office.
 * A patient can have many appointments.
 */
public class Patient {
	 String name;
	 String birthDate;
	 String ssn;
	 String allergies;
	 String preferredDoctor;
	 String bloodType;
	 String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

	public Patient(String patientName, String birthDay, String social, String allergy, String preferredDoc, String blood) {
		name = patientName;
		birthDate = birthDay;
		ssn = social;
		allergies = allergy;
		preferredDoctor = preferredDoc;
		bloodType = blood;
	}
	
	//empty constructor
	public Patient() {
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
	public void setName(String patientName) {
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
	public void setBirthDate(String birthday) {
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
	public void setSSN(String social) {
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
	public void setAllergies(String allergy) {
		allergies = allergy;
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
	public void setDoctor(String docName) {
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
	public void setBloodType(String blood) {
		bloodType = blood;
	}
	/**
	   * Patient requests an appointment.
	   * @param Scanner input  
	   * @return newAppt Appointment object that contains the new appointment details
	   */
	public Appointment requestAppt(Scanner input) {
		String patientName = this.name;
		String patientSSN = this.ssn;
		
		System.out.println("\nPatient name: " + patientName + "\n"); 
		System.out.println("Please enter a date for your appointment: (in the form YYYY-MM-DD) ");
        String apptDate = input.next();
        System.out.println("Please enter a time for your appointment: (in the form hh:mm) ");
        String apptTime = input.next();
        //need to add the seconds for the database entry
        apptTime += ":00";
        input.nextLine();
        System.out.println("Please enter any notes you would like to include: ");
        String notes = input.nextLine();
        System.out.println("Please enter your Preferred Doctor (or 'N/A' if no doctor preferred): ");
        String preferredDoc = input.nextLine();

        Appointment newAppt = new Appointment(0, patientSSN, apptDate, apptTime, notes, statuses[0], preferredDoc, 0);
        return newAppt;
	}
	
	/**
	   * Allows the patient to view all of their current appts.
	   * @param apptList ArrayList containing all current appts.
	   */
	public void viewAppts(ArrayList<Appointment> apptList) {
		
		try {
			for (int i=0; i<apptList.size(); i++) {
				String userSSN = apptList.get(i).getSSN();
				if (this.ssn.equals(userSSN)) {
					int apptID = apptList.get(i).getApptID();
					String apptDate = apptList.get(i).getDate();
					String apptTime = apptList.get(i).getTime();
					String apptNotes = apptList.get(i).getNotes();
					String apptStatus = apptList.get(i).getStatus();
					
					// Display results
		            System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
	    		}
	    	}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	   * Displays all the appts and prompts the user to select an appt
	   * @param input Scanner object  
	   * @param apptList ArrayList containing all the appts
	   * @return selectedAppt Appointment object that the user selected
	   */
	public Appointment selectAppt(ArrayList<Appointment> apptList, Scanner input) {
		Appointment selectedAppt = new Appointment();
		
		try {
			for (int i=0; i<apptList.size(); i++) {
				String userSSN = apptList.get(i).getSSN();
				if (this.ssn.equals(userSSN)) {
					int apptID = apptList.get(i).getApptID();
					String apptDate = apptList.get(i).getDate();
					String apptTime = apptList.get(i).getTime();
					String apptNotes = apptList.get(i).getNotes();
					String apptStatus = apptList.get(i).getStatus();
					
					// Display results
		            System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
	    		}
	    	}
		
			System.out.println("Which appt would you like to edit? (enter an appt ID to select an appt)");
	    	int selected = input.nextInt();
	    	for (int i=0; i<apptList.size(); i++) {
	    		int selectedID = apptList.get(i).getApptID();
	    		if (selected == selectedID) {
	    			selectedAppt = apptList.get(i);
	    		}
	    	}
		}
		catch(Exception e) {
			System.out.println(e);
		}

    	//returns the appt selected by the user
        return selectedAppt;
	}
	
	/**
	   * Allows the user to edit the details of a selected appt
	   * @param input Scanner object  
	   * @param currentAppt Appointment object of the Appointment the user is editing
	   * @return editedAppt Appointment object that contains the new details that were supplied by the user
	   */ 
	public Appointment editAppt(Appointment currentAppt, Scanner input) {
		int apptID = currentAppt.getApptID();
		String apptDate = currentAppt.getDate();
		String apptTime = currentAppt.getTime();
		String apptNotes = currentAppt.getNotes();
		String preferredDoc = currentAppt.getPreferredDoc();

		int selectedInput = 0;
		Appointment editedAppt = currentAppt;
		
		try {
            System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes+ "\n\t4. Preferred Doctor: " + preferredDoc);
            
			System.out.println("What would you like to edit? (input an integer to select)");
	  	    selectedInput = input.nextInt();
	  	    System.out.println(selectedInput);
	  	      
	  	    switch(selectedInput) {
	  	    	case 1:
	  	    		System.out.println("Current Appt Date: " + apptDate);
		  	    	System.out.println("What date would you like to change it to? (in the form YYYY-MM-DD)");
		  	    	apptDate = input.next();
		  	    	editedAppt.setDate(apptDate);
		  	    	
		  	    	break;
	  	    	case 2:
	  	      		System.out.println("Current Appt Time: " + apptTime);
	  	      		System.out.println("What time would you like to change it to? (in the form hh:mm)");
	  	      		apptTime = input.next();
	  	      		apptTime += ":00";
	  	      		editedAppt.setTime(apptTime);
	  	      		
	  	      		break;
	  	    	case 3:
	  	      		System.out.println("Current Appt Notes: " + apptNotes);
	  	      		System.out.println("What would you like to change the notes to?");
	  	      		input.nextLine();
	  	      		apptNotes = input.nextLine();
	  	      		editedAppt.setNotes(apptNotes);
	  	      		
	  	      		break;
	  	    	case 4:
	  	      		System.out.println("Current Preferred Doctor: " + preferredDoc);
	  	      		System.out.println("Who would you like to change the Preferred Doctor to? (or 'N/A' if no preferred doctor)");
	  	      		input.nextLine();
	  	      		preferredDoc = input.nextLine();
	  	      		editedAppt.setPreferredDoc(preferredDoc);
	  	      		
	  	      		break;
	  	    	default:
	  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return editedAppt;
	}
	
	/**
	   * Allows the user to cancel a selected appt
	   * @param input Scanner object  
	   * @param currentAppt Appointment object of the Appointment the user is canceling
	   * @return cancelledAppt Appointment object that is to be canceled, after user verification
	   */ 
	public Appointment cancelAppt(Appointment currentAppt, Scanner input) {
		int apptID = currentAppt.getApptID();
		String apptDate = currentAppt.getDate();
		String apptTime = currentAppt.getTime();
		String apptNotes = currentAppt.getNotes();
		String apptStatus = currentAppt.getStatus();
		Appointment cancelledAppt = new Appointment();
		
		try {
            System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes+ "\n\t4. Appt Status: " + apptStatus);
			
			System.out.println("Are you sure you want to cancel the above appointment? (y/n)");
	  	    String deleteInput = input.next();
	  	    
	  	    switch(deleteInput) {
	  	    	case ("y"):
	  	    		cancelledAppt = currentAppt;
	  	    		System.out.println("Appointment cancelled.");
	  	    		break;
	  	    	case ("n"):
	  	    		System.out.println("Appointment not cancelled.");
	  	    		break;
	  	    	default:
	  	    		System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//returns the appt that is to be cancelled after verifying they wish to cancel
		return cancelledAppt;
	}
	
	/**
	   * Allows the user to edit the details of their user profile
	   * @param input Scanner object  
	   * @return updatedPatient Patient object that contains the new details that were supplied by the user
	   */ 
	public Patient editProfile(Scanner input) {
		String patientName = this.name;
		String patientBirthDate = this.birthDate;
		String patientAllergies = this.allergies;
		String patientDoc = this.preferredDoctor;
		String patientBloodType = this.bloodType;
		Patient updatedPatient = new Patient();
		
		System.out.println("\t1. Name: " + patientName + "\n\t2. Birthday: " + patientBirthDate + "\n\t3. Allergies: " + patientAllergies + "\n\t4. Preferred Doctor: " + patientDoc + "\n\t5. Blood type: " + patientBloodType);

		System.out.println("What would you like to edit? (input an integer to select)");
  	    int selectedInput = input.nextInt();
  	      
  	    try {
  	    	switch(selectedInput) {
	  	    	case 1://name
	  	    		System.out.println("Current Name: " + patientName);
	  	    		System.out.println("What would you like to change it to?");
	  	    		input.nextLine();
	  	    		patientName = input.nextLine();
	  	    		this.setName(patientName);
	  	    		break;
	  	      	case 2://birthday
	  	      		System.out.println("Current Birthday: " + birthDate);
	  	      		System.out.println("What date would you like to change it to?");
	  	      		input.nextLine();
	  	      		patientBirthDate = input.nextLine();
	  	      		this.setBirthDate(patientBirthDate);
	  	      		break;
	  	      	case 3://allergies
	  	      		System.out.println("Current Allergies: " + allergies);
	  	      		System.out.println("What would you like to change it to?");
	  	      		input.nextLine();
	  	      		patientAllergies = input.nextLine();
	  	      		this.setAllergies(patientAllergies);
	  	      		break;
	  	      	case 4://preferred doctor
	  	      		System.out.println("Current preferred doctor: " + patientDoc);
	  	      		System.out.println("Who would you like to change the Preferred Doctor to? (or 'N/A' if no preferred doctor)");
	  	      		input.nextLine();	
	  	      		patientDoc = input.nextLine();
	  	      		this.setDoctor(patientDoc);
	  	      		break;
	  	      	case 5://blood type
	  	      		System.out.println("Current blood type: " + bloodType);
	  	      		System.out.println("What would you like to change it to?");
	  	      		input.nextLine();
	  	      		patientBloodType = input.nextLine();
	  	      		this.setBloodType(patientBloodType);
	  	      		break;
	  	      	default:
	  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
  	    }
  	    catch(Exception e) {
  	    	System.out.println(e);
  	    }
  	    
  	    updatedPatient = this;
		
		return updatedPatient;
	}
}