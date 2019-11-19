package com.team3.DOMSapi;

import java.sql.ResultSet;
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
	public Patient() {
		// TODO Auto-generated constructor stub
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
	public void updateAllergies(String allergy) {
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
	public void setbloodType(String blood) {
		bloodType = blood;
	}
	/**
	   * Patient requests an appointment date and time.
	   * @param date This patient's requested appointment date  
	   * @param time This patient's requested appointment time
	   */
	public String requestAppt(ResultSet r, Scanner input) {
		String patientName = "";
		String patientSSN = "";
		int rowCount = 0;
		try {
			while (r.next ()) {
	            patientName = r.getString(1);
	            patientSSN = r.getString(3);
	            rowCount++;
			}
			if (rowCount == 0) {
				System.out.println("Sorry, no patient exists with that SSN.");
			}
			else {
				System.out.println("\nPatient name: " + patientName + "\n"); 
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Please enter a date for your appointment: (in the form YYYY-MM-DD) ");
        String apptDate = input.next();
        System.out.println("Please enter a time for your appointment: (in the form hh:mm) ");
        String apptTime = input.next();
        //need to add the seconds for the database entry
        apptTime += ":00";
        input.nextLine();
        System.out.println("Please enter any notes you would like to include: ");
        String notes = input.nextLine();
        
        Appointment newAppt = new Appointment(0, patientSSN, apptDate, apptTime, notes, statuses[0]);
        String query3 = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', null);";
        return query3;
	}
	
	public void viewAppts(ResultSet r) {
		String apptID = "";
		String apptDate = "";
		String apptTime = "";
		String apptNotes = "";
		String apptStatus = "";
		int rowCount = 0;
		
		System.out.println("Current Appointments:");

		try {
			while (r.next ()) {
				apptID = r.getString(1);
	            apptDate = r.getString(3);
	            apptTime = r.getString(4);
	            apptNotes = r.getString(5);
	            apptStatus = r.getString(6);
	            
	            // Display results
	            System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
	            rowCount++;
			} 
			if (rowCount == 0) {
				System.out.println("Sorry, no patient exists with that SSN.");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int selectAppt(ResultSet r, Scanner input) {
		String apptID = "";
		String apptDate = "";
		String apptTime = "";
		String apptNotes = "";
		String apptStatus = "";
		int rowCount = 0;
		int selectedAppt = 0;
		
		try {
			while (r.next ()) {
				apptID = r.getString(1);
	            apptDate = r.getString(3);
	            apptTime = r.getString(4);
	            apptNotes = r.getString(5);
	            apptStatus = r.getString(6);
	            
	            // Display results
	            System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
	            rowCount++;
			} 
			if (rowCount == 0) {
				System.out.println("Sorry, no patient exists with that SSN.");
			}
	        System.out.println("Which appt would you like to edit? (enter an appt ID to select an appt)");
	        selectedAppt = input.nextInt();
		}
		catch (Exception e) {
			System.out.println(e);
		}

        return selectedAppt;
	}
	
	public String editAppt(ResultSet r, Scanner input) {
		String apptID = "";
		String apptDate = "";
		String apptTime = "";
		String apptNotes = "";
		int rowCount = 0;
		int selectedInput = 0;
		String updateQuery = "";
		
		try {
			while (r.next ()) {
				apptID = r.getString(1);
	            apptDate = r.getString(3);
	            apptTime = r.getString(4);
	            apptNotes = r.getString(5);
	            
	            // Display results
	            System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes);
	            rowCount++;
			} 
			if (rowCount == 0) {
				System.out.println("Sorry, no appointment exists with that Appt ID.");
			}
			System.out.println("What would you like to edit? (input an integer to select)");
	  	    selectedInput = input.nextInt();
	  	      
	  	    switch(selectedInput) {
	  	    	case 1:
	  	    		System.out.println("Current Appt Date: " + apptDate);
		  	    	System.out.println("What date would you like to change it to? (in the form YYYY-MM-DD)");
		  	    	apptDate = input.next();
		  	    	//changes status back to requested so new date can be approved by appointment manager
		  	    	updateQuery = "update Appointment set apptDate=('" + apptDate + "'), status=('Requested') where appt_id=('" + apptID + "');";
		  	    	break;
	  	    	case 2:
	  	      		System.out.println("Current Appt Time: " + apptTime);
	  	      		System.out.println("What time would you like to change it to? (in the form hh:mm)");
	  	      		apptTime = input.next();
	  	      		apptTime += ":00";
	  	      		//changes status back to requested so new date can be approved by appointment manager
	  	      		updateQuery = "update Appointment set apptTime=('" + apptTime + "'), status=('Requested') where appt_id=('" + apptID + "');";
	  	      		break;
	  	    	case 3:
	  	      		System.out.println("Current Appt Notes: " + apptNotes);
	  	      		System.out.println("What would you like to change the notes to? (no spaces)");
	  	      		apptNotes = input.next();
	  	      		updateQuery = "update Appointment set notes=('" + apptNotes + "') where appt_id=('" + apptID + "');";
	  	      		break;
	  	    	default:
	  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return updateQuery;
	}
	
	public String cancelAppt(ResultSet r, Scanner input) {
		String apptID = "";
		String apptDate = "";
		String apptTime = "";
		String apptNotes = "";
		String apptStatus = "";
		int rowCount = 0;
		String updateQuery = "";
		
		try {
			while (r.next ()) {
				apptID = r.getString(1);
				apptDate = r.getString(3);
				apptTime = r.getString(4);
				apptNotes = r.getString(5);
				apptStatus = r.getString(6);
            
				// Display results
				System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
				rowCount++;
			} 
			if (rowCount == 0) {
				System.out.println("Sorry, no appointments exists with that Appt ID.");
			}		
			
			System.out.println("Are you sure you want to cancel the above appointment? (y/n)");
	  	    String deleteInput = input.next();
	  	    
	  	    switch(deleteInput) {
	  	    	case ("y"):
	  	    		updateQuery = "delete from Appointment where appt_id=('" + apptID + "');";
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

		return updateQuery;
	}
	
	public String editProfile(ResultSet r, Scanner input) {
		String patName = "";
		String birthDate = "";
		String allergies = "";
		String prefDoc = "";
		String bloodType = "";
		int rowCount = 0;
		int selectedInput = 0;
		String updateQuery = "";
		
		try {
			while (r.next ()) {
				patName = r.getString(1);
				birthDate = r.getString(2);
				allergies = r.getString(4);
				prefDoc = r.getString(5);
				bloodType = r.getString(6);
            
				// Display results
				System.out.println("\t1. Name: " + patName + "\n\t2. Birthday: " + birthDate + "\n\t3. Allergies: " + allergies + "\n\t4. Preferred Doctor: " + prefDoc + "\n\t5. Blood type: " + bloodType);
				rowCount++;
			} 
			if (rowCount == 0) {
				System.out.println("Sorry, no patient profile exists with that SSN.");
			}
			
			System.out.println("What would you like to edit? (input an integer to select)");
	  	    selectedInput = input.nextInt();
	  	      
	  	    switch(selectedInput) {
	  	    	case 1://name
	  	    		System.out.println("Current Name: " + patName);
	  	    		System.out.println("What would you like to change it to?");
	  	    		input.nextLine();
	  	    		patName = input.nextLine();
	  	    		updateQuery = "update Patient set patientName=('" + patName + "') where ssn=('" + ssn + "');";
	  	    		break;
	  	      	case 2://birthday
	  	      		System.out.println("Current Birthday: " + birthDate);
	  	      		System.out.println("What date would you like to change it to?");
	  	      		input.nextLine();
	  	      		birthDate = input.nextLine();
	  	      		updateQuery = "update Patient set birthDate=('" + birthDate + "') where ssn=('" + ssn + "');";
	  	      		break;
	  	      	case 3://allergies
	  	      		System.out.println("Current Allergies: " + allergies);
	  	      		System.out.println("What would you like to change it to?");
	  	      		input.nextLine();
	  	      		allergies = input.nextLine();
	  	      		updateQuery = "update Patient set allergies=('" + allergies + "') where ssn=('" + ssn + "');";
	  	      		break;
	  	      	case 4://preferred doctor
	  	      		System.out.println("Current preferred doctor: " + prefDoc);
	  	      		System.out.println("Who would you like to change it to? (no spaces)");
	  	      		input.nextLine();	
	  	      		prefDoc = input.nextLine();
	  	      		updateQuery = "update Patient set preferredDoctor=('" + prefDoc + "') where ssn=('" + ssn + "');";
	  	      		break;
	  	      	case 5://blood type
	  	      		System.out.println("Current blood type: " + bloodType);
	  	      		System.out.println("What would you like to change it to?");
	  	      		input.nextLine();
	  	      		bloodType = input.nextLine();
	  	      		updateQuery = "update Patient set bloodtype=('" + bloodType + "') where ssn=('" + ssn + "');";
	  	      		break;
	  	      	default:
	  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return updateQuery;
	}
}