package com.team3.DOMSapi;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/*
	 * Input: the Scanner input
	 * Output: Prints the log in message for the user.
	 */
	public static String logInMessage(Scanner input) {
	    System.out.println("\nMAIN MENU\nAre you logging in as a \n\t1. Patient \n\t2. Doctor \n\t3. Doctor Manager \n\t4. Room Manager \n\t5. Appointment Manager \n\t6. Patient Manager \n\t7. Creating a new patient profile\n\t8. Quit");
	    String typeOfAccountChoice = input.nextLine();
	    
	    while (!typeOfAccountChoice.matches("[1-8]")) {
        	System.out.println("\n** Incorrect input. Please try again. **");
	    	System.out.println("\nMAIN MENU\nAre you logging in as a \n\t1. Patient \n\t2. Doctor \n\t3. Doctor Manager \n\t4. Room Manager \n\t5. Appointment Manager \n\t6. Patient Manager \n\t7. Creating a new patient profile\n\t8. Quit");
		    typeOfAccountChoice = input.nextLine();
	    }
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
	
	
	public static int roomManagerIndex(ArrayList<RoomManager> rmList, int rmID) {
		//Declare needed variables
		int rmIndex = 0;
		
		//for loop to search ArrayList for the patient manager matching the id entered
		for (RoomManager rm: rmList) {
			if(rm.getID() == rmID) {
				rmIndex = rmList.indexOf(rm);
			}
		}
		
		//return the Patient Manager's ArayList index
		return rmIndex;
	}
	/*
	 * Input: the Scanner input
	 * Output: Prints the menu message for the patient
	 * and returns the choice that the user selected.
	 */
	public static String patientMenu(Scanner input) {
  	    System.out.println("\nPATIENT MENU\nWould you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.\n\t5. Edit user profile.");
  	    String choice = input.nextLine();
  	    
	    if (!choice.matches("[1-5]")) {
        	System.out.println("\n** Incorrect input. Please try again. **");
	  	    System.out.println("\nPATIENT MENU\nWould you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment.\n\t5. Edit user profile.");
		    choice = input.nextLine();
	    }

		return choice;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the menu message for the doctor
	 * and returns the choice that the user selected.
	 */
	public static int doctorMenu(Scanner input) {
		System.out.println("Would you like to:\n\t1. Update Patient user profile.\n\t2. Update Appointment details.\n\t3. Exit to Main Menu");
  	    int choice = input.nextInt();
  	    
		return choice;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the menu message for the doctor
	 * and returns the choice that the user selected.
	 */
	public static int doctorManagerMenu(Scanner input) {
		System.out.println("Would you like to:\n\t1. Create doctor user profile. \n\t2. Edit doctor user profile.\n\t3. Assign doctor to appointment.\n\t4. Exit to Main Menu");
  	    int choice = input.nextInt();
  	    
		return choice;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the menu message for the appt manager
	 * and returns the choice that the user selected.
	 */
	public static int apptManagerMenu(Scanner input) {
		System.out.println("Would you like to:\n\t1. View all appts.\n\t2. View 'Approved' Appts. \n\t3. View 'Requested' Appts.\n\t4. Edit Appts.\n\t5. Approve/Deny 'Requested' Appts.\n\t6. Schedule an Appt.\n\t7. Quit to Main Menu");
  	  	int choice = input.nextInt();
  	    
		return choice;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the prompt message for the user 
	 * to enter their SSN and returns the SSN that was input.
	 */
	public static String getUserSSN(Scanner input) {
		System.out.println("\nPlease enter SSN: (in the following format '###-##-####')");
	    String userSSN = input.next();
	    
	    while (!userSSN.matches("(\\d{3}-\\d{2}-\\d{4})")){
        	System.out.println("\n** Incorrect input. Please try again. **");
	    	System.out.println("Please enter SSN: (in the following format '###-##-####')");
		    userSSN = input.next();
	    }
	    
		return userSSN;
	}
	
	/*
	 * Input: the Scanner input
	 * Output: Prints the prompt message for the user 
	 * to enter their ID and returns the ID that was input.
	 */
	public static int getUserID(Scanner input, String type) {
		System.out.println("Please enter " + type + " ID num:");
	    int userID = input.nextInt();
	    
		return userID;
	}
	
	/*
	 * Input: the patient's SSN and an ArrayList containing the patients
	 * Output: Returns the Patient object indicated by the SSN
	 */
	public static Patient getCurrentPatient(String userSSN, ArrayList<Patient> patientList) {
		Scanner input = new Scanner(System.in);
  	    Patient patient = null;
    	for (int i=0; i<patientList.size(); i++) {
    		String ssn = patientList.get(i).getSSN();
    		if (ssn.equals(userSSN)) {
    			patient = patientList.get(i);
    		}
    	}
    	while (patient==null) {
    		System.out.println("\n** This SSN does not exist in our records. Please try again. **");
    		patient = getCurrentPatient(getUserSSN(input), patientList);
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
    	System.out.println("Welcome, " + doctor.getName() + "!");
    	return doctor;
	}
	/*
	 * Input: the RoomManager's ID and an ArrayList containing the roommanagers
	 * Output: Returns the RoomManager object indicated by the ID
	 */
	public static RoomManager getCurrentRoomManager(int doctorID, ArrayList<RoomManager> roomManagerList) {
  	    RoomManager roomManager = null;
    	for (int i=0; i<roomManagerList.size(); i++) {
    		int id = roomManagerList.get(i).getID();
    		if (id == doctorID) {
    			roomManager = roomManagerList.get(i);
    		}
    	}
    	System.out.println("Welcome, " + roomManager.getName() + "!");
    	return roomManager;
	}
	
	/*
	 * Input: the Doctor's ID and an ArrayList containing the doctors
	 * Output: Returns the Doctor object indicated by the ID
	 */
	public static DoctorManager getCurrentDM(int dmID, ArrayList<DoctorManager> dmList) {
  	    DoctorManager doctorMan = new DoctorManager();
    	for (int i=0; i<dmList.size(); i++) {
    		int id = dmList.get(i).getID();
    		if (id == dmID) {
    			doctorMan = dmList.get(i);
    		}
    	}
    	System.out.println("Welcome, " + doctorMan.getName() + "!");
    	return doctorMan;
	}
	
	/*
	 * Input: the Doctor's ID and an ArrayList containing the appointment managers
	 * Output: Returns the AppointmentManager object indicated by the ID
	 */
	public static AppointmentManager getCurrentAM(int amID, ArrayList<AppointmentManager> amList) {
  	    AppointmentManager apptMan = new AppointmentManager();
    	for (int i=0; i<amList.size(); i++) {
    		int id = amList.get(i).getManID();
    		if (id == amID) {
    			apptMan = amList.get(i);
    		}
    	}
    	System.out.println("Welcome, " + apptMan.getName() + "!");
    	return apptMan;
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
	
	public static void seedDB(String usrname, String pswd) {
	    try {
	    	File file = new File("seeds.txt");
	    	Scanner scanner = new Scanner(file);
	    	while (scanner.hasNext()) {
	    		String line = scanner.nextLine();
	    		DataBase.executeUpdate(line, usrname, pswd);
	    		System.out.println(line);
	    	}
	    	scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
	  	} 
	}
  
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
	    input.nextLine();
	    /*
		String myQueryTest = "SELECT count(*)\r\n" + 
   				"FROM information_schema.TABLES\r\n" + 
   				"WHERE (TABLE_SCHEMA = 'domsdb') AND (TABLE_NAME = 'Patient')";

  	  	int validCount = DataBase.executeQueryCount(myQueryTest, usrname, pswd);
		if (validCount > 0){
			System.out.println("The table exists!");
		}
		else{
			System.out.println("Table does not exist!");
		}
		*/
		
		//Declaring ArrayList from all of the different objects
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		ArrayList<PatientManager> patientManagerList = new ArrayList<PatientManager>();
		ArrayList<DoctorManager> dmList = new ArrayList<DoctorManager>();
		ArrayList<AppointmentManager> amList = new ArrayList<AppointmentManager>();
		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<RoomManager> roomManagerList = new ArrayList<RoomManager>();

		Patient currentPatient = new Patient();
		Doctor currentDoctor = new Doctor();
		Appointment currentAppt = new Appointment();
		DoctorManager currentDM = new DoctorManager();
		AppointmentManager currentAM = new AppointmentManager();
		RoomManager currentRM = new RoomManager();

		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
	    System.out.println("DB connected..");
	    Statement mystmt = myconn.createStatement();
    
    	//seeds the DB using the seeds.txt file
	    //check with user first before seeding DB
	    System.out.print("Seed DB? (y or n): ");
	    String userInput = input.nextLine();
    	while (!userInput.matches("([yYnN]{1})")) {
        	System.out.println("\n** Incorrect input. Please try again. **");
    	    System.out.print("Seed DB? (y or n): ");
			userInput = input.nextLine();
    	}
	    if (userInput.equals("y") || userInput.equals("Y")) {
	      seedDB(usrname, pswd);
	    }
	    
	    //populating ArrayLists with DB info
	    patientList = DataBase.populatePatientAL(patientList, pswd, usrname);
	    doctorList = DataBase.populateDoctorAL(doctorList, pswd, usrname);
	    apptList = DataBase.populateApptAL(apptList, pswd, usrname);
	    patientManagerList= DataBase.populatePMAL(patientManagerList, pswd, usrname);
	    dmList = DataBase.populateDMAL(dmList, pswd, usrname);
	    amList = DataBase.populateAMAL(amList, pswd, usrname);
	    roomList = DataBase.populateRAL(roomList, pswd, usrname);
	    roomManagerList = DataBase.populateRMAL(roomManagerList, pswd, usrname);

	    //Creating flags for the while loops
	    int patFlag = 0;
	    int docFlag = 0;
	    int DMFlag = 0;
	    int RMFlag = 0;
	    int AMFlag = 0;
	    int PMFlag = 0;
	    int mainMenuFlag = 0;
	    
	    String userSSN = "";
	    int docID = 0;
    
	    while (mainMenuFlag == 0) {  
    
	    String typeOfAccountChoice = logInMessage(input);
	    
	    switch (typeOfAccountChoice) {
	    
	    	case "1": //Patient
	    		String choice = patientMenu(input);
	  	    
	    		switch (choice) {
	  	      	case "1": //Schedule an appointment
	  	      		currentPatient = getCurrentPatient(getUserSSN(input), patientList);
	  	      		System.out.println("\nWelcome, " + currentPatient.getName() + "!");


	  	      		try {		            
	  	      			Appointment newAppt = currentPatient.requestAppt(apptList, input);
	  	      			apptList.add(newAppt);
	  	      			
	  	      			String newApptQuery = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', '" + newAppt.getPreferredDoc()+ "', '" + newAppt.getRoomNum() + "');";
	  	      			DataBase.executeUpdate(newApptQuery, usrname, pswd);
		  	    		System.out.println("Appointment requested.");

	  	      		}
	  	      		catch (Exception e) {
	  	      			System.out.println(e);
	  	      		}	          
	  	      		break;
	  	          
	  	      	case "2":// View my appointments.
		  	        userSSN = getUserSSN(input);
		  	        currentPatient = getCurrentPatient(userSSN, patientList);
		  	        try {
			            currentPatient.viewAppts(apptList);
			        }
			        catch (Exception e) {
			            System.out.println(e);
			        }
		  	        break;
	  	        
	  	      case "3":// Edit my appointment
	  	    	  userSSN = getUserSSN(input);
	  	    	  currentPatient = getCurrentPatient(userSSN, patientList);
	  	        
	  	    	  try {
	  	    		  currentAppt = currentPatient.selectAppt(apptList, input);
	  	    		  
	  	    		  Appointment updatedAppt = currentPatient.editAppt(currentAppt, input);
	  	    		  
			  	      String updatedApptQuery = "update Appointment set apptTime=('" + updatedAppt.getTime() + "'), apptDate=('" + updatedAppt.getDate() + "'), notes=('" + updatedAppt.getNotes() + "'), status=('Requested') where appt_id=('" + updatedAppt.getApptID() + "');";
	  	    		  DataBase.executeUpdate(updatedApptQuery, usrname, pswd);
	  	    		  System.out.println("Appointment details updated.");
		          }
		          catch (Exception e) {
		        	  System.out.println(e);
		          }
	  	          break;
	  	        
	  	      case "4":// Cancel my appointment
		  	        userSSN = getUserSSN(input);
		  	        currentPatient = getCurrentPatient(userSSN, patientList);
		  	        
			  	    try {
			  	    	currentAppt = currentPatient.selectAppt(apptList, input);

			            Appointment cancelledAppt = currentPatient.cancelAppt(currentAppt, input);
			            
			            if (cancelledAppt != null){
			  	    		String cancelApptQuery = "delete from Appointment where appt_id=('" + cancelledAppt.getApptID() + "');";
			            	DataBase.executeUpdate(cancelApptQuery, usrname, pswd);
			            	apptList.remove(cancelledAppt);
			            }
			        }
			        catch (Exception e) {
			            System.out.println(e);
			        }
		  	        break;
		  	        
	  	      case "5":// Edit user profile
	  	    	  userSSN = getUserSSN(input);
	  	    	  currentPatient = getCurrentPatient(userSSN, patientList);
	  	        
	  	    	  try {
	  	    		  Patient updatedPatient = currentPatient.editProfile(input);
	  	    		  
			          if (updatedPatient != null){
			  	      	  String updatedPatientQuery = "update Patient set patientName=('" + updatedPatient.name + "'), birthDate=('" + updatedPatient.birthDate + "'), allergies=('" + updatedPatient.allergies + "'), preferredDoctor=('" + updatedPatient.preferredDoctor + "'), bloodtype=('" + updatedPatient.bloodType + "') where ssn=('" + updatedPatient.ssn + "');";
			        	  DataBase.executeUpdate(updatedPatientQuery, usrname, pswd);
			        	  
				  	      for (int i=0; i<patientList.size(); i++) {
				  	    	  if (patientList.get(i).getSSN().equals(updatedPatient.ssn)){
				  	    		  patientList.set(i, updatedPatient);
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
	      case "2": //Doctor
	    	  	docID = getUserID(input, "Doctor");
	    	  	currentDoctor = getCurrentDoctor(docID, doctorList);
		  	    int selected = doctorMenu(input);
		  	    
		    		switch (choice) {
		  	      	case 1: //Schedule an appointment
		  	      		System.out.println("Fill out the below information to schedule an appointment.");
		  	      		userSSN = getUserSSN(input);
		  	      		currentPatient = getCurrentPatient(userSSN, patientList);
	
		  	      		try {		            
		  	      			Appointment newAppt = currentPatient.requestAppt(apptList, input);
		  	      			apptList.add(newAppt);
		  	      			
		  	      			String newApptQuery = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', '" + newAppt.getPreferredDoc()+ "', '" + newAppt.getRoomNum() + "');";
		  	      			DataBase.executeUpdate(newApptQuery, usrname, pswd);
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
			  	    try {
		  	    		currentAppt = currentPatient.selectAppt(apptList, input);
			  	    	Appointment updatedAppt = currentDoctor.editApptNotes(currentAppt, input);
			            if (currentAppt != null){
					  	    String updatedApptQuery = "update Appointment set notes=('" + updatedAppt.getNotes() + "') where appt_id=('" + updatedAppt.getApptID() + "');";
			        	    DataBase.executeUpdate(updatedApptQuery, usrname, pswd);
			        	  
				  	        for (int i=0; i<apptList.size(); i++) {
				  	    	    if (apptList.get(i).getApptID() == currentAppt.getApptID()){
				  	    	    	apptList.set(i, currentAppt);
				  	    	    }
				  	        }
			        	    System.out.println("Appointment details updated.");
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
	      case "3": //Doctor Manager
		  	    int DMchoice = doctorManagerMenu(input);
		  	    int dmID = getUserID(input, "Doctor Manager");
		  	    currentDM = getCurrentDM(dmID, dmList);
		  	    int numOfDoctors = doctorList.size();
		  	    
		  	    switch (DMchoice) {
		  	      case 1: //Create doctor user profile
		  	    	  try {
		  	    		  Doctor newDoctor = currentDM.createDoctor(numOfDoctors, input);
			  	    	  doctorList.add(newDoctor);
			  	    	  String newDoctorQuery= "insert into Doctor values('" + newDoctor.getDocID() + "', '" + newDoctor.getName() + "', '" + newDoctor.getBirthDate() + "', '" + newDoctor.getSSN() + "');";
			  	    	  DataBase.executeUpdate(newDoctorQuery,  usrname, pswd);
		  	    	  }
		  	    	  catch(Exception e) {
		  	    		  System.out.println(e);
		  	    	  }
		  	    	  
		  	    	  break;
		  	      case 2:// Edit doctor user profile
		  	    	  try {
		  	    		  docID = getUserID(input, "Doctor");
		  	    		  currentDoctor = getCurrentDoctor(docID, doctorList);
		  	    		  Doctor editedDoctor = currentDM.editProfile(currentDoctor, input);
			  	    	  String updatedDoctorQuery= "update Doctor set doctorName=('" + editedDoctor.getName() + "'), birthDate=('" + editedDoctor.getBirthDate() + "'), ssn=('" + editedDoctor.getSSN() + "') where doctor_id=('" + currentDoctor.getDocID() + "');";
			  	    	  DataBase.executeUpdate(updatedDoctorQuery,  usrname, pswd);		
			  	    	  
				  	        for (int i=0; i<doctorList.size(); i++) {
				  	    	    if (doctorList.get(i).getDocID() == currentDoctor.getDocID()){
				  	    	    	doctorList.set(i, currentDoctor);
				  	    	    }
				  	        }
			        	    System.out.println("Profile details updated.");
		  	    	  }
		  	    	  catch(Exception e) {
		  	    		  System.out.println(e);
		  	    	  }
		  	    	  break;
		  	      case 3:// Assign doctor to appointment
	  	    		  docID = getUserID(input, "Doctor");
	  	    		  currentDoctor = getCurrentDoctor(docID, doctorList);
		  	    	  userSSN = getUserSSN(input);
		  	    	  currentPatient = getCurrentPatient(userSSN, patientList);
		  	        
		  	    	  try {
		  	    		  currentAppt = currentPatient.selectAppt(apptList, input);
		  	    		  
		  	    		  Appointment updatedAppt = currentPatient.editAppt(currentAppt, input);
		  	    		  
				  	      String updatedApptQuery = "update Appointment set apptTime=('" + updatedAppt.getTime() + "'), apptDate=('" + updatedAppt.getDate() + "'), notes=('" + updatedAppt.getNotes() + "'), status=('Requested') where appt_id=('" + updatedAppt.getApptID() + "');";
		  	    		  DataBase.executeUpdate(updatedApptQuery, usrname, pswd);
		  	    		  System.out.println("Appointment details updated.");
		  	    	  }
		  	    	  catch(Exception e) {
		  	    		  System.out.println(e);
		  	    	  }
		  	        break;
		  	      default:
		  	    	System.out.println("Sorry, you did not enter a valid option. Bye.");
		  	    }
	    	  break;
	      case "4": //Room Manager
	    	  System.out.println("Would you like to:\n\t1. Assign checked in patient to a room. \n\t2. Set room availablity. \n\t3. Check room availablilty");
	    	  int RMchoice = input.nextInt();
	    	  
	    	  //Getting the Patient Manager's id
	    	  System.out.println("Please enter your Room Manager ID.");
	    	  int RMid = input.nextInt();
	    	  
	    	  //Find the ArrayList index of the patient manager
	    	  int RMindex = roomManagerIndex(roomManagerList, RMid);
	    	  
	    	  switch (RMchoice) {
	    	  	case 1:// Assign checked in patients to a room
	    	  		apptList = roomManagerList.get(RMindex).assignPatientRoom(apptList, roomList, usrname, pswd);
	    	  		//Headers for all checked-in appointments
	    	  		System.out.println();
	    			System.out.println("All checked-in appointments:");
	    			System.out.println("Appointment ID" + "\t" + " Room Number" + "\t"+ " Patient SSN" + "\t" + " Appointment Date" + "\t" + " Appointment Time" + "\t" + " Appointment Status");	    	  		
	    			
	    			//iterating through appointment ArrayList to get all checked-in appointments
	    			for (Appointment a: apptList) {	    				
	    				if(a.getStatus() == "Checked-in") {
	    					System.out.format("%s\t\t %s\t\t %s\t %s\t\t %s\t\t %s\t\n", a.getApptID(), a.getRoomNum(), a.getSSN(), a.getDate(), a.getTime(), a.getStatus());
	    				}
	    			}
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
		    	  			RoomManager RoomManagerClean = new RoomManager();
		    	  			RoomManagerClean.setRoomStatusToClean(roomNum, usrname, pswd);
		    	  			System.out.println("Room number " + roomNum + " status' has been set to Clean and Ready");
		    	  			break;
		    	  		case 2:// Assign room Occupied status
		    	  			RoomManager RoomManagerOccupied = new RoomManager();
		    	  			RoomManagerOccupied.setRoomStatusToOccupied(roomNum, usrname, pswd);
		    	  			System.out.println("Room number " + roomNum + " status' has been set to Occupied");
		    	  			break;
		    	  		case 3:// Assign room Empty and Dirty status
		    	  			RoomManager RoomManagerDirty = new RoomManager();
		    	  			RoomManagerDirty.setRoomStatusToDirty(roomNum, usrname, pswd);
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
	    	  		RoomManager RoomManager = new RoomManager();
	    	  		String roomStatus = RoomManager.getRoomStatus(roomNumber, usrname, pswd);
	    	  		
	    			//Print the status of the room
	    			System.out.println("The status of room number " + roomNumber + " is " + roomStatus);
	    	  		break;
	    	  }
	    	  break;
	      case "5": //Appointment Manager
	    	  int manID = getUserID(input, "Appointment Manager");
	    	  currentAM = getCurrentAM(manID, amList);
	    	  
	    	  int selectedInput = apptManagerMenu(input);
	    	  
	    	  switch(selectedInput) {
	    	  	case 1: //View all appts
	    	  		try {
	    	  			currentAM.viewAppts(apptList);
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		break;
	    	  	case 2: //view approved appts
	    	  		try {
	    	  			currentAM.viewApprovedAppts(apptList);
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		break;
	    	  	case 3: //view requested appts
	    	  		try {
	    	  			currentAM.viewRequestedAppts(apptList);
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		break;
	    	  	case 4: //edit appts
			  	    try {
			  	    	currentAppt = currentAM.selectAppt(apptList, input);
			  	    	
			  	    	Appointment updatedAppt = currentAM.editAppt(currentAppt, input);
			  	    	
				  	    String updatedApptQuery = "update Appointment set apptTime=('" + updatedAppt.getTime() + "'), apptDate=('" + updatedAppt.getDate() + "'), notes=('" + updatedAppt.getNotes() + "'), status=('Requested') where appt_id=('" + updatedAppt.getApptID() + "');";
		  	    		DataBase.executeUpdate(updatedApptQuery, usrname, pswd);
		  	    		for (int i=0; i<apptList.size(); i++) {
		  	    			if (apptList.get(i).getApptID() == updatedAppt.getApptID()){
		  	    				apptList.set(i, updatedAppt);
		  	    			}
		  	    		}	
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
	
				            Appointment cancelledAppt = currentPatient.cancelAppt(currentAppt, input);
				            
				            if (cancelledAppt != null){
				  	    		String cancelApptQuery = "delete from Appointment where appt_id=('" + cancelledAppt.getApptID() + "');";
				            	DataBase.executeUpdate(cancelApptQuery, usrname, pswd);
				            	apptList.remove(cancelledAppt);
				            }
				        }
				        catch (Exception e) {
				            System.out.println(e);
				        }
			  	        break;
			  	        
		  	      case 5:// Edit user profile
		  	    	  userSSN = getUserSSN(input);
			  	        switch(selectedInput) {
			  	      		case 1: //approve
			  	      			Appointment updatedAppt = currentAM.approveApptRequest(currentAppt);
			  	      			String approveApptQuery = "update Appointment set status=('Approved') where appt_id=('" + currentAppt.getApptID() + "');";
			  	      			DataBase.executeUpdate(approveApptQuery, usrname, pswd);
				  	    		for (int i=0; i<apptList.size(); i++) {
				  	    			if (apptList.get(i).getApptID() == updatedAppt.getApptID()){
				  	    				apptList.set(i, updatedAppt);
				  	    			}
				  	    		}	
			  	      			System.out.println("Appointment approved.");
			  	      			
			  	      			break;
			  	      		case 2: //deny
			  	      			Appointment updatedAppt2 = currentAM.denyApptRequest(currentAppt);
			  	      			String denyApptQuery = "update Appointment set status=('Denied') where appt_id=('" + updatedAppt2.getApptID() + "');";
			  	      			DataBase.executeUpdate(denyApptQuery, usrname, pswd);
				  	    		for (int i=0; i<apptList.size(); i++) {
				  	    			if (apptList.get(i).getApptID() == updatedAppt2.getApptID()){
				  	    				apptList.set(i, updatedAppt2);
				  	    			}
				  	    		}		
			  	      			System.out.println("Appointment denied.");
			  	      			
			  	      			break;
			  	      		default:
			  	      			System.out.println("Sorry, you did not enter a valid option. Bye.");
			  	        }
	    	  		}
	    	  		catch(Exception e) {
	    	  			System.out.println(e);
	    	  		}
	    	  		
	    	  		break;
	    	  	case 6: //schedule appt
	  	      		System.out.println("Fill out the below information to schedule an appointment.");
	  	      		userSSN = getUserSSN(input);
	  	      		currentPatient = getCurrentPatient(userSSN, patientList);

	  	      		try {		            
	  	      			Appointment newAppt = currentPatient.requestAppt(apptList, input);
	  	      			apptList.add(newAppt);
	  	      			
	  	      			String newApptQuery = "insert into Appointment values('" + newAppt.getApptID() + "', '" + newAppt.getSSN() + "', '" + newAppt.getDate() + "', '" + newAppt.getTime() + "', '" + newAppt.getNotes() + "', '" + newAppt.getStatus() + "', '" + newAppt.getPreferredDoc() + "', '" + newAppt.getRoomNum() + "');";
	  	      			DataBase.executeUpdate(newApptQuery, usrname, pswd);
		  	    		System.out.println("Appointment requested.");

	  	      		}
	  	      		catch (Exception e) {
	  	      			System.out.println(e);
	  	      		}	          
	  	      		break;
	    	  	default:
	     	    	 System.out.println("Sorry, you did not enter a valid option. Bye.");
	    	  	}
	    	  break;
	      case "6": //Patient Manager
	    	  
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
		    		  apptList = patientManagerList.get(PMIndex).checkPatientIn(usrname, pswd, apptList);
		    		  break;
		    		  
		    	  case 2://edit a patient's user profile
		    		  //System.out.println("Please enter SSN:");
		  		     // String pat_ssn = input.next();	
		  		      userSSN = getUserSSN(input);
		  	    	  currentPatient = getCurrentPatient(userSSN, patientList);
		  	        
		  	    	  try {
		  	    		  Patient updatedPatient = currentPatient.editProfile(input);
		  	    		  
				          if (updatedPatient != null){
				  	      	  String updatedPatientQuery = "update Patient set patientName=('" + updatedPatient.name + "'), birthDate=('" + updatedPatient.birthDate + "'), allergies=('" + updatedPatient.allergies + "'), preferredDoctor=('" + updatedPatient.preferredDoctor + "'), bloodtype=('" + updatedPatient.bloodType + "') where ssn=('" + updatedPatient.ssn + "');";
				        	  DataBase.executeUpdate(updatedPatientQuery, usrname, pswd);
				        	  
					  	      for (int i=0; i<patientList.size(); i++) {
					  	    	  if (patientList.get(i).getSSN().equals(updatedPatient.ssn)){
					  	    		  patientList.set(i, updatedPatient);
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
		  	          
		  	      case 6://exit patient menu
		  	    	  patFlag = 1;
		  	    	  break;
		  	    	  
		  	      default:
		  	    	  System.out.println("Sorry, you did not enter a valid option. Bye.");
		    		}
		      }
		      break;
		      case 7: //create a new patient profile
	  	    	    System.out.println("Please enter first name:");
	  		        String name = input.next();
	  		        Patient patient = new Patient();
	  		        patient.setName(name);
	  		        System.out.println("Please enter birthday in the form of YYYY-MM-DD:");
	  		        String birthDate = input.next();
	  		        patient.setBirthDate(birthDate);
	  		        System.out.println("Please enter SSN:");
	  		        String ssn = input.next();
	  		        patient.setSSN(ssn);
	  		        System.out.println("Please enter any allergies:");
	  		        String allergies = input.next();
	  		        patient.setAllergies(allergies);
	  		        System.out.println("Please enter your preferred doctor (no spaces):");
	  		        String preferredDoctor = input.next();
	  		        patient.setDoctor(preferredDoctor);
	  		        System.out.println("Please enter your blood type:");
	  		        String bloodType = input.next();
	  		        patient.setBloodType(bloodType);
	  		        String newPatientQuery= "insert into Patient values('" + patient.getName() + "', '" + patient.getBirthDate() + "', '" + patient.getSSN() + "', '" + patient.getAllergies() + "', '" + patient.getDoctor() + "', '" + patient.getBloodType() + "');";
	  			    System.out.print(newPatientQuery);
	  			    
	  			    DataBase.executeUpdate(newPatientQuery, usrname, pswd);
	  			    // Add to patient array list
	  			    patientList.add(patient);
	  			    break;
		      case 8:// Quit
		    	  mainMenuFlag = 1;
		    	  break;
		    
	  	       default:
	  	    	 System.out.println("Sorry, you did not enter a valid option.");
		    }
	    }
	     //Close objects
	     input.close();
	}
}
