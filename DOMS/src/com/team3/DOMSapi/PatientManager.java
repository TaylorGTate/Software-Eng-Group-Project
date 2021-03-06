package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public PatientManager () {
		
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
	
	public ArrayList<Appointment> checkPatientIn(String username, String password, ArrayList<Appointment> aList) throws SQLException {
		
		//Declaring needed variables and objects
		Scanner input = new Scanner(System.in);

		//Print statements to get the patient's ssn that is checking-in
		System.out.println();
		System.out.println("Enter the SSN of the patient you would like to check-in in the following format 123-45-6789");
		String pSSN = input.next();
		  
		//Headers for the patient's appointments
	  	System.out.println();
	  	System.out.println("All of the Patient's appointments:");
	  	System.out.println("Appointment ID" + "\t" + " Patient SSN"+ "\t" + " Appointment Date"+ "\t" + " Appointment Time"+ "\t" + " Appointment Status");
	  	
	  	//Iterate through the ResultSet
  		for (Appointment a: aList) {
  			//Filter all the appointments against the entered Patient SSN
  			if(a.getSSN().equals(pSSN) && a.getStatus().equals("Approved")) {
  				//Print the results
  				System.out.format("%s\t\t %s\t %s\t\t %s\t\t %s\t \n", a.getApptID(), a.getSSN(), a.getDate(), a.getTime(), a.getStatus());
  			}
	  	}
		  
		//Get the appointment ID of the appointment that needs to be checked-in
		System.out.println();
		System.out.println("Enter appointment ID that needs to be checked-in.");
		int appointmentID = input.nextInt();
		
		//Iterate through the Appointment ArrayList
  		for (Appointment a: aList) {
  			//Filter all the appointments against the entered Appointment ID
  			if(a.getApptID() == appointmentID) {
  				a.setStatus("Checked-in");
  			}
	  	}
  		
		
		//Query to assign appointment status to checked-in
		String apptCheckIn = ("UPDATE Appointment set status = 'Checked-in' WHERE appt_id = " + "'" + appointmentID + "'");
		
		//execute update on appointment table to assign room number to appointment  
	  	DataBase.executeUpdate(apptCheckIn, username, password);
		System.out.println();
		System.out.println("Patient sucessfully Checked-in");
		input.close();
		
		//Headers for the patient's appointments
	  	System.out.println();
	  	System.out.println("All of the Patient's appointments:");
	  	System.out.println("Appointment ID" + "\t" + " Patient SSN"+ "\t" + " Appointment Date"+ "\t" + " Appointment Time"+ "\t" + " Appointment Status");
	  	
	  	//Iterate through the ResultSet
  		for (Appointment a: aList) {
  			//Filter all the appointments against the entered Patient SSN
  			if(a.getSSN().equals(pSSN)) {
  				//Print the results
  				System.out.format("%s\t\t %s\t %s\t\t %s\t\t %s\t \n", a.getApptID(), a.getSSN(), a.getDate(), a.getTime(), a.getStatus());
  			}
	  	}
		
		//Return the Appointment ArrayList
		return aList;
	}

		public ArrayList<Patient> editPatientsInfo(String username, String password, ArrayList<Patient> pList) throws SQLException {
		
		//Declaring needed variables and objects
		Scanner input = new Scanner(System.in);

		//Print statements to get the patient's ssn that is checking-in
		System.out.println();
		System.out.println("Enter the SSN of the patient you would like to edit the information for in the following format 123-45-6789");
		String SSN = input.next();
		  
		//Headers for the patient's information
	  	System.out.println();
	  	System.out.println("All of the Patient's Information:");
	  	System.out.println(" 1.Patient SSN"+ "\t" + " 2.Patient Name"+ "\t" + " 3.Birthday"+ "\t" + " 4.Allergies" + "\t" + " 5.Perferred Doctor" + "\t" + " 6.Bloodtype");
		  
	  	
	  	//Iterate through patient ArrayList
  		for (Patient p: pList) {
  			//filter ArrayList for the Patient SSN entered  
  			if(p.getSSN().equals(SSN)) {
  				//Print the results
  				System.out.format("   %s\t   %s\t   %s\t   %s\t\t   %s\t\t   %s\t \n", p.getSSN(), p.getName(), p.getBirthDate(), p.getAllergies(), p.getDoctor(), p.getBloodType());
  			}
	  	}
		  
		//Get the column ID of the patient that needs to be edited
		System.out.println();
		System.out.println("Enter the number of the column you would like to edit");
		int editID = input.nextInt();
		
		switch(editID) {
			case 1:	
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new SSN of the patient in the following format 123-45-6789");
				String newSSN = input.next();
				String oldSSN = null;
				//Iterate through patient ArrayList
		  		for (Patient p: pList) {
		  			//filter ArrayList for the Patient SSN entered
		  			if(p.getSSN().equals(SSN)) {
		  				p.setSSN(newSSN);
		  				oldSSN = SSN;
		  				SSN = newSSN;
		  			}
			  	}

				//Query to assign patient a new SSN
				String changeSSN = ("UPDATE patient set ssn =" + "'" + newSSN + "'" + "WHERE ssn = " + "'" + oldSSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeSSN, username, password);
				System.out.println();
				System.out.println("Patient's SSN sucessfully changed");
				
				//Close scanner
				input.close();
				
				break;
			case 2:
				//Print statements to get the new name of the patient
				System.out.println();
				System.out.println("Enter the new name of the patient");
				String newName = input.next();
				
				//Iterate through patient ArrayList
		  		for (Patient p: pList) {
		  			//filter ArrayList for the Patient SSN entered
		  			if(p.getSSN().equals(SSN)) {
		  				p.setName(newName);
		  			}
			  	}
				
				//Query to assign patient a new ssn
				String changeName = ("UPDATE patient set patientName =" + "'" + newName + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeName, username, password);
				System.out.println();
				System.out.println("Patient's name sucessfully changed");
				input.close();
				break;
			case 3:
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new Birthday of the patient in the following format yyyy-mm-dd");
				String newBirthday = input.next();
				
				//Iterate through patient ArrayList
		  		for (Patient p: pList) {
		  			//filter ArrayList for the Patient SSN entered
		  			if(p.getSSN().equals(SSN)) {
		  				p.setBirthDate(newBirthday);
		  			}
			  	}
				
				//Query to assign patient a new ssn
				String changeBirthday = ("UPDATE patient set birthDate =" + "'" + newBirthday + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeBirthday, username, password);
				System.out.println();
				System.out.println("Patient's birthday sucessfully changed");
				input.close();
				break;
			case 4:
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new allergies of the patient");
				String newAllergies = input.next();
				
				//Iterate through patient ArrayList
		  		for (Patient p: pList) {
		  			//filter ArrayList for the Patient SSN entered
		  			if(p.getSSN().equals(SSN)) {
		  				p.setAllergies(newAllergies);
		  			}
			  	}
				
				//Query to assign patient a new ssn
				String changeAllergies = ("UPDATE patient set allergies =" + "'" + newAllergies + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeAllergies, username, password);
				System.out.println();
				System.out.println("Patient's name sucessfully changed");
				input.close();
				break;
			case 5:
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new preferred doctor of the patient");
				String newPreDoc = input.next();
				
				//Iterate through patient ArrayList
		  		for (Patient p: pList) {
		  			//filter ArrayList for the Patient SSN entered
		  			if(p.getSSN().equals(SSN)) {
		  				p.setDoctor(newPreDoc);
		  			}
			  	}
				
				//Query to assign patient a new ssn
				String changePreDoc = ("UPDATE patient set preferredDoctor =" + "'" + newPreDoc + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changePreDoc, username, password);
				System.out.println();
				System.out.println("Patient's perferred doctor sucessfully changed");
				input.close();
				break;	
			case 6:
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new blood type of the patient");
				String newBloodType = input.next();
				
				//Iterate through patient ArrayList
		  		for (Patient p: pList) {
		  			//filter ArrayList for the Patient SSN entered
		  			if(p.getSSN().equals(SSN)) {
		  				p.setBloodType(newBloodType);
		  			}
			  	}
				
				//Query to assign patient a new ssn
				String changeBloodType = ("UPDATE patient set bloodtype =" + "'" + newBloodType + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeBloodType, username, password);
				System.out.println();
				System.out.println("Patient's blood type sucessfully changed");
				input.close();
				break;			
		}
		
		//Headers for the patient's information
	  	System.out.println();
	  	System.out.println("All of the Patient's Information:");
	  	System.out.println(" Patient SSN"+ "\t" + " Patient Name"+ "\t" + " Birthday"+ "\t" + " Allergies" + "\t" + " Perferred Doctor" + "\t" + " Bloodtype");
	  	
	  	//Iterate through patient ArrayList
  		for (Patient p: pList) {
  			//filter ArrayList for the Patient SSN entered  
  			if(p.getSSN().equals(SSN)) {
  				//Print the results
  				System.out.format("   %s\t   %s\t   %s\t   %s\t\t   %s\t\t\t   %s\t \n", p.getSSN(), p.getName(), p.getBirthDate(), p.getAllergies(), p.getDoctor(), p.getBloodType());
  			}
	  	}
		
		//return Patient ArrayList
  		return pList;
		  
	}
	
	
	
	public String removePatientFromDB(String username, String password, ArrayList<Patient> pList) throws SQLException {
		
		//Declaring needed variables and objects
		Scanner input = new Scanner(System.in);
		String patientName = null;
		
		//Get SSN of patient to be removed
		System.out.println("Please enter SSN of the patient to be deleted:");
        String SSN = input.next();
        
        //iterate through Patient ArrayList
  		for (Patient p: pList) {
	           patientName = p.getName();
  		}
  			
        //Display results
  		System.out.println("\nPatient name to be deleted: " + patientName + "\n");
  		
  		//Queries to remove the Patient from Patient and Appointment DB tables
        String deadDeleteQuery = "delete from Patient where ssn=('" + SSN + "');";
        String deadDeleteQuery2 = "delete from Appointment where Pssn=('" + SSN + "');";
        DataBase.executeUpdate(deadDeleteQuery2, username, password);
        DataBase.executeUpdate(deadDeleteQuery, username, password);
        
        //Close scanner
        input.close();
	
		//return patient ArrayList
		return SSN;
	}
}