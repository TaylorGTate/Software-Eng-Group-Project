package com.team3.DOMSapi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an appointment manager at a doctor's office.
 * A appointment manager can approve, deny, or edit appointment requests.
 */
public class AppointmentManager {
	int man_id;
	String name;
	String birthDate;
	String statuses[] = {"Requested", "Approved", "Denied"};
  
	public AppointmentManager(int manID, String apptMgrName, String apptMgrBirthDate) {
		man_id = manID;
		name = apptMgrName;
		birthDate = apptMgrBirthDate;
	}
	
	//empty constructor
	public AppointmentManager() {
	}
	/**
	   * Gets the first and last name of this appointment manager.
	   * @return this appointment manager's name.
	   */
	public String getName() {
		return name;
	}
	/**
	   * Changes the manager ID of this appointment manager.
	   * @param manID This appointment manager's new manager ID.  
	   */
	public void setManID(int manID) {
		man_id = manID;
	}
	/**
	   * Gets the manager ID of this appointment manager.
	   * @return this appointment manager's ID.
	   */
	public int getManID() {
		return man_id;
	}
	/**
	   * Changes the appointment manager's name.
	   * @param apptMgrName This appointment manager's new name.  
	   */
	public void setName(String apptMgrName) {
		name = apptMgrName;
	}
	/**
	   * Gets the birthday of this appointment manager.
	   * @return this appointment manager's birthday.
	   */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	   * Changes the appointment manager's birthday.
	   * @param birthday This appointment manager's birthday.  
	   */
	public void setBirthDate(String birthday) {
		birthDate = birthday;
	}
	
	/*
	public boolean isBirthday(Patient patient) {
		final DateFormat dateFormat = new SimpleDateFormat("MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println(currentDate);
		if (patient.birthDate == currentDate) {
			return true;
		}
		else {
			return false;
		}
	}
	*/
	/**
	   * Changes the appointment's status to denied.
	   * @param appt Appointment to be denied.  
	   */
	public Appointment denyApptRequest(Appointment appt) {
		Appointment currentAppt = appt;
		
		currentAppt.status = statuses[2];
		
		return currentAppt;

		
	}
	/**
	   * Changes the appointment's status to approved.
	   * @param appt Appointment to be approved.  
	   */
	public Appointment approveApptRequest(Appointment appt) {
		Appointment currentAppt = appt;
		
		currentAppt.status = statuses[1];
		
		return currentAppt;

	}
	
	/**
	   * Allows the appt manager to view all of the current appts.
	   * @param apptList ArrayList containing all current appts.
	   */
	public void viewAppts(ArrayList<Appointment> apptList) {
		
		try {
			for (int i=0; i<apptList.size(); i++) {
				int apptID = apptList.get(i).getApptID();
				String apptDate = apptList.get(i).getDate();
				String apptTime = apptList.get(i).getTime();
				String apptNotes = apptList.get(i).getNotes();
				String apptStatus = apptList.get(i).getStatus();
				
				// Display results
	            System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
    		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	   * Allows the appt manager to view all of the current approved appts.
	   * @param apptList ArrayList containing all current appts.
	   */
	public void viewApprovedAppts(ArrayList<Appointment> apptList) {
		
		try {
			for (int i=0; i<apptList.size(); i++) {
				Appointment appt = apptList.get(i);
				String status = appt.getStatus();
				if (status.equals("Approved")) {
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
	   * Allows the appt manager to view all of the current requested appts.
	   * @param apptList ArrayList containing all current appts.
	   */
	public void viewRequestedAppts(ArrayList<Appointment> apptList) {
		
		try {
			for (int i=0; i<apptList.size(); i++) {
				Appointment appt = apptList.get(i);
				String status = appt.getStatus();
				if (status.equals("Requested")) {
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
				int apptID = apptList.get(i).getApptID();
				String apptDate = apptList.get(i).getDate();
				String apptTime = apptList.get(i).getTime();
				String apptNotes = apptList.get(i).getNotes();
				String apptStatus = apptList.get(i).getStatus();
				
				// Display results
	            System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
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
}
