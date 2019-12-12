package com.team3.DOMSapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Represents a doctor's office database.
 */
public class DataBase{
		
	private String username;
	private String password;

	public DataBase(String username, String password) {
		this.username = username;
		this.password = password;
	}
		
  	/**
	   * Executes the query in the database.
	   * @param Query Database Query to be executed.
	   * @param usrname Database connection user name.
	   * @param pswd Database connection password.
	   */
  
	public static ResultSet executeUpdate(String Query, String usrname, String pswd) throws SQLException {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		mystmt.executeUpdate(Query);
		return null;
	}
	
	public static ResultSet executeQuery(String Query, String usrname, String pswd) throws SQLException {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		return mystmt.executeQuery(Query);
	}
	
<<<<<<< HEAD
	/*public static int executeQueryCount(String Query, String usrname, String pswd) throws SQLException {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		ResultSet re = mystmt.executeQuery(Query);
		System.out.print(re);
		return Integer.parseInt(re.toString());*/
=======
	public static ArrayList<Patient> populatePatientAL(ArrayList<Patient> pList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the patient database table
	  	String patientInfo = ("SELECT * from Patient");
	  	//ResultSet of all the patients information
	  	ResultSet rs = DataBase.executeQuery(patientInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		//Create Patient Object
			Patient p = new Patient();
			//add new object to ArrayList
			pList.add(p);
	  		//Get patients' info from DB table
	  		String patientName = rs.getString("patientName");
	  		String ssn= rs.getString("ssn");
	  		String birthDate = rs.getString("birthDate");
	  		String allergies = rs.getString("allergies");
	  		String preferredDoctor = rs.getString("preferredDoctor");
	  		String bloodType = rs.getString("bloodtype");

	  		//Add patients' info to the ArrayList
	  		pList.get(i).setName(patientName);
	  		pList.get(i).setSSN(ssn);
	  		pList.get(i).setBirthDate(birthDate);
	  		pList.get(i).setAllergies(allergies);
	  		pList.get(i).setDoctor(preferredDoctor);
	  		pList.get(i).setBloodType(bloodType);

	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated Patient ArrayList
		return pList;
	}
	
	public static ArrayList<Doctor> populateDoctorAL(ArrayList<Doctor> dList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the doctor database table
	  	String doctorInfo = ("SELECT * from Doctor");
	  	//ResultSet of all the doctors' information
	  	ResultSet rs = DataBase.executeQuery(doctorInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		//Create doctor Object
			Doctor d = new Doctor();
			//add new object to ArrayList
			dList.add(d);
	  		
	  		//Get doctors' info from DB table
	  		String doctorName = rs.getString("doctorName");
	  		String ssn= rs.getString("ssn");
	  		String birthDate = rs.getString("birthDate");
	  		int docID = rs.getInt("doctor_id");

	  		//Add doctors' info to the ArrayList
	  		dList.get(i).setName(doctorName);
	  		dList.get(i).setSSN(ssn);
	  		dList.get(i).setBirthDate(birthDate);
	  		dList.get(i).setDocID(docID);

	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated Doctor ArrayList
		return dList;
	}
	
	public static ArrayList<Appointment> populateApptAL(ArrayList<Appointment> aList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the appt database table
	  	String apptInfo = ("SELECT * from Appointment");
	  	//ResultSet of all the appts' information
	  	ResultSet rs = DataBase.executeQuery(apptInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
		  	//Create appt Object
			Appointment appt = new Appointment();
			//add new object to ArrayList
			aList.add(appt);
		  		
	  		//Get appts' info from DB table
	  		int apptID = rs.getInt("appt_id");
	  		int roomNumber = rs.getInt("roomNum");
	  		String ssn = rs.getString("Pssn");
	  		String apptDate = rs.getString("apptDate");
	  		String apptTime = rs.getString("apptTime");
	  		String notes = rs.getString("notes");
	  		String status = rs.getString("status");
	
	  		//Add appts' info to the ArrayList
	  		aList.get(i).setApptID(apptID);
	  		aList.get(i).setRoomNum(roomNumber);
	  		aList.get(i).setSSN(ssn);
	  		aList.get(i).setDate(apptDate);
	  		aList.get(i).setTime(apptTime);
	  		aList.get(i).setNotes(notes);
	  		aList.get(i).setStatus(status);
	
	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated appt ArrayList
		return aList;
	}
	
	public static ArrayList<PatientManager> populatePMAL(ArrayList<PatientManager> PMList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the PM database table
	  	String patientManagerInfo = ("SELECT * from PatientManager");
	  	//ResultSet of all the PM information
	  	ResultSet rs = DataBase.executeQuery(patientManagerInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		//Create PatientManager Object
			PatientManager pm = new PatientManager();
			//add new object to ArrayList
			PMList.add(pm);
	  		
	  		//Get PM info from DB table
	  		int PMID = rs.getInt("manager_id");
	  		String PMName = rs.getString("name");
	  		String birthDate = rs.getString("birthDate");

	  		//Add PM info to the ArrayList
	  		PMList.get(i).setID(PMID);
	  		PMList.get(i).setName(PMName);
	  		PMList.get(i).setBirthDate(birthDate);
	  		

	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated PM ArrayList
		return PMList;
	}
	
	public static ArrayList<DoctorManager> populateDMAL(ArrayList<DoctorManager> DMList, String password, String username) throws SQLException {		
		//Declare needed variables
		int i = 0;
	  	//Query the DM database table
	  	String doctorManagerInfo = ("SELECT * from DoctorManager");
	  	//ResultSet of all the DM information
	  	ResultSet rs = DataBase.executeQuery(doctorManagerInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  	    //Create DoctorManager Object
			DoctorManager dm = new DoctorManager();
			//add new object to ArrayList
			DMList.add(dm);
	  		
	  		//Get DM info from DB table
	  		int DMID = rs.getInt("manager_id");
	  		String DMName = rs.getString("name");
	  		String birthDate = rs.getString("birthDate");

	  		//Add DM info to the ArrayList
	  		DMList.get(i).setID(DMID);
	  		DMList.get(i).setName(DMName);
	  		DMList.get(i).setBirthDate(birthDate);
	  		
	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated DM ArrayList
		return DMList;
	}
	
	public static ArrayList<AppointmentManager> populateAMAL(ArrayList<AppointmentManager> AMList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the AM database table
	  	String appointmentManagerInfo = ("SELECT * from AppointmentManager");
	  	//ResultSet of all the AM information
	  	ResultSet rs = DataBase.executeQuery(appointmentManagerInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		//Create appt manager Object
			AppointmentManager am = new AppointmentManager();
			//add new object to ArrayList
			AMList.add(am);
	  		
	  		//Get AM info from DB table
	  		int AMID = rs.getInt("manager_id");
	  		String AMName = rs.getString("name");
	  		String birthDate = rs.getString("birthDate");

	  		//Add AM info to the ArrayList
	  		AMList.get(i).setManID(AMID);
	  		AMList.get(i).setName(AMName);
	  		AMList.get(i).setBirthDate(birthDate);
	  		
	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated AM ArrayList
		return AMList;
	}
	
	public static ArrayList<Room> populateRAL(ArrayList<Room> RList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the room database table
	  	String roomInfo = ("SELECT * from Room");
	  	//ResultSet of all the room information
	  	ResultSet rs = DataBase.executeQuery(roomInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		//Create room Object
			Room room = new Room();
			//add new object to ArrayList
			RList.add(room);
	  		
	  		//Get rooms' info from DB table
	  		int roomNumber = rs.getInt("roomNumber");
	  		String avaliable = rs.getString("avaliable");

	  		//Add rooms' info to the ArrayList
	  		RList.get(i).setRoomNumber(roomNumber);
	  		RList.get(i).setAvaliablity(avaliable);
	  		
	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated room ArrayList
		return RList;
	}
	
	public static ArrayList<RoomManager> populateRMAL(ArrayList<RoomManager> RMList, String password, String username) throws SQLException {
		//Declare needed variables
		int i = 0;
	  	//Query the RM database table
	  	String roomManagerInfo = ("SELECT * from RoomManager");
	  	//ResultSet of all the RM information
	  	ResultSet rs = DataBase.executeQuery(roomManagerInfo, username, password);
	  	//Iterate through the ResultSet
	  	while(rs.next()) {
	  		//Create Room Manager Object
			RoomManager rm = new RoomManager();
			//add new object to ArrayList
			RMList.add(rm);
	  		
	  		//Get RM info from DB table
	  		int RMID = rs.getInt("manager_id");
	  		String RMName = rs.getString("name");
	  		String birthDate = rs.getString("birthDate");

	  		//Add RM info to the ArrayList
	  		RMList.get(i).setID(RMID);
	  		RMList.get(i).setName(RMName);
	  		RMList.get(i).setBirthday(birthDate);
	  		
	  		//increase i by 1
	  		i++;
	  	}
		
	  	//return populated RM ArrayList
		return RMList;
>>>>>>> a3b849640ebe5331ad193dd0449a0dc2d68d0f2f
	}
}

