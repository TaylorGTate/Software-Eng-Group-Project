package com.team3.DOMSapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static String patientName;
	static String patientSSN;
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};
	static String userSSN;
	static int userID;
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
	static String patName;
	static String birthDate;
	static String allergies;
	static String prefDoc;
	static String bloodType;
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the log in message for the user.
	 */
	public static int logInMessage(Scanner input) {
	    System.out.println("Are you logging in as a \n\t1. Patient \n\t2. Doctor \n\t3. Doctor Manager \n\t4. Room Manager \n\t5. Appointment Manager \n\t6. Patient Manager \n\t7. Creating a new patient profile");
	    int typeOfAccountChoice = input.nextInt();
	    
		return typeOfAccountChoice;
	}
	
	public static int patientManagerIndex(ArrayList<PatientManager> pmList, int pmID) {
		//Declare needed variables
		int pmIndex = 0;
		
		//for loop to search ArrayList for the patient manager matching the id entered
		for (PatientManager pm: pmList) {
			if(pm.getID() == pmID) {
				pmIndex = pmList.indexOf(pm);
			}
		}
		
		//return the Patient Manager's ArayList index
		return pmIndex;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the menu message for the patient
	 * and returns the choice that the user selected.
	 */
	public static int patientMenu(Scanner input) {
  	    System.out.println("Would you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.\n\t5. Edit user profile.");
  	    int choice = input.nextInt();
  	    
		return choice;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the menu message for the doctor
	 * and returns the choice that the user selected.
	 */
	public static int doctorMenu(Scanner input) {
		System.out.println("Would you like to:\n\t1. Update Patient user profile.\n\t2. Update Appointment details.");
  	    int choice = input.nextInt();
  	    
		return choice;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the prompt message for the user 
	 * to enter their SSN and returns the SSN that was input.
	 */
	public static String getUserSSN(Scanner input) {
		System.out.println("Please enter SSN in the following format 123-45-6789:");
	    String userSSN = input.next();
	    
		return userSSN;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the prompt message for the user 
	 * to enter their ID and returns the ID that was input.
	 */
	public static int getUserID(Scanner input) {
		System.out.println("Please enter ID num:");
	    int userID = input.nextInt();
	    
		return userID;
	}
	
	/*
	 * Input: the patient's SSN and an ArrayList containing the patients
	 * Output: Returns the Patient object indicated by the SSN
	 */
	public static Patient getCurrentPatient(String userSSN, ArrayList<Patient> patientList) {
  	    Patient patient = null;
    	for (int i=0; i<patientList.size(); i++) {
    		String ssn = patientList.get(i).getSSN();
    		if (ssn.equals(userSSN)) {
    			patient = patientList.get(i);
    		}
    	}
    	return patient;
	}
	
	/*
	 * Input: the Doctor's ID and an ArrayList containing the doctors
	 * Output: Returns the Doctor object indicated by the ID
	 */
	public static Doctor getCurrentDoctor(int doctorID, ArrayList<Doctor> doctorList) {
  	    Doctor doctor = null;
    	for (int i=0; i<doctorList.size(); i++) {
    		int id = doctorList.get(i).getDocID();
    		if (id == doctorID) {
    			doctor = doctorList.get(i);
    		}
    	}
    	return doctor;
	}
	
	/*
	 * Input: the appt ID and an ArrayList containing the appts
	 * Output: Returns the Appointment object indicated by the appt ID
	 */
	public static Appointment getCurrentAppointment(int apptID, ArrayList<Appointment> apptList) {
  	    Appointment appt = null;
    	for (int i=0; i<apptList.size(); i++) {
    		int id = apptList.get(i).getApptID();
    		if (id == apptID) {
    			appt = apptList.get(i);
    		}
    	}
    	return appt;
	}
  
	 /**
	   * Connects to Database. Displays menu on login of choices to select from. 
	   * Depending on switch cases, will run the appropriate methods from the appropriate classes. 
	   */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException{

		ArrayList<Patient> patientList = new ArrayList<Patient>();
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		ArrayList<PatientManager> patientManagerList = new ArrayList<PatientManager>();

		Patient currentPatient = null;
		Doctor currentDoctor = null;
		Appointment currentAppt = null;
		
		Scanner input = new Scanner(System.in);
	    System.out.println("Enter DB user name: ");
	    String usrname = input.next();
	    System.out.println("Enter password: ");
	    String pswd = input.next();

	    Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
	    System.out.println("DB connected..");
	    Statement mystmt = myconn.createStatement();

	    //Test objects
	    Patient testPatient = new Patient("Robert Hall", "1967-02-04", "222-33-4444", "N/A", "Dr. Smith", "O+");
	    patientList.add(testPatient);
	    //String query1 = "insert into Patient values('" + testPatient.getName() + "', '" + testPatient.getBirthDate() + "', '" + testPatient.getSSN() + "', '" + testPatient.getAllergies() + "', '" + testPatient.getDoctor() + "', '" + testPatient.getBloodType() + "');";
	    //mystmt.executeUpdate(query1);
	    
	    PatientManager testPatientManager = new PatientManager(4, "Taylor Tate", "1997-05-03");
	    patientManagerList.add(testPatientManager);
	    //String query1 = "insert into Patient values('" + testPatient.getName() + "', '" + testPatient.getBirthDate() + "', '" + testPatient.getSSN() + "', '" + testPatient.getAllergies() + "', '" + testPatient.getDoctor() + "', '" + testPatient.getBloodType() + "');";
	    //mystmt.executeUpdate(query1);
	    
	    Doctor testDoctor = new Doctor(1, "Robert Hall", "1967-02-04", "333-44-5555");
	    doctorList.add(testDoctor);
	    //String query1 = "insert into Doctor values('" + testDoctor.getDocID() + "','" + testDoctor.getName() + "', '" + testDoctor.getBirthDate() + "', '" + testDoctor.getSSN() + "');";
	    //mystmt.executeUpdate(query1);
	    
	    Appointment testAppt = new Appointment(13, "222-33-4444","2000-05-03","12:30:00","N/A",statuses[0], 0);
	    apptList.add(testAppt);
	    //String query1 = "insert into Appointment values('" + testAppt.getApptID() + "','" + testAppt.getSSN() + "', '" + testAppt.getDate() + "', '" + testAppt.getTime() + "', '" + testAppt.getNotes() + "', '" + testAppt.getStatus() + "', '" + testAppt.getRoomNum() + "');";
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
    
	    int flag = 0;
    
	    int typeOfAccountChoice = logInMessage(input);
	    
	    switch (typeOfAccountChoice) {
	    	case 1: //Patient
	    		int choice = patientMenu(input);
	  	    
	    		switch (choice) {
	  	      	case 1: //Schedule an appointment
	  	      		System.out.println("Fill out the below information to schedule an appointment.");
	  	      		userSSN = getUserSSN(input);
	  	      		currentPatient = getCurrentPatient(userSSN, patientList);

	  	      		try {		            
	  	      			Appointment newAppt = currentPatient.requestAppt(input);
	  	      			apptList.add(newAppt);
	  	      			
	  	      			String query3 = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', null);";
	  	      			DataBase.executeUpdate(query3, usrname, pswd);
		  	    		System.out.println("Appointment requested.");

	  	      		}
	  	      		catch (Exception e) {
	  	      			System.out.println(e);
	  	      		}	          
	  	      		break;
	  	          
	  	      	case 2:// View my appointments.
		  	        userSSN = getUserSSN(input);
		  	        currentPatient = getCurrentPatient(userSSN, patientList);
		  	        try {
			            currentPatient.viewAppts(apptList);
			        }
			        catch (Exception e) {
			            System.out.println(e);
			        }
		  	        break;
	  	        
	  	      case 3:// Edit my appointment
	  	    	  userSSN = getUserSSN(input);
	  	    	  currentPatient = getCurrentPatient(userSSN, patientList);
	  	        
	  	    	  try {
	  	    		  currentAppt = currentPatient.selectAppt(apptList, input);
	  	    		  
	  	    		  currentAppt = currentPatient.editAppt(currentAppt, input);
	  	    		  
			  	      updateQuery = "update Appointment set apptTime=('" + currentAppt.getTime() + "'), apptDate=('" + currentAppt.getDate() + "'), notes=('" + currentAppt.getNotes() + "'), status=('Requested') where appt_id=('" + currentAppt.getApptID() + "');";
	  	    		  DataBase.executeUpdate(updateQuery, usrname, pswd);
	  	    		  System.out.println("Appointment details updated.");
		          }
		          catch (Exception e) {
		        	  System.out.println(e);
		          }
	  	          break;
	  	        
	  	      case 4:// Cancel my appointment
		  	        userSSN = getUserSSN(input);
		  	        currentPatient = getCurrentPatient(userSSN, patientList);
		  	        
			  	    try {
			  	    	currentAppt = currentPatient.selectAppt(apptList, input);

			            currentAppt = currentPatient.cancelAppt(currentAppt, input);
			            
			            if (currentAppt != null){
			  	    		updateQuery = "delete from Appointment where appt_id=('" + currentAppt.getApptID() + "');";
			            	DataBase.executeUpdate(updateQuery, usrname, pswd);
			            	apptList.remove(currentAppt);
			            }
			        }
			        catch (Exception e) {
			            System.out.println(e);
			        }
		  	        break;
		  	        
	  	      case 5:// Edit user profile
	  	    	  userSSN = getUserSSN(input);
	  	    	  currentPatient = getCurrentPatient(userSSN, patientList);
	  	        
	  	    	  try {
	  	    		  currentPatient = currentPatient.editProfile(input);
	  	    		  
			          if (currentPatient != null){
			  	      	  updateQuery = "update Patient set patientName=('" + currentPatient.name + "'), birthDate=('" + currentPatient.birthDate + "'), allergies=('" + currentPatient.allergies + "'), preferredDoctor=('" + currentPatient.preferredDoctor + "'), bloodtype=('" + currentPatient.bloodType + "') where ssn=('" + currentPatient.ssn + "');";
			        	  DataBase.executeUpdate(updateQuery, usrname, pswd);
			        	  
				  	      for (int i=0; i<patientList.size(); i++) {
				  	    	  if (patientList.get(i).getSSN().equals(currentPatient.ssn)){
				  	    		  patientList.set(i, currentPatient);
				  	    	  }
				  	      }
			        	  System.out.println("Profile details updated.");
			          }
	  	    	  }
	  	    	  catch (Exception e) {
	  	    		  System.out.println(e);
	  	    	  }
	  	    	  System.out.println("Thank you. Have a good day.");
	  	          break;
	  	      default:
	  	    	  System.out.println("Sorry, you did not enter a valid option. Bye.");
	      }
	      break;
	      case 2: //Doctor
	    	  	userID = getUserID(input);
	    	  	currentDoctor = getCurrentDoctor(userID, doctorList);
		  	    int selected = doctorMenu(input);
		  	    
		  	    switch (selected) {
		  	      case 1: //Update patient user profile
		  	    	userSSN = getUserSSN(input);
		  	        currentPatient = getCurrentPatient(userSSN, patientList);
		  	        
			  	    try {
			  	    	currentPatient = currentDoctor.editUserProfile(currentPatient, input);
			            
			  	    	if (currentPatient != null){
			  	      	    updateQuery = "update Patient set patientName=('" + currentPatient.name + "'), birthDate=('" + currentPatient.birthDate + "'), allergies=('" + currentPatient.allergies + "'), preferredDoctor=('" + currentPatient.preferredDoctor + "'), bloodtype=('" + currentPatient.bloodType + "') where ssn=('" + currentPatient.ssn + "');";
			        	    DataBase.executeUpdate(updateQuery, usrname, pswd);
			        	  
				  	        for (int i=0; i<patientList.size(); i++) {
				  	    	    if (patientList.get(i).getSSN().equals(currentPatient.ssn)){
				  	    		    patientList.set(i, currentPatient);
				  	    	    }
				  	        }
			        	    System.out.println("Profile details updated.");
			            }
		            }
			          catch (Exception e) {
			            System.out.println(e);
			          }
			  	    System.out.println("Thank you. Have a good day.");
		  	          break;
		  	      case 2: //update appt notes
		  	    	userSSN = getUserSSN(input);
		  	        currentPatient = getCurrentPatient(userSSN, patientList);
		  	        
			  	    try {
		  	    		currentAppt = currentPatient.selectAppt(apptList, input);
			  	    	currentAppt = currentDoctor.editApptNotes(currentAppt, input);
			            if (currentAppt != null){
					  	    updateQuery = "update Appointment set notes=('" + currentAppt.getNotes() + "') where appt_id=('" + currentAppt.getApptID() + "');";
			        	    DataBase.executeUpdate(updateQuery, usrname, pswd);
			        	  
				  	        for (int i=0; i<apptList.size(); i++) {
				  	    	    if (apptList.get(i).getApptID() == currentAppt.getApptID()){
				  	    	    	apptList.set(i, currentAppt);
				  	    	    }
				  	        }
			        	    System.out.println("Profile details updated.");
			            }
		            }
			          catch (Exception e) {
			            System.out.println(e);
			          }
		  	        for (int i=0; i<apptList.size(); i++) {
		  	    	    if (apptList.get(i).getApptID() == currentAppt.getApptID()){
		  	    	    	System.out.println(apptList.get(i).getNotes());
		  	    	    }
		  	        }
			  	    System.out.println("Thank you. Have a good day.");
		  	          break;
		  	      default:
		  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
		  	    }
		        
	    	  break;
	      case 3: //Doctor Manager
	    	  System.out.println("Would you like to:\n\t1. Create doctor user profile. \n\t2. Edit doctor user profile.\n\t3. Assign doctor to appointment.");
		  	    int DMchoice = input.nextInt();
		  	    
		  	    switch (DMchoice) {
		  	      case 1: //Create doctor user profile
		  	    	System.out.println("Please enter the doctor's name (no spaces):");
	  		        String name = input.next();
	  		        //Doctor.setName(name);
	  		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
	  		        String birthDate = input.next();
	  		        //Doctor.setBirthDate(birthDate);
	  		        System.out.println("Please enter SSN:");
	  		        String ssn = input.next();
	  		        //Doctor.setSSN(ssn);
	  		        
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
			        //Appointment newAppt = new Appointment(0, patientSSN, apptDate, apptTime, notes, statuses[0]);
			        //String query3 = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', null);";

			        //DataBase.executeUpdate(query3, usrname, pswd);
			        System.out.println("Appointment created.");
	    	  		break;
	    	  	default:
	     	    	 System.out.println("Sorry, you did not enter a valid option. Bye.");
	    	  	}
	    	  break;
	      case 6: //Patient Manager
	    	  
	    	  //Getting the Patient Manager's id
	    	  System.out.println("Please enter your Patient Manager ID.");
	    	  int PMid = input.nextInt();
	    	  
	    	  //Find the ArrayList index of the patient manager
	    	  int PMIndex = patientManagerIndex(patientManagerList, PMid);
	    	  
	    	  //Patient Manager menu options
	    	  System.out.println("Would you like to:\n\t1. Check-in patient.\n\t2. Edit patient user profile.\n\t3. Remove dead patient from database.");
	    	  int PMchoice = input.nextInt();
	    	  
	    	  
	    	  switch(PMchoice) {
		    	  case 1://check-in patient
		    		  patientManagerList.get(PMIndex).checkPatientIn(usrname, pswd);
		    		  break;
		    		  
		    	  case 2://edit a patient's user profile
		    		  patientManagerList.get(PMIndex).editPatientsInfo(usrname, pswd);
		    		  break;
		    		  
		    	  case 3: //Remove patient from database
			  	      patientManagerList.get(PMIndex).removePatientFromDB(usrname, pswd);
			  	      break;
			  	      default:
			  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
			  	   
		    	  }
	    	  
	    	  break;
	      case 7: //create a new patient profile
  	    	    System.out.println("Please enter first name:");
  		        String name = input.next();
  		        Patient Patient = new Patient();
  		        Patient.setName(name);
  		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
  		        String birthDate = input.next();
  		        Patient.setBirthDate(birthDate);
  		        System.out.println("Please enter SSN:");
  		        String ssn = input.next();
  		        Patient.setSSN(ssn);
  		        System.out.println("Please enter any allergies:");
  		        String allergies = input.next();
  		        Patient.setAllergies(allergies);
  		        System.out.println("Please enter your preferred doctor (no spaces):");
  		        String preferredDoctor = input.next();
  		        Patient.setDoctor(preferredDoctor);
  		        System.out.println("Please enter your blood type:");
  		        String bloodType = input.next();
  		        Patient.setBloodType(bloodType);
  		        String newPatientQuery= "insert into Patient values('" + name + "', '" + birthDate + "', '" + ssn + "', '" + allergies + "', '" + preferredDoctor + "', '" + bloodType + "');";
  			    System.out.print(newPatientQuery);
  			    DataBase.executeUpdate(newPatientQuery, usrname, pswd);
  			    // Add to patient array list
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