package com.team3.DOMSapi;

import java.io.IOException;
import java.sql.Connection;
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
	    //String query1 = "insert into Patient values('" + testPatient.getName() + "', '" + testPatient.getBirthDate() + "', '" + testPatient.getSSN() + "', '" + testPatient.getAllergies() + "', '" + testPatient.getDoctor() + "', '" + testPatient.getBloodType() + "');";
	    //System.out.println(query1);
	    
	    //mystmt.executeUpdate(query1);

	    System.out.println("Would you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.\n\t5. Create a user profile.");

	    Room testRoom = new Room(1, 20, "Clean and Ready", null);
	    Room testRoom1 = new Room(1, 10, "Occupied", "123-45-6789");

	    RoomManager testRoomManager = new RoomManager(0, "Tony","1997-03-05");
	    
	    //String query4 = "insert into Room values('" + testRoom1.roomNumber + "', '" + testRoom1.buildingNumber + "', '" + testRoom1.avaliable + "', '" + testRoom1.patientSSN + "');";
	    //String query2 = "insert into Room values('" + testRoom.roomNumber + "', '" + testRoom.buildingNumber + "', '" + testRoom.avaliable + "', '" + testRoom.patientSSN + "');";
	    //String query3 = "insert into RoomManager values('" + testRoomManager.id + "', '"  + testRoomManager.name + "', '" + testRoomManager.birthDate + "');";

	    //mystmt.executeUpdate(query2);
	    //mystmt.executeUpdate(query4);

	    //mystmt.executeUpdate(query3);
	   	    
	    int choice = input.nextInt();
	    switch (choice) {
	      case 1: //Schedule an appointment
          System.out.println("Please enter SSN:");
          String ssn = input.next();
          System.out.println(ssn);
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
          String query3 = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', null);";
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
	      case 5:// Create a user profile
	    	  System.out.println("Please enter first name:");
		        String name = input.next();
		        Patient.setName(name);
		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
		        String birthDate = input.next();
		        Patient.setBirthDate(birthDate);
		        System.out.println("Please enter SSN:");
		        String ssn1 = input.next();
		        Patient.setSSN(ssn1);
		        System.out.println("Please enter any allergies:");
		        String allergies = input.next();
		        Patient.updateAllergies(allergies);
		        System.out.println("Please enter your preferred doctor:");
		        String preferredDoctor = input.next();
		        Patient.setDoctor(preferredDoctor);
		        System.out.println("Please enter your blood type:");
		        String bloodType = input.next();
		        Patient.setbloodType(bloodType);
		        String newPatientQuery= "insert into Patient values('" + name + "', '" + birthDate + "', '" + ssn1 + "', '" + allergies + "', '" + preferredDoctor + "', '" + bloodType + "');";
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