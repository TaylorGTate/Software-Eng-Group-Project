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
	//declare needed variables
	static String password;
	static String username;

	static String getUsername() {
		return username;
	}
	
	static String getPassword() {
		return password;
	}
	
	static void setUsername(String u) {
		username = u;
	}
	
	static void setPassword(String p) {
		password = p;
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
		ArrayList<PatientManager> patientManagerList = new ArrayList<PatientManager>();
		String expectedAppointmentStatus = "Checked-in";
		String actualAppointmentStatus = null;
		int apptID = 0;
		
		//Get DB password and username from user
		System.out.println("Please enter your database username:");
		username = input.next();
		PatientManagerTest.setUsername(username);
		System.out.println("Please enter your database password:");
		password = input.next();
		PatientManagerTest.setPassword(password);
		
		//Make a test Patient Manager
		PatientManager testPatientManager = new PatientManager(0, "Taylor Tate", "1997-05-03");
	    patientManagerList.add(testPatientManager);
				
		//Query to create a test patient, test appointment, and test room
		String queryMan = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String queryManRoom = "insert into Room values('" + 500 + "', '" + "Clean and Ready" + "');";
		String queryManAppt = "insert into Appointment values('" + 0 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + 500 + "');";		
		String queryManApptID = "select * from appointment";
		
		//Execute query to make test patient, test appointment, and test room
		DataBase.executeUpdate(queryManRoom, username, password);
		DataBase.executeUpdate(queryMan, username, password);
		DataBase.executeUpdate(queryManAppt, username, password);
		ResultSet rs = DataBase.executeQuery(queryManApptID, username, password);
		
		//Get id of appointment
		while (rs.next()) {
			apptID = rs.getInt(1);
		}
		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream(("123-12-4321" + System.lineSeparator() + apptID).getBytes());
		System.setIn(in);
		
		//Call check patient in method
		patientManagerList.get(0).checkPatientIn(username, password);
		
		//Get new status of appointment after test patient has been checked in
		ResultSet rs1 = DataBase.executeQuery(queryManApptID, username, password);
		
		//Get id of appointment
		while (rs1.next()) {
			actualAppointmentStatus = rs1.getString(6);
		}
		
		//Check to see if statuses are equal
		assertEquals(expectedAppointmentStatus, actualAppointmentStatus);
		
		//delete for patient, appointment, and room for next test
		String patientDeleteQuery = "delete from Patient where ssn=('" + "123-12-4321" + "');";
		String apptDeleteQuery = "delete from Appointment where Pssn=('" + "123-12-4321" + "');";
		String roomDeleteQuery = "delete from Room where roomNumber=('" + "500" + "');";
		
		//Execute test room, patient, and appointment delete queries
		DataBase.executeUpdate(apptDeleteQuery, PatientManagerTest.getUsername(), PatientManagerTest.getPassword());
		DataBase.executeUpdate(patientDeleteQuery, PatientManagerTest.getUsername(), PatientManagerTest.getPassword());
		DataBase.executeUpdate(roomDeleteQuery, PatientManagerTest.getUsername(), PatientManagerTest.getPassword());
		
		//close the scanner
		input.close();
	}
	
	@Test
	void test_removePatientFromDB() throws SQLException{
		//Declare needed variables
		Scanner input = new Scanner(System.in);
		ArrayList<PatientManager> patientManagerList = new ArrayList<PatientManager>();
		String expectedResult = null;
		String actualResult = "test";
		
		//Make a test Patient Manager
		PatientManager testPatientManager = new PatientManager(0, "Taylor Tate", "1997-05-03");
		patientManagerList.add(testPatientManager);
		
		//Query to create a test patient, test appointment, and test room
		String queryManRoom = "insert into Room values('" + 500 + "', '" + "Clean and Ready" + "');";
		String queryMan = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String queryManAppt = "insert into Appointment values('" + 0 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + 500 + "');";
		
		//Execute query to make test patient, test appointment, and test room 
		DataBase.executeUpdate(queryManRoom, PatientManagerTest.getUsername(), PatientManagerTest.getPassword());
		DataBase.executeUpdate(queryMan, PatientManagerTest.getUsername(), PatientManagerTest.getPassword());
		DataBase.executeUpdate(queryManAppt, PatientManagerTest.getUsername(), PatientManagerTest.getPassword());
		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream(("123-12-4321").getBytes());
		System.setIn(in);
		
		//Call removePatientFromDB method
		patientManagerList.get(0).removePatientFromDB(username, password);
		
		//Query to remove test room from the database
		String roomDeleteQuery = "delete from Room where roomNumber=('" + "500" + "');";
		
		//Execute test room delete query
		DataBase.executeUpdate(roomDeleteQuery, username, password);
		
		//Query Database for patient and patient's appointments that should be removed
		String queryForRemovedPatient = "Select * from patient where ssn = 123-12-4321";
		String queryForRemovedAppt = "Select * from appointment where pssn = 123-12-4321";

				
		//Execute query to see if patient and patient's appointments has been removed
		ResultSet rs = DataBase.executeQuery(queryForRemovedPatient, username, password);
		ResultSet rs1 = DataBase.executeQuery(queryForRemovedAppt, username, password);

		
		//See if ResultSet returns anything
		if(rs.next() == false) {
			actualResult = null;
		}
		
		if(rs1.next() == false) {
			actualResult = null;
		}
		
		//Check to see if patient was in database
		assertEquals(expectedResult, actualResult);
		
		//close the scanner
		input.close();
	}
}
