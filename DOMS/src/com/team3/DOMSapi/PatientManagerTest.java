package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class PatientManagerTest {

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
		String username = "root";
		String password = "toor";
		String expectedAppointmentStatus = "Checked-in";
		String actualAppointmentStatus = null;
		int apptID = 0;
				
		//Query to create a test patient and test appointment
		String queryMan = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String queryManAppt = "insert into Appointment values('" + 0 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + 4 + "');";
		String queryManApptID = "select * from appointment";
		
		//Execute query to make test patient and test appointment 
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
		PatientManager.checkPatientIn();
		
		//Get new status of appointment after test patient has been checked in
		ResultSet rs1 = DataBase.executeQuery(queryManApptID, username, password);
		
		//Get id of appointment
		while (rs1.next()) {
			actualAppointmentStatus = rs1.getString(6);
		}
		
		//Check to see if statuses are equal
		assertEquals(expectedAppointmentStatus, actualAppointmentStatus);
		
		//delete for patient next test
		String deadDeleteQuery = "delete from Patient where ssn=('" + "123-12-4321" + "');";
		String deadDeleteQuery2 = "delete from Appointment where Pssn=('" + "123-12-4321" + "');";

		DataBase.executeUpdate(deadDeleteQuery2, username, password);
		DataBase.executeUpdate(deadDeleteQuery, username, password);
	}
	
	@Test
	void test_removePatientFromDB() throws SQLException{
		//Declare needed variables
		String username = "root";
		String password = "toor";
		String expectedResult = null;
		String actualResult = "test";
		
		//Query to create a test patient and test appointment
		String queryMan = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String queryManAppt = "insert into Appointment values('" + 0 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + 4 + "');";
		
		//Execute query to make test patient and test appointment 
		DataBase.executeUpdate(queryMan, username, password);
		DataBase.executeUpdate(queryManAppt, username, password);
		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream(("123-12-4321").getBytes());
		System.setIn(in);
		
		//Call removePatientFromDB method
		PatientManager.removePatientFromDB();
		
		//Query Database for patient that should be removed
		String queryForRemovedPatient = "Select * from patient where ssn = 123-12-4321";
				
		//Execute query to see if patient has been removed
		ResultSet rs = DataBase.executeQuery(queryForRemovedPatient, username, password);
		
		//See if ResultSet returns anything
		if(rs.next() == false) {
			actualResult = null;
		}		
		
		//Check to see if patient was in database
		assertEquals(expectedResult, actualResult);
	}
}
