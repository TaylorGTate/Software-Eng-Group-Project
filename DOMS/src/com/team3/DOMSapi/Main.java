package com.team3.DOMSapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static String patientName;
	static String patientSSN;
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
  
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException{
	    //Load MySql JDBC Driver
	    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (Exception e) {
	    	//Need to specify specific exception
	        System.out.println ("Could not load the driver");
		}

	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter DB user name: ");
	    String usrname = input.next();
	    System.out.println("Enter password: ");
	    String pswd = input.next();
	    
	    Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
	    System.out.println("DB connected..");

	    Statement mystmt = myconn.createStatement();

	    //Patient testPatient = new Patient("John Smith", "1996-03-02", "123-45-6789", "N/A", "Dr. Smith", "O+");
	    //String query1 = "insert into Patient values('" + testPatient.name + "', '" + testPatient.birthDate + "', '" + testPatient.ssn + "', '" + testPatient.allergies + "', '" + testPatient.preferredDoctor + "', '" + testPatient.bloodType + "');";
	    //System.out.print(query1);
	    //mystmt.executeUpdate(query1);
	    
		Room testRoom = new Room(1, 20, "Clean and Ready", null);
		Room testRoom1 = new Room(1, 10, "Occupied", "123-45-6789");
		
		RoomManager testRoomManager = new RoomManager(0, "Tony","1997-03-05");
		
		//String query4 = "insert into Room values('" + testRoom1.roomNumber + "', '" + testRoom1.buildingNumber + "', '" + testRoom1.avaliable + "', '" + testRoom1.patientSSN + "');";
		//String query2 = "insert into Room values('" + testRoom.roomNumber + "', '" + testRoom.buildingNumber + "', '" + testRoom.avaliable + "', '" + testRoom.patientSSN + "');";
		//String query3 = "insert into RoomManager values('" + testRoomManager.id + "', '"  + testRoomManager.name + "', '" + testRoomManager.birthDate + "');";
		
		//mystmt.executeUpdate(query2);
		//mystmt.executeUpdate(query4);
		
		//mystmt.executeUpdate(query3);


	    System.out.println("Are you logging in as a \n\t1. Patient \n\t2. Doctor \n\t3. Doctor Manager \n\t4. Room Manager \n\t5. Appointment Manager \n\t6. Patient Manager \n\t7. Creating a new patient profile");
	    int typeOfAccountChoice = input.nextInt();
	    switch (typeOfAccountChoice) {
	      case 1: //Patient
	    	System.out.println("Would you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.");
	  	    int choice = input.nextInt();
	  	    
	  	    switch (choice) {
	  	      case 1: //Schedule an appointment
	  	    	System.out.println("Fill out the below information to schedule an appointment.");
	  	    	System.out.println("Please enter SSN:");
	            String ssn = input.next();
	            try {
	              String query2 = "select * from Patient where ssn=('" + ssn + "');";
	              ResultSet r = mystmt.executeQuery(query2);
	                 while (r.next ()) {
	                     patientName = r.getString(1);
	                     patientSSN = r.getString(3);
	                 }      

	                 // Display results
	                 System.out.println("\nPatient name: " + patientName + "\n"); 
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
	            String query3 = "insert into Appointment values('" + newAppt.apptID + "', '" + newAppt.patientSSN + "', '" + newAppt.apptDate + "', '" + newAppt.apptTime + "', '" + newAppt.notes + "', '" + newAppt.status + "');";

	            mystmt.executeUpdate(query3);
	  	        break;
	  	      case 2:// View my appointments.
	  	        System.out.println("Please enter your SSN to view your appointments");
	  	        break;
	  	      case 3:// Edit my appointment
	  	        System.out.println("Please enter your SSN to edit your appointments");
	  	        break;
	  	      case 4:// Cancel my appointment
	  	        System.out.println("Please enter your SSN to cancel your appointments");
	  	        System.out.println("Are you sure you want to cancel your appointment? (y/n)");
	  	        break;
	  	      default:
	  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
	  	    }
	        break;
	      case 2: //Doctor
	    	  break;
	      case 3: //Doctor Manager
	    	  System.out.println("Would you like to:\n\t1. Create doctor user profile. \n\t2. Edit doctor user profile.\n\t3. Assign doctor to appointment.");
		  	    int DMchoice = input.nextInt();
		  	    
		  	    switch (DMchoice) {
		  	      case 1: //Create doctor user profile
		  	    	System.out.println("Please enter the doctor's name:");
	  		        String name = input.next();
	  		        Doctor.setName(name);
	  		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
	  		        String birthDate = input.next();
	  		        Doctor.setBirthDate(birthDate);
	  		        System.out.println("Please enter SSN:");
	  		        String ssn = input.next();
	  		        Doctor.setSSN(ssn);
	  		        
	  		        String newDoctorQuery= "insert into Doctor values('" + name + "', '" + birthDate + "', '" + ssn + "');";
	  			    System.out.print(newDoctorQuery);
	  			    
	  			    mystmt.executeUpdate(newDoctorQuery);
	  			    
		  	        break;
		  	      case 2:// Edit doctor user profile
		  	        System.out.println("");
		  	        break;
		  	      case 3:// Assign doctor to appointment
		  	        System.out.println("");
		  	        break;
		  	      default:
		  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
		  	    }
	    	  break;
	      case 4: //Room Manager
	    	  break;
	      case 5: //Appointment Manager
	    	  break;
	      case 6: //Patient Manager
	    	  System.out.println("Would you like to:\n\t1. Check-in patient.\n\t2. Edit patient user profile.\n\t3. Remove dead patient from database.");
		  	   int PMchoice = input.nextInt();
		  	   switch (PMchoice) {
		  	      case 1: //Check-in patient
		  	    	  break;
		  	      case 2: //Edit patient user profile
		  	    	  break;
		  	      case 3: //Remove dead patient from database
		  	    	System.out.println("Please enter SSN of dead patient:");
		            String deadSSN = input.next();
		            try {
		              String deadSSNquery = "select * from Patient where ssn=('" + deadSSN + "');";
		              ResultSet deadResult = mystmt.executeQuery(deadSSNquery);
		                 while (deadResult.next ()) {
		                     patientName = deadResult.getString(1);
		                     patientSSN = deadResult.getString(3);
		                 }      
		                 // Display results
		                 System.out.println("\nPatient name: " + patientName + "\n"); 
		            }
		            catch (Exception e) {
		              System.out.println(e);
		            }
		  	    	break;
		  	      default:
		  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
		  	    }
		  	   	break;
	      case 7: //create a new patient profile

  	    	    System.out.println("Please enter first name:");
  		        String name = input.next();
  		        Patient.setName(name);
  		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
  		        String birthDate = input.next();
  		        Patient.setBirthDate(birthDate);
  		        System.out.println("Please enter SSN:");
  		        String ssn = input.next();
  		        Patient.setSSN(ssn);
  		        System.out.println("Please enter any allergies:");
  		        String allergies = input.next();
  		        Patient.updateAllergies(allergies);
  		        System.out.println("Please enter your preferred doctor:");
  		        String preferredDoctor = input.next();
  		        Patient.setDoctor(preferredDoctor);
  		        System.out.println("Please enter your blood type:");
  		        String bloodType = input.next();
  		        Patient.setbloodType(bloodType);
  		        String newPatientQuery= "insert into Patient values('" + name + "', '" + birthDate + "', '" + ssn + "', '" + allergies + "', '" + preferredDoctor + "', '" + bloodType + "');";
  			    System.out.print(newPatientQuery);
  			    
  			    mystmt.executeUpdate(newPatientQuery);
  			    
  			    break;
	    
  	       default:
  	    	 System.out.println("Sorry, you did not enter a valid option. Bye.");
	    }

	     //Close objects
	     mystmt.close();
	     myconn.close();
	     input.close();
	}
}