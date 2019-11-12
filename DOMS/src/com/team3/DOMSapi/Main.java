package com.team3.DOMSapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {
	static String patientName;
	static String patientSSN;
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
	static String userSSN;
	static String apptDate = "";
	static String apptTime = "";
	static String apptNotes;
	static String apptStatus;
	static String apptID;
	static int selectedAppt;
	static int selectedInput;
	static String updateQuery;
	static int rowCount=0;
	static int manID;
	static int manIDDB;
	static String manName;
  
	 /**
	   * Connects to Database. Displays menu on login of choices to select from. 
	   * Depending on switch cases, will run the appropriate methods from the appropriate classes. 
	   */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException{

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
	    
	    //AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    //String queryMan = "insert into AppointmentManager values('" + testApptMan.getManID() + "','" + testApptMan.getName() + "', '" + testApptMan.getBirthDate() + "');";
	    //DataBase.executeUpdate(queryMan, usrname, pswd);

	    /*Room testRoom = new Room(1, 20, "Clean and Ready", null);
	    Room testRoom1 = new Room(1, 10, "Occupied", "123-45-6789");

	    RoomManager testRoomManager = new RoomManager(0, "Tony","1997-03-05");*/
		
		//String query4 = "insert into Room values('" + testRoom1.roomNumber + "', '" + testRoom1.buildingNumber + "', '" + testRoom1.avaliable + "', '" + testRoom1.patientSSN + "');";
		//String query2 = "insert into Room values('" + testRoom.roomNumber + "', '" + testRoom.buildingNumber + "', '" + testRoom.avaliable + "', '" + testRoom.patientSSN + "');";
		//String query3 = "insert into RoomManager values('" + testRoomManager.id + "', '"  + testRoomManager.name + "', '" + testRoomManager.birthDate + "');";
		
		//mystmt.executeUpdate(query2);
		//mystmt.executeUpdate(query4);
		
		//mystmt.executeUpdate(query3);
	    //System.out.println("Here");
	    System.out.println("Are you logging in as a \n\t1. Patient \n\t2. Doctor \n\t3. Doctor Manager \n\t4. Room Manager \n\t5. Appointment Manager \n\t6. Patient Manager \n\t7. Creating a new patient profile");
    
	    int flag = 0;
    
	    int typeOfAccountChoice = input.nextInt();
	    switch (typeOfAccountChoice) {
	      case 1: //Patient
	  	    System.out.println("Would you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.\n\t5. Create a user profile.");
	  	    int choice = input.nextInt();
	  	    
	  	    switch (choice) {
	  	      case 1: //Schedule an appointment
	  	    	  System.out.println("Fill out the below information to schedule an appointment.");
		  	      System.out.println("Please enter SSN:");
		  	      userSSN = input.next();
		  	      try {
		            String query2 = "select * from Patient where ssn=('" + userSSN + "');";
		            ResultSet r = DataBase.executeQuery(query2, usrname, pswd);
		               while (r.next ()) {
		                   patientName = r.getString(1);
		                   patientSSN = r.getString(3);
		                   rowCount++;
		               }
		               if (rowCount == 0) {
		            	   System.out.println("Sorry, no patient exists with that SSN.");
		            	   break;
		               }
		               else {
			               // Display results
			               System.out.println("\nPatient name: " + patientName + "\n"); 
		               }
		               rowCount=0;
		          }
		          catch (Exception e) {
		            System.out.println(e);
		          }
		          System.out.println("Please enter a date for your appointment: (in the form YYYY-MM-DD) ");
		          apptDate = input.next();
		          System.out.println("Please enter a time for your appointment: (in the form hh:mm) ");
		          apptTime = input.next();
		          //need to add the seconds for the database entry
		          apptTime += ":00";
		          input.nextLine();
		          System.out.println("Please enter any notes you would like to include: ");
		          String notes = input.nextLine();
		          Appointment newAppt = new Appointment(0, patientSSN, apptDate, apptTime, notes, statuses[0]);
		          String query3 = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', null);";

		          DataBase.executeUpdate(query3, usrname, pswd);

	  	          break;
	  	          
	  	      case 2:// View my appointments.
	  	        System.out.println("Please enter your SSN to view your appointments");
	  	        userSSN = input.next();
	  	        System.out.println("Current Appointments:");
	  	        try {
		            String query2 = "select * from Appointment where Pssn=('" + userSSN + "');";
		            ResultSet r = DataBase.executeQuery(query2, usrname, pswd);
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
		            	   break;
		               }
		               rowCount=0;
		          }
		          catch (Exception e) {
		            System.out.println(e);
		          }
	  	          System.out.println("Thank you. Have a good day.");
	  	          break;
	  	        
	  	      case 3:// Edit my appointment
	  	    	System.out.println("Please enter your SSN to edit your appointments");
	  	        userSSN = input.next();
	  	        
		  	    try {
		  	        String query2 = "select * from Appointment where Pssn=('" + userSSN + "');";
		            ResultSet r = DataBase.executeQuery(query2, usrname, pswd);
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
		            	   break;
		               }
		               rowCount=0;
		          }
		          catch (Exception e) {
		            System.out.println(e);
		          }
	  	          System.out.println("Which appt would you like to edit? (enter an appt ID to select an appt)");

		  	      selectedAppt = input.nextInt();
		  	      
		  	    try {
		  	        String query2 = "select * from Appointment where appt_id=('" + selectedAppt + "');";
		            ResultSet r = DataBase.executeQuery(query2, usrname, pswd);
		            
		               while (r.next ()) {
		            	   apptID = r.getString(1);
		                   apptDate = r.getString(3);
		                   apptTime = r.getString(4);
		                   apptNotes = r.getString(5);
		                   apptStatus = r.getString(6);
		                   
		                   // Display results
		                   System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes);
		                   rowCount++;
		               } 
		               if (rowCount == 0) {
		            	   System.out.println("Sorry, no appointment exists with that Appt ID.");
		            	   break;
		               }
		               rowCount=0;
		          }
		          catch (Exception e) {
		            System.out.println(e);
		          }
		  	    
		  	      System.out.println("What would you like to edit? (input an integer to select)");
		  	      selectedInput = input.nextInt();
		  	      
		  	      switch(selectedInput) {
		  	      	case 1:
		  	    	  System.out.println("Current Appt Date: " + apptDate);
		  	    	  System.out.println("What date would you like to change it to? (in the form YYYY-MM-DD)");
		  	    	  apptDate = input.next();
		  	    	  //changes status back to requested so new date can be approved by appointment manager
		  	    	  updateQuery = "update Appointment set apptDate=('" + apptDate + "'), status=('Requested') where appt_id=('" + selectedAppt + "');";
		  	    	  DataBase.executeUpdate(updateQuery, usrname, pswd);
			  	      System.out.println("Appointment details updated.");
		  	    	  break;
		  	      	case 2:
		  	      	  System.out.println("Current Appt Time: " + apptTime);
		  	    	  System.out.println("What time would you like to change it to? (in the form hh:mm)");
		  	    	  apptTime = input.next();
		  	    	  apptTime += ":00";
		  	    	  //changes status back to requested so new date can be approved by appointment manager
		  	    	  updateQuery = "update Appointment set apptTime=('" + apptTime + "'), status=('Requested') where appt_id=('" + selectedAppt + "');";
		  	    	  DataBase.executeUpdate(updateQuery, usrname, pswd);
			  	      System.out.println("Appointment details updated.");
		  	    	  break;
		  	      	case 3:
		  	      	  System.out.println("Current Appt Notes: " + apptNotes);
		  	    	  System.out.println("What would you like to change the notes to? (no spaces)");
		  	    	  apptNotes = input.next();
		  	    	  updateQuery = "update Appointment set notes=('" + apptNotes + "') where appt_id=('" + selectedAppt + "');";
		  	    	  DataBase.executeUpdate(updateQuery, usrname, pswd);
			  	      System.out.println("Appointment details updated.");
		  	    	  break;
		  	      	default:
		  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
		  	      }
		  	    System.out.println("Thank you. Have a good day.");
	  	          break;
	  	        
	  	      case 4:// Cancel my appointment
	  	    	System.out.println("Please enter your SSN to view your appointments");
	  	        userSSN = input.next();
	  	        
		  	    try {
		  	        String query2 = "select * from Appointment where Pssn=('" + userSSN + "');";
		            ResultSet r = DataBase.executeQuery(query2, usrname, pswd);
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
		            	   break;
		               }
		               rowCount=0;
		          }
		          catch (Exception e) {
		            System.out.println(e);
		          }
	  	          System.out.println("Which appt would you like to cancel? (enter an appt ID to select an appt)");
		  	      selectedAppt = input.nextInt();
		  	   
			  	    try {
			  	        String query2 = "select * from Appointment where appt_id=('" + selectedAppt + "');";
			            ResultSet r = DataBase.executeQuery(query2, usrname, pswd);
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
			            	   break;
			               }
			               rowCount=0;
			          }
			          catch (Exception e) {
			            System.out.println(e);
			          }
			  	    System.out.println("Are you sure you want to cancel the above appointment? (y/n)");

			  	    String deleteInput = input.next();
			  	    switch(deleteInput) {
			  	    	case ("y"):
			  	    		updateQuery = "delete from Appointment where appt_id=('" + selectedAppt + "');";
		  	    			System.out.println("Appointment cancelled.");
		  	    			break;
			  	    	case ("n"):
			  	    		System.out.println("Appointment not cancelled.");
			  	    		break;
			  	    	default:
				  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
			  	    }

			  	    
			  	    DataBase.executeUpdate(updateQuery, usrname, pswd);

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
		  	    	System.out.println("Please enter the doctor's name (no spaces):");
	  		        String name = input.next();
	  		        Doctor.setName(name);
	  		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
	  		        String birthDate = input.next();
	  		        Doctor.setBirthDate(birthDate);
	  		        System.out.println("Please enter SSN:");
	  		        String ssn = input.next();
	  		        Doctor.setSSN(ssn);
	  		        
	  		        String newDoctorQuery= "insert into Doctor values('" + 0 + "', '" + name + "', '" + birthDate + "', '" + ssn + "');";
	  			    System.out.print(newDoctorQuery);
	  			    
	  			    DataBase.executeUpdate(newDoctorQuery,  usrname, pswd);
	  			    
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
	    	  System.out.println("Would you like to:\n\t1. Assign checked in patient to a room. \n\t2. Set room availablity. \n\t3. Check room availablilty");
	    	  int RMchoice = input.nextInt();
	    	  
	    	  switch (RMchoice) {
	    	  	case 1:// Assign checked in patients to a room
	    	  		RoomManager.assignPatientRoom();
	    	  		break;
	    	  	case 2:// Set room availability
	    	  		
	    	  		//Headers for clean and ready Room list
	    	  		System.out.println();
    				System.out.println("All Rooms:");
    				System.out.println("Room Number" + "\t" + " Room Status");
	    				
	    	  	    //Query for all the Rooms
	    	  		String allRooms = "SELECT * From Room";
	    	  		
	    	  		//ResultSet of all the checked in the appointments
	    	  		ResultSet rs1 = DataBase.executeQuery(allRooms, usrname, pswd);
	    	  		
	    	  		//iterate through the ResultSet
	    	  		while (rs1.next()) {
	    	  			int id = rs1.getInt("roomNumber");
	    	  			String avaliable = rs1.getString("avaliable");
	    	  			
	    	  			//Print the results
	    	  			System.out.format("%s\t\t %s\t \n", id, avaliable);
	    	  		}
	    	  		
	    	  		//Declare needed variables
	    	  		String roomNum = null;
	    	  		int statusChoice = 0;
	    	  		
	    	  		//Get number of room that status' needs to be changed
	    	  		System.out.println("What is the number of the room you would like to set the availability for?");
	    	  		roomNum = input.next();
	    	  		
	    	  		//Ask the user what status they are assigning to the room
	    	  		System.out.println("What status would you like to assign to room " + roomNum +":\n\t1. Clean and Ready \n\t2. Occupied \n\t3. Empty and Dirty");
	    	  		statusChoice = input.nextInt();
	    	  		
	    	  		//Switch statement to assign room selected availability
	    	  		switch(statusChoice) {
		    	  		case 1:// Assign room Clean and Ready status
		    	  			RoomManager.setRoomStatusToClean(roomNum, usrname, pswd);
		    	  			System.out.println("Room number " + roomNum + " status' has been set to Clean and Ready");
		    	  			break;
		    	  		case 2:// Assign room Occupied status
		    	  			RoomManager.setRoomStatusToOccupied(roomNum, usrname, pswd);
		    	  			System.out.println("Room number " + roomNum + " status' has been set to Occupied");
		    	  			break;
		    	  		case 3:// Assign room Empty and Dirty status
		    	  			RoomManager.setRoomStatusToDirty(roomNum, usrname, pswd);
		    	  			System.out.println("Room number " + roomNum + " status' has been set to Empty and Dirty");
		    	  			break;  			
	    	  		}

	    	  		break;
	    	  	case 3:// Check room availability
	    	  		
	    	  		//Declare needed variables
	    	  		String roomNumber = null;
	    	  		
	    	  		//Get the room number from the RM 
	    	  		System.out.println("Please enter the room number of the room you would like to know the status of.");
	    	  		roomNumber = input.next();
	    	  		
	    	  		//Call getRoomStatusMethod
	    	  		String roomStatus = RoomManager.getRoomStatus(roomNumber, usrname, pswd);
	    	  		
	    			//Print the status of the room
	    			System.out.println("The status of room number " + roomNumber + " is " + roomStatus);
	    	  		break;
	    	  }
	    	  break;
	      case 5: //Appointment Manager
	    	  System.out.println("Please enter Manager ID: ");
	    	  manID = input.nextInt();
	    	  
	    	  String queryMan = "select * from AppointmentManager where manager_id=('" + manID + "');";

	    	  ResultSet r = DataBase.executeQuery(queryMan, usrname, pswd);
              while (r.next ()) {
           	   	  manIDDB = r.getInt(1);
           	   	  manName = r.getString(2);
                  
                  // Display results
           	   	  if (manID != manIDDB) {
                      System.out.println("There is no manager ID that matches: " + manID);
                      break;
           	   	  }
           	   	  else {
           	   		  System.out.println("Hello, " + manName + ".\n");
           	   	  }
                  rowCount++;
              } 
              if (rowCount == 0) {
           	   System.out.println("Sorry, no appt managers exist with that Manager ID.");
           	   break;
              }
              rowCount=0;
	    	  System.out.println("Would you like to:\n\t1. View all appts.\n\t2. View 'Approved' Appts. \n\t3. View 'Requested' Appts.\n\t4. Edit Appts.\n\t5. Approve/Deny 'Requested' Appts.\n\t6. Schedule an Appt.");
	    	  selectedInput = input.nextInt();
	    	  
	    	  switch(selectedInput) {
	    	  	case 1: //View all appts
	    	  		try {
	    	  			String query2 = "select * from Appointment;";
	    		    	ResultSet r2 = DataBase.executeQuery(query2, usrname, pswd);
	    	            while (r2.next ()) {
	    	            	apptID = r2.getString(1);
			                apptDate = r2.getString(3);
			                apptTime = r2.getString(4);
			                apptNotes = r2.getString(5);
			                apptStatus = r2.getString(6);
			                   
			                // Display results
			                System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
			                rowCount++;
	    	            } 
	    	            if (rowCount == 0) {
	    	            	System.out.println("Sorry, there are no appointments.");
	    	           	   	break;
	    	            }
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		break;
	    	  	case 2: //view approved appts
	    	  		try {
	    	  			String query2 = "select * from Appointment where status=('Approved');";
	    		    	ResultSet r2 = DataBase.executeQuery(query2, usrname, pswd);
	    	            while (r2.next ()) {
	    	            	apptID = r2.getString(1);
			                apptDate = r2.getString(3);
			                apptTime = r2.getString(4);
			                apptNotes = r2.getString(5);
			                apptStatus = r2.getString(6);
			                   
			                // Display results
			                System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
			                rowCount++;
	    	            } 
	    	            if (rowCount == 0) {
	    	            	System.out.println("Sorry, there are no appointments.");
	    	           	   	break;
	    	            }
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		break;
	    	  	case 3: //view requested appts
	    	  		try {
	    	  			String query2 = "select * from Appointment where status=('Requested');";
	    		    	ResultSet r2 = DataBase.executeQuery(query2, usrname, pswd);
	    	            while (r2.next ()) {
	    	            	apptID = r2.getString(1);
			                apptDate = r2.getString(3);
			                apptTime = r2.getString(4);
			                apptNotes = r2.getString(5);
			                apptStatus = r2.getString(6);
			                   
			                // Display results
			                System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
			                rowCount++;
	    	            } 
	    	            if (rowCount == 0) {
	    	            	System.out.println("Sorry, there are no appointments.");
	    	           	   	break;
	    	            }
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		break;
	    	  	case 4: //edit appts
			  	    try {
			  	    	String query2 = "select * from Appointment;";
			            r = DataBase.executeQuery(query2, usrname, pswd);
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
			            	   System.out.println("Sorry, there are no appointments.");
			            	   break;
			               }
			               rowCount=0;
			          }
			          catch (Exception e) {
			            System.out.println(e);
			          }
		  	          System.out.println("Which appt would you like to edit? (enter an appt ID to select an appt)");
			  	      selectedAppt = input.nextInt();
			  	      
			  	    try {
			  	        String query2 = "select * from Appointment where appt_id=('" + selectedAppt + "');";
			            ResultSet r3 = DataBase.executeQuery(query2, usrname, pswd);
			            
			               while (r3.next ()) {
			            	   apptID = r3.getString(1);
			                   apptDate = r3.getString(3);
			                   apptTime = r3.getString(4);
			                   apptNotes = r3.getString(5);
			                   apptStatus = r3.getString(6);
			                   
			                   // Display results
			                   System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes+ "\n\t4. Appt Status: " + apptStatus);
			                   rowCount++;
			               } 
			               if (rowCount == 0) {
			            	   System.out.println("Sorry, no appointment exists with that Appt ID.");
			            	   break;
			               }
			               rowCount=0;
			          }
			          catch (Exception e) {
			            System.out.println(e);
			          }
			  	    
			  	      System.out.println("What would you like to edit? (input an integer to select)");
			  	      selectedInput = input.nextInt();
			  	      
			  	      switch(selectedInput) {
			  	      	case 1:
			  	    	  System.out.println("Current Appt Date: " + apptDate);
			  	    	  System.out.println("What date would you like to change it to? (in the form YYYY-MM-DD)");
			  	    	  apptDate = input.next();
			  	    	  //changes status back to requested so new date/time can be approved by appointment manager
			  	    	  updateQuery = "update Appointment set apptDate=('" + apptDate + "'), status=('Requested') where appt_id=('" + selectedAppt + "');";
			  	    	  mystmt.executeUpdate(updateQuery);
				  	      System.out.println("Appointment details updated.");
			  	    	  break;
			  	      	case 2:
			  	      	  System.out.println("Current Appt Time: " + apptTime);
			  	    	  System.out.println("What time would you like to change it to? (in the form hh:mm)");
			  	    	  apptTime = input.next();
			  	    	  apptTime += ":00";
			  	    	  //changes status back to requested so new date/time can be approved by appointment manager
			  	    	  updateQuery = "update Appointment set apptTime=('" + apptTime + "'), status=('Requested') where appt_id=('" + selectedAppt + "');";
			  	    	  mystmt.executeUpdate(updateQuery);
				  	      System.out.println("Appointment details updated.");
			  	    	  break;
			  	      	case 3:
			  	      	  System.out.println("Current Appt Notes: " + apptNotes);
			  	    	  System.out.println("What would you like to change the notes to?");
			  	    	  apptNotes = input.nextLine();
			  	    	  updateQuery = "update Appointment set notes=('" + apptNotes + "') where appt_id=('" + selectedAppt + "');";
			  	    	  mystmt.executeUpdate(updateQuery);
				  	      System.out.println("Appointment details updated.");
			  	    	  break;
			  	      	case 4:
			  	      	  System.out.println("Current Appt Status: " + apptStatus);
			  	    	  System.out.println("What would you like to change the notes to (choices: 'Requested', 'Accepted', or 'Denied')?");
			  	    	  apptStatus = input.next();
			  	    	  updateQuery = "update Appointment set status=('" + apptStatus + "') where appt_id=('" + selectedAppt + "');";
			  	    	  mystmt.executeUpdate(updateQuery);
				  	      System.out.println("Appointment details updated.");
			  	    	  break;
			  	      	default:
			  	      		System.out.println("Sorry, you did not enter a valid option. Bye.");
			  	      }
		  	          break;
	    	  	case 5: //approve/deny requested appts
	    	  		try {
	    	  			String query2 = "select * from Appointment where status=('Requested');";
	    		    	ResultSet r2 = DataBase.executeQuery(query2, usrname, pswd);
	    	            while (r2.next ()) {
	    	            	apptID = r2.getString(1);
			                apptDate = r2.getString(3);
			                apptTime = r2.getString(4);
			                apptNotes = r2.getString(5);
			                apptStatus = r2.getString(6);
			                   
			                // Display results
			                System.out.println("Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus);
			                rowCount++;
	    	            } 
	    	            if (rowCount == 0) {
	    	            	System.out.println("Sorry, there are no appointments.");
	    	           	   	break;
	    	            }
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		
		  	        System.out.println("Which appt would you like to approve/deny? (enter an appt ID to select an appt)");
		  	        selectedAppt = input.nextInt();
		  	        
		  	        try {
			  	        String query2 = "select * from Appointment where appt_id=('" + selectedAppt + "');";
			            ResultSet r3 = DataBase.executeQuery(query2, usrname, pswd);
			            
			               while (r3.next ()) {
			            	   apptID = r3.getString(1);
			                   apptDate = r3.getString(3);
			                   apptTime = r3.getString(4);
			                   apptNotes = r3.getString(5);
			                   apptStatus = r3.getString(6);
			                   
			                   // Display results
			                   System.out.println("Appt ID: " + apptID + "\n\t1. Appt Date: " + apptDate + "\n\t2. Appt Time: " + apptTime + "\n\t3. Appt Notes: " + apptNotes+ "\n\t4. Appt Status: " + apptStatus);
			                   rowCount++;
			               } 
			               if (rowCount == 0) {
			            	   System.out.println("Sorry, no appointment exists with that Appt ID.");
			            	   break;
			               }
			               rowCount=0;
			          }
			          catch (Exception e) {
			            System.out.println(e);
			          }
		  	        
		  	        System.out.println("\nWould you like to approve or deny this appointment? (input an integer to select)\n\t1. Approve\n\t2. Deny");
		  	        selectedInput = input.nextInt();
		  	        
		  	        switch(selectedInput) {
		  	      		case 1: //approve
		  	      			updateQuery = "update Appointment set status=('Approved') where appt_id=('" + selectedAppt + "');";
		  	      			mystmt.executeUpdate(updateQuery);
		  	      			System.out.println("Appointment approved.");
		  	      			break;
		  	      		case 2: //deny
		  	      			updateQuery = "update Appointment set status=('Denied') where appt_id=('" + selectedAppt + "');";
		  	      			mystmt.executeUpdate(updateQuery);
		  	      			System.out.println("Appointment denied.");
		  	      			break;
		  	      		default:
		  	      			System.out.println("Sorry, you did not enter a valid option. Bye.");
		  	        }
	    	  		break;
	    	  	case 6: //schedule appt
	    	  		System.out.println("Fill out the below information to schedule an appointment.");
			  	    System.out.println("Please enter Patient's SSN:");
			  	    userSSN = input.next();
			  	    try {
			          String query2 = "select * from Patient where ssn=('" + userSSN + "');";
			          ResultSet r2 = DataBase.executeQuery(query2, usrname, pswd);
			             while (r2.next ()) {
			                 patientName = r2.getString(1);
			                 patientSSN = r2.getString(3);
			                 rowCount++;
			             }
			             if (rowCount == 0) {
			            	 System.out.println("Sorry, no patient exists with that SSN.");
			            	 break;
			             }
			             else {
			            	 // Display results
				             System.out.println("\nPatient name: " + patientName + "\n"); 
			             }
			             rowCount=0;
			        }
			        catch (Exception e) {
			        	System.out.println(e);
			        }
			        System.out.println("Please enter a date for your appointment: (in the form YYYY-MM-DD) ");
			        apptDate = input.next();
			        System.out.println("Please enter a time for your appointment: (in the form hh:mm) ");
			        apptTime = input.next();
			        //need to add the seconds for the database entry
			        apptTime += ":00";
			        input.nextLine();
			        System.out.println("Please enter any notes you would like to include: ");
			        String notes = input.nextLine();
			        Appointment newAppt = new Appointment(0, patientSSN, apptDate, apptTime, notes, statuses[0]);
			        String query3 = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', null);";

			        DataBase.executeUpdate(query3, usrname, pswd);
			        System.out.println("Appointment created.");
	    	  		break;
	    	  	default:
	     	    	 System.out.println("Sorry, you did not enter a valid option. Bye.");
	    	  	}
	    	  break;
	      case 6: //Patient Manager
	    	  System.out.println("Would you like to:\n\t1. Check-in patient.\n\t2. Edit patient user profile.\n\t3. Remove dead patient from database.");
	    	  int PMchoice = input.nextInt();
	    	  
	    	  switch(PMchoice) {
		    	  case 1://check-in patient
		    		  PatientManager.checkPatientIn();
		    		  break;
		    		  
		    	  case 2://edit a patient's user profile
		    		  break;
		    		  
		    	  case 3: //Remove dead patient from database
			  	      PatientManager.removePatientFromDB();
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
  		        System.out.println("Please enter your preferred doctor (no spaces):");
  		        String preferredDoctor = input.next();
  		        Patient.setDoctor(preferredDoctor);
  		        System.out.println("Please enter your blood type:");
  		        String bloodType = input.next();
  		        Patient.setbloodType(bloodType);
  		        String newPatientQuery= "insert into Patient values('" + name + "', '" + birthDate + "', '" + ssn + "', '" + allergies + "', '" + preferredDoctor + "', '" + bloodType + "');";
  			    System.out.print(newPatientQuery);
  			    DataBase.executeUpdate(newPatientQuery, usrname, pswd);
  			    
  			    
  			    break;
	      case 8:// Quit
	    	  flag = 1;
	    	  break;
	    
  	       default:
  	    	 System.out.println("Sorry, you did not enter a valid option. Bye.");
	    }
	     //Close objects
	     input.close();
	}
}