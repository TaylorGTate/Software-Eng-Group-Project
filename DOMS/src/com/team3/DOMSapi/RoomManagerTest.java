package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class RoomManagerTest {
	String username = "root";
	String password = "toor";
	
	@Test
	void testRoomManager() {	
	RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
			String expectedName = "Mitchell";
			String actualName = roomManager.getName();
			assertEquals(expectedName, actualName);
	}
	
	@Test
	void testGetID() {
		int expectedID = 1;
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		int actualID = roomManager.getID();
		assertEquals(expectedID, actualID);
	}

	@Test
	void testSetID() {
		int expectedID = 1;
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		int actualID = roomManager.getID();
		assertEquals(expectedID, actualID);
	}

	@Test
	void testGetName() {
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		String expectedName = "Amanda";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}
	
	@Test
	void testSetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		roomManager.setBirthday("1997-03-05");
		String expectedBirthday = "1997-03-05";
		String actualBirthday = roomManager.getBirthday();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testSetName() {
		String expectedName = "Amanda";
		RoomManager roomManager = new RoomManager (1, "Taylor", "1996-4-14");		
		roomManager.setName("Amanda");
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");

		String expectedBirthday = "1996-4-14";
		String actualBirthday = roomManager.getBirthday();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testGetRoomStatus() throws SQLException {
		
		//Declare needed variables
		String expectedRoomStatus = "Clean and Ready";
		String actualRoomStatus = null;
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		
		//Query to insert room number 20
		String insertRoomQuery = "insert into Room values ('200', 'Clean and Ready')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Getting the actual room status
		actualRoomStatus = roomManager.getRoomStatus("200", username, password);
		
		//Compare actual result and expected result
		assertEquals(expectedRoomStatus, actualRoomStatus);
		
		//Delete room entry 
		String deleteRoomQuery = "delete from room where roomNumber = '200'";
		
		//Execute delete query 
		DataBase.executeUpdate(deleteRoomQuery, username, password);
	}

	@Test
	void testSetRoomStatusToClean() throws SQLException {
		
		//Declare needed variables
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		String expectedRoomStatus = "Clean and Ready";
		
		//Query to insert room number 200
		String insertRoomQuery = "insert into Room values ('200', 'Empty and Dirty')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Assign room number 200 the status of clean and ready
		roomManager.setRoomStatusToClean("200", username, password);
		
		//Get the actual room status of room number 200
		String actualRoomStatus = roomManager.getRoomStatus("200", username, password);
		
		//Compare the two statuses 
		assertEquals(expectedRoomStatus, actualRoomStatus);
		
		//Delete room entry 
		String deleteRoomQuery = "delete from room where roomNumber = '200'";
		
		//Execute delete query 
		DataBase.executeUpdate(deleteRoomQuery, username, password);
	}

	@Test
	void testSetRoomStatusToOccupied() throws SQLException {
		
		//Declare needed variables
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		Scanner input = new Scanner(System.in);
		String expectedRoomStatus = "Occupied";
		
		//Query to insert room number 200
		String insertRoomQuery = "insert into Room values ('200', 'Clean and Ready')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Assign room number 200 the status of clean and ready
		roomManager.setRoomStatusToOccupied("200", username, password);
		
		//Get the actual room status of room number 200
		String actualRoomStatus = roomManager.getRoomStatus("200", username, password);
		
		//Compare the two statuses 
		assertEquals(expectedRoomStatus, actualRoomStatus);
		
		//Close scanner
		input.close();
		
		//Delete room entry 
		String deleteRoomQuery = "delete from room where roomNumber = '200'";
		
		//Execute delete query 
		DataBase.executeUpdate(deleteRoomQuery, username, password);
	}

	@Test
	void testSetRoomStatusToDirty() throws SQLException {
		
		//Declare needed variables
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		Scanner input = new Scanner(System.in);
		String expectedRoomStatus = "Empty and Dirty";
		
		//Query to insert room number 200
		String insertRoomQuery = "insert into Room values (200, 'Occupied')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Assign room number 200 the status of clean and ready
		roomManager.setRoomStatusToDirty("200", username, password);
		
		//Get the actual room status of room number 200
		String actualRoomStatus = roomManager.getRoomStatus("200", username, password);
		
		//Compare the two statuses 
		assertEquals(expectedRoomStatus, actualRoomStatus);
		
		//Close scanner
		input.close();
		
		//Delete room entry 
		String deleteRoomQuery = "delete from room where roomNumber = '200'";
		
		//Execute delete query 
		DataBase.executeUpdate(deleteRoomQuery, username, password);
	}
	
	@Test
	void testAssignPatientRoom() throws SQLException {
		
		//declare variables 
		String username = "root";
		String password = "toor";
		String expectedAppointmentRoom = "8";
		String actualAppointmentRoom = null;
		int apptID = 0;
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		ArrayList<Room> roomList = new ArrayList<Room>();
		
		//Query to create a test patient and test appointment
		String queryMan = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4328" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String queryManAppt = "insert into appointment values('" + 4 + "', '" + "123-12-4328" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + "Dr.Jones" + "', '" + 6 + "');";
		String queryManFakeRoom = "insert into room values('" + 6 + "', '" + "Clean and Ready" + "');";
		String queryManRoom = "insert into room values('" + 5 + "', '" + "Clean and Ready" + "');";
		String queryManApptID = "select * from appointment";
		
		//Execute query to make test patient and test appointment 
		DataBase.executeUpdate(queryMan, username, password);
		DataBase.executeUpdate(queryManRoom, username, password);
		DataBase.executeUpdate(queryManFakeRoom, username, password);
		DataBase.executeUpdate(queryManAppt, username, password);
		ResultSet rs = DataBase.executeQuery(queryManApptID, username, password);
		
		//Get id of appointment
		while (rs.next()) {
			apptID = rs.getInt(1);
		}
		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream((apptID + System.lineSeparator() + 8).getBytes());
		System.setIn(in);
		
		//Create a test Patient Manager
	    RoomManager testRoomManager = new RoomManager(4, "Taylor Tate", "1997-05-03");

		//Call check patient in method
		testRoomManager.assignPatientRoom(apptList, roomList, username, password);
		
		//Get new status of appointment after test patient has been checked in
		ResultSet rs1 = DataBase.executeQuery(queryManApptID, username, password);
		
		//Get id of appointment
		while (rs1.next()) {
			actualAppointmentRoom = rs1.getString(8);
		}
	
		//Check to see if statuses are equal
		assertEquals(expectedAppointmentRoom, actualAppointmentRoom);
		
		//delete for patient, appointment, and room for next test
		String DeleteQuery = "delete from Patient where ssn=('" + "123-12-4328" + "');";
		String DeleteQuery2 = "delete from Appointment where Pssn=('" + "123-12-4328" + "');";
		String DeleteQuery3 = "delete from Room where roomNumber=('" + "6" + "');";
		String DeleteQuery4 = "delete from Room where roomNumber=('" + "5" + "');";

		DataBase.executeUpdate(DeleteQuery2, username, password);
		DataBase.executeUpdate(DeleteQuery, username, password);
		DataBase.executeUpdate(DeleteQuery3, username, password);
		DataBase.executeUpdate(DeleteQuery4, username, password);
	}
}
