package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static void checkPatientIn() throws SQLException {
		
		//Declaring needed variables and objects
		String username = "root";
		String password = "toor";
		Scanner input = new Scanner(System.in);

		//Print statements to get the patient's ssn that is checking-in
		System.out.println();
		System.out.println("Enter the SSN of the patient you would like to check-in in the following format 123-45-6789");
		String pSSN = input.next();
		  
		//Headers for the patient's appointments
	  	System.out.println();
	  	System.out.println("All of the Patient's appointments:");
	  	System.out.println("Appointment ID" + "\t" + " Patient SSN"+ "\t" + " Appointment Date"+ "\t" + " Appointment Time"+ "\t" + " Appointment Status");
		  
	  	//Query to get the patient's appointment info
	  	String patientAppointmentInfo = ("SELECT * from Appointment WHERE Pssn = " + "'" + pSSN + "'");
	  	//ResultSet of all the appointments the patient has
	  	ResultSet rs = DataBase.executeQuery(patientAppointmentInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		int id = rs.getInt("appt_id");
	  		String Pssn = rs.getString("Pssn");
	  		String apptDate = rs.getString("apptDate");
	  		String apptTime = rs.getString("apptTime");
	  		String status = rs.getString("status");
	  		
	  		//Print the results
	  		System.out.format("%s\t\t %s\t %s\t\t %s\t\t %s\t \n", id, Pssn, apptDate, apptTime, status);
	  	}
		  
		//Get the appointment ID of the appointment that needs to be checked-in
		System.out.println();
		System.out.println("Enter appointment ID that needs to be checked-in.");
		int appointmentID = input.nextInt();
		  
		//Query to assign appointment status to checked-in
		String apptCheckIn = ("UPDATE Appointment set status = 'Checked-in' WHERE appt_id = " + "'" + appointmentID + "'");
		
		//execute update on appointment table to assign room number to appointment  
	  	DataBase.executeUpdate(apptCheckIn, username, password);
		System.out.println();
		System.out.println("Patient sucessfully Checked-in");
		input.close();
	}
	
	public static void editPatientsInfo() throws SQLException {
		
		//Declaring needed variables and objects
		String username = "root";
		String password = "toor";
		Scanner input = new Scanner(System.in);

		//Print statements to get the patient's ssn that is checking-in
		System.out.println();
		System.out.println("Enter the SSN of the patient you would like to edit the information for in the following format 123-45-6789");
		String SSN = input.next();
		  
		//Headers for the patient's information
	  	System.out.println();
	  	System.out.println("All of the Patient's Information:");
	  	System.out.println(" 1.Patient SSN"+ "\t" + " 2.Patient Name"+ "\t" + " 3.Birthday"+ "\t" + " 4.Allergies" + "\t" + " 5.Perferred Doctor" + "\t" + " 6.Bloodtype");
		  
	  	//Query to get the patient's info
	  	String patientInfo = ("SELECT * from Patient WHERE ssn = " + "'" + SSN + "'");
	  	//ResultSet of all the patients information
	  	ResultSet rs = DataBase.executeQuery(patientInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		String patientName = rs.getString("patientName");
	  		String ssn= rs.getString("ssn");
	  		String birthDate = rs.getString("birthDate");
	  		String allergies = rs.getString("allergies");
	  		String preferredDoctor = rs.getString("preferredDoctor");
	  		String bloodtype = rs.getString("bloodtype");

	  		//Print the results
	  		System.out.format("   %s\t   %s\t   %s\t   %s\t\t   %s\t\t\t   %s\t \n", ssn, patientName, birthDate, allergies, preferredDoctor, bloodtype);
	  	}
		  
		//Get the column ID of the patient that needs to be edited
		System.out.println();
		System.out.println("Enter the number of the column you would like to edit");
		int editID = input.nextInt(), num = 0;
		
		switch(editID) {
			case 1:	
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new SSN of the patient in the following format 123-45-6789");
				String newSSN = input.next();

				//Query to assign patient a new ssn
				String changeSSN = ("UPDATE patient set ssn =" + "'" + newSSN + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeSSN, username, password);
				System.out.println();
				System.out.println("Patient's SSN sucessfully changed");
				input.close();
				
				//Headers for the patient's information
			  	System.out.println();
			  	System.out.println("All of the Patient's Information:");
			  	System.out.println(" 1.Patient SSN"+ "\t" + " 2.Patient Name"+ "\t" + " 3.Birthday"+ "\t" + " 4.Allergies" + "\t" + " 5.Perferred Doctor" + "\t" + " 6.Bloodtype");
			  	//Query to get the patient's info
			  	String patientAppointmentInfoEnd = ("SELECT * from Patient WHERE ssn = " + "'" + newSSN + "'");
			  	//ResultSet of all the patients information
			  	ResultSet end = DataBase.executeQuery(patientAppointmentInfoEnd, username, password);
			  	//Iterate through the ResultSet
			  	while(end.next()) {
			  		String patientName = end.getString("patientName");
			  		String ssn= end.getString("ssn");
			  		String birthDate = end.getString("birthDate");
			  		String allergies = end.getString("allergies");
			  		String preferredDoctor = end.getString("preferredDoctor");
			  		String bloodtype = end.getString("bloodtype");

			  		//Print the results
			  		System.out.format("   %s\t   %s\t   %s\t   %s\t\t   %s\t\t\t   %s\t \n", ssn, patientName, birthDate, allergies, preferredDoctor, bloodtype);
			  	}
			  	num = 1;
				break;
			case 2:
				//Print statements to get the new ssn of the patient
				System.out.println();
				System.out.println("Enter the new name of the patient");
				String newName = input.next();
				
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
				
				//Query to assign patient a new ssn
				String changeBloodType = ("UPDATE patient set bloodtype =" + "'" + newBloodType + "'" + "WHERE ssn = " + "'" + SSN + "'");
				
				//execute update on appointment table to assign room number to appointment  
			  	DataBase.executeUpdate(changeBloodType, username, password);
				System.out.println();
				System.out.println("Patient's blood type sucessfully changed");
				input.close();
				break;			
		}
		if (num != 1) {
			//Headers for the patient's information
		  	System.out.println();
		  	System.out.println("All of the Patient's Information:");
		  	System.out.println(" 1.Patient SSN"+ "\t" + " 2.Patient Name"+ "\t" + " 3.Birthday"+ "\t" + " 4.Allergies" + "\t" + " 5.Perferred Doctor" + "\t" + " 6.Bloodtype");
		  	//ResultSet of all the patients information
		  	rs = DataBase.executeQuery(patientInfo, username, password);
		  	//Iterate through the ResultSet
		  	while(rs.next()) {
		  		String patientName = rs.getString("patientName");
		  		String ssn= rs.getString("ssn");
		  		String birthDate = rs.getString("birthDate");
		  		String allergies = rs.getString("allergies");
		  		String preferredDoctor = rs.getString("preferredDoctor");
		  		String bloodtype = rs.getString("bloodtype");
		
		  		//Print the results
		  		System.out.format("   %s\t   %s\t   %s\t   %s\t\t   %s\t\t\t   %s\t \n", ssn, patientName, birthDate, allergies, preferredDoctor, bloodtype);
		  	}
		}
		
		  
	}
	
	public static void removePatientFromDB() throws SQLException {
		
		//Declaring needed variables and objects
		String username = "root";
		String password = "toor";
		Scanner input = new Scanner(System.in);
		String patientName = null , patientSSN = null;
		
		//Get ssn of patient to be removed
		System.out.println("Please enter SSN of dead patient:");
        String deadSSN = input.next();
        
        try {
          String deadSSNquery = "select * from Patient where ssn=('" + deadSSN + "');";
          ResultSet deadResult = DataBase.executeQuery(deadSSNquery, username, password);
             while (deadResult.next ()) {
                 patientName = deadResult.getString(1);
                 patientSSN = deadResult.getString(3);
             }      
             // Display results
             System.out.println("\nDead Patient name: " + patientName + "\n"); 
             String deadDeleteQuery = "delete from Patient where ssn=('" + deadSSN + "');";
             String deadDeleteQuery2 = "delete from Appointment where Pssn=('" + deadSSN + "');";
             DataBase.executeUpdate(deadDeleteQuery2, username, password);
             DataBase.executeUpdate(deadDeleteQuery, username, password);
             System.out.println(patientName + " has been sucessfully deleted");
        }
        catch (Exception e) {
          System.out.println(e);
        }
	}
	
	
}