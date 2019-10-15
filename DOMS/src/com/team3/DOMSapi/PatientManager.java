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