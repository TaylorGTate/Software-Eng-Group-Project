package com.team3.DOMSapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException{
	    //Load MySql JDBC Driver
	    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (Exception e) {
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
	    
	    //Patient testPatient = new Patient("John Smith", "1996-04-02", "122-45-6789", "N/A", "Dr. Smith", "O+");
	    //String query1 = "insert into Patient values('" + testPatient.name + "', '" + testPatient.birthDate + "', '" + testPatient.ssn + "', '" + testPatient.allergies + "', '" + testPatient.preferredDoctor + "', '" + testPatient.bloodType + "');";
	    //System.out.print(query1);
	    
	    //mystmt.executeUpdate(query1);
	    
	    System.out.println("Are you logging in as a \n\t1. Patient \n\t2. Doctor \n\t3. Doctor Manager \n\t4. Room Manager \n\t5. Appointment Manager \n\t6. Patient Manager \n\t7. Creating a new patient profile");
	    int typeOfAccountChoice = input.nextInt();
	    switch (typeOfAccountChoice) {
	      case 1: //Patient
	    	System.out.println("Would you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.");
	  	    int choice = input.nextInt();
	  	    
	  	    switch (choice) {
	  	      case 1: //Schedule an appointment
	  	    	System.out.println("Fill out the below information to schedule an appointment:");
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
