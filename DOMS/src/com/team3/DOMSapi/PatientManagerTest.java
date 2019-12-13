package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PatientManagerTest {
	
	
	
	public static String setUsername() {
		Scanner input =new Scanner(System.in);
		String username = null;

		//get db username
		System.out.println("What is your database username?");
		username = input.nextLine();
		
		return username;
	}
	
	public static String setPassword() {
		Scanner input =new Scanner(System.in);
		String password = null;

		//get db username
		System.out.println("What is your database password?");
		password = input.nextLine();
		
		return password;
		
	}
	
	
	@Test
	void test_PatientManager() {
		int expectedID = 1;
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		int actualID = p.getID();
		assertEquals(expectedID, actualID);
	}
	@Test
	void test_getID() {
		int expectedID = 1;
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		int actualID = p.getID();
		assertEquals(expectedID, actualID);
	}
	@Test
	void test_setID() {
		int expectedID = 2;
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		p.setID(expectedID);
		assertEquals(expectedID, p.getID());
	}
	@Test
	void test_getName() {
		String expectedName = "Mandy Seasholtz";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		String actualName = p.getName();
		assertEquals(expectedName, actualName);
	}
	@Test
	void test_setName() {
		String expectedName = "Cindy Jones";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		p.setName(expectedName);
		assertEquals(expectedName, p.getName());
	}
	@Test
	void test_getBirthDate() {
		String expectedBD = "1998-01-01";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		String actualBD = p.getBirthDate();
		assertEquals(expectedBD, actualBD);
	}
	@Test
	void test_setBirthDate() {
		String expectedBD = "1998-02-02";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		p.setBirthDate(expectedBD);
		assertEquals(expectedBD, p.getBirthDate());
	}

	@Test
	void test_checkPatientIn() throws SQLException {
		
		//declare variables 
		Scanner input = new Scanner(System.in);
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		String expectedAppointmentStatus = "Checked-in";
		String actualAppointmentStatus = null;
		String usename =null, pswrd = null;
		
		//create a new Appointment object and add it to the appointment ArrayList
		Appointment testApptArrayList = new Appointment (500, "123-12-4321", "2000-12-12", "12:30:30", "none", "none", "Dr. Smith", 500);
		apptList.add(testApptArrayList);
		
		//get db username
		usename = PatientManagerTest.setUsername();
		
		//get db password
		pswrd = PatientManagerTest.setPassword();
		
		//Make a test Patient Manager
		PatientManager testPatientManager = new PatientManager(0, "Taylor Tate", "1997-05-03");
				
		//Query to create a test patient, test appointment, and test room
		String testPatient = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String testRoom = "insert into Room values('" + 500 + "', '" + "Clean and Ready" + "');";
		String testAppt = "insert into Appointment values('" + 500 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none"  + "', '" + "none" + "', '" + "Dr. Smith" + "', '" + 500 + "');";
		String selectAllAppt = "select * from appointment";
		
		//Execute query to make test patient, test appointment, and test room
		DataBase.executeUpdate(testPatient, usename, pswrd);
		DataBase.executeUpdate(testRoom, usename, pswrd);
		DataBase.executeUpdate(testAppt, usename, pswrd);

		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream(("123-12-4321" + System.lineSeparator() + 500).getBytes());
		System.setIn(in);
		
		//Call check patient in method
		apptList = testPatientManager.checkPatientIn(usename, pswrd, apptList);
		
		//Get new status of appointment after test patient has been checked in
		ResultSet rs1 = DataBase.executeQuery(selectAllAppt, usename, pswrd);
		
		//Get id of appointment
		while (rs1.next()) {
			if (rs1.getInt(1) == 500) {
				actualAppointmentStatus = rs1.getString(6);
			}
		}
		
		//Iterate through the Appointment ArrayList
  		for (Appointment a: apptList) {
  			//Filter all the appointments against the test Appointment ID and get the new status of the test appointment
  			if(a.getApptID() == 500) {
  				actualAppointmentStatus = a.getStatus();
  			}
	  	}
  		
		//Check to see if statuses are equal
		assertEquals(expectedAppointmentStatus, actualAppointmentStatus);
		
		//delete for patient, appointment, and room for next test
		String patientDeleteQuery = "delete from Patient where ssn=('" + "123-12-4321" + "');";
		String apptDeleteQuery = "delete from Appointment where Pssn=('" + "123-12-4321" + "');";
		String roomDeleteQuery = "delete from Room where roomNumber=('" + "500" + "');";
		
		//Execute test room, patient, and appointment delete queries
		DataBase.executeUpdate(apptDeleteQuery, usename, pswrd);
		DataBase.executeUpdate(patientDeleteQuery, usename, pswrd);
		DataBase.executeUpdate(roomDeleteQuery, usename, pswrd);
		
		//close the scanner
		//input.close();
	}
	
	/*@Test
	void test_removePatientFromDB() throws SQLException{
		//Declare needed variables
		Scanner input = new Scanner(System.in);
		ArrayList<Appointment> aList = new ArrayList<Appointment>();
		ArrayList<Patient> pList = new ArrayList<Patient>();
		String expectedResultDB = null;
		String actualResultDB = "test";
		String expectedResultObj = "123-12-4321";
		String actualResultObj = null;
		String usename =null, pswrd = null;

		
		
		
		//Make test patient and test appointment objects and add them to the ArrayList
		Appointment testApptArrayList = new Appointment (500, "123-12-4321", "2000-12-12", "12:30:30", "none", "Approved", "Dr. Smith", 500);
		aList.add(testApptArrayList);
		Patient testPatient = new Patient (500, "Taylor", "2000-12-12", "123-12-4321", "none", "none", "A+");
		pList.add(testPatient);
		
		//get db username
		usename = PatientManagerTest.setUsername();
		
		//get db password
		pswrd = PatientManagerTest.setPassword();

		
		//Make a test Patient Manager
		PatientManager testPatientManager = new PatientManager(0, "Taylor Tate", "1997-05-03");
		
		//Query to create a test patient, test appointment, and test room
		String testRoom = "insert into Room values('" + 500 + "', '" + "Clean and Ready" + "');";
		String testPatientQuery = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String testApptQuery = "insert into Appointment values('" + 500 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + "Dr. Smith" + "', '" + 500 + "');";
		
		//Execute query to make test patient, test appointment, and test room 
		DataBase.executeUpdate(testRoom, usename, pswrd);
		DataBase.executeUpdate(testPatientQuery, usename, pswrd);
		DataBase.executeUpdate(testApptQuery, usename, pswrd);
		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream(("123-12-4321").getBytes());
		System.setIn(in);
		
		//Call removePatientFromDB method
		actualResultObj = testPatientManager.removePatientFromDB(usename, pswrd, pList);
		
		//Query to remove test room from the database
		String roomDeleteQuery = "delete from Room where roomNumber=('" + "500" + "');";
		
		//Execute test room delete query
		DataBase.executeUpdate(roomDeleteQuery, usename, pswrd);
		
		//Query Database for patient and patient's appointments that should be removed
		String queryForRemovedPatient = "Select * from patient where ssn = 123-12-4321";
		String queryForRemovedAppt = "Select * from appointment where pssn = 123-12-4321";

				
		//Execute query to see if patient and patient's appointments has been removed
		ResultSet rs = DataBase.executeQuery(queryForRemovedPatient, usename, pswrd);
		ResultSet rs1 = DataBase.executeQuery(queryForRemovedAppt, usename, pswrd);

		
		//See if ResultSet returns anything
		if(rs.next() == false) {
			actualResultDB = null;
		}
		
		if(rs1.next() == false) {
			actualResultDB = null;
		}
		
		//Check to see if patient was in database
		assertEquals(expectedResultDB, actualResultDB);
		
		//Check to see if patient object's
		assertEquals(expectedResultObj, actualResultObj);
		
		
		
		//close the scanner
		input.close();
	}*/
}
