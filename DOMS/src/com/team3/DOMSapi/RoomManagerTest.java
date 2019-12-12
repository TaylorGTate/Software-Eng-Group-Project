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
		ArrayList<Room> rList = new ArrayList<Room>();
		String expectedRoomStatus = "Clean and Ready";
		String actualRoomStatus = null;
		
		//create a room manager
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		
		//create a test room
		Room room = new Room (200, "Clean and Ready");
		
		//insert room into ArrayList
		rList.add(room);
		
		//Query to insert room number 20
		String insertRoomQuery = "insert into Room values ('200', 'Clean and Ready')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Getting the actual room status
		actualRoomStatus = roomManager.getRoomStatus(200, rList, username, password);
		
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
		ArrayList<Room> rList = new ArrayList<Room>();
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		String expectedRoomStatus = "Clean and Ready";
		
		//create a test room
		Room room = new Room (200, "Empty and Dirty");
		
		//insert room into ArrayList
		rList.add(room);
		
		//Query to insert room number 200
		String insertRoomQuery = "insert into Room values ('200', 'Empty and Dirty')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Assign room number 200 the status of clean and ready
		roomManager.setRoomStatusToClean(rList, 200, username, password);
		
		//Get the actual room status of room number 200
		String actualRoomStatus = roomManager.getRoomStatus(200, rList, username, password);
		
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
		ArrayList<Room> rList = new ArrayList<Room>();
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		Scanner input = new Scanner(System.in);
		String expectedRoomStatus = "Occupied";
		
		//create a test room
		Room room = new Room (200, "Clean and Ready");
		
		//insert room into ArrayList
		rList.add(room);
		
		//Query to insert room number 200
		String insertRoomQuery = "insert into Room values ('200', 'Clean and Ready')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Assign room number 200 the status of clean and ready
		roomManager.setRoomStatusToOccupied(rList, 200, username, password);
		
		//Get the actual room status of room number 200
		String actualRoomStatus = roomManager.getRoomStatus(200, rList, username, password);
		
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
		ArrayList<Room> rList = new ArrayList<Room>();
		RoomManager roomManager = new RoomManager (1, "Amanda", "1996-4-14");
		Scanner input = new Scanner(System.in);
		String expectedRoomStatus = "Empty and Dirty";
		
		//create a test room
		Room room = new Room (200, "Clean and Ready");
				
		//insert room into ArrayList
		rList.add(room);
		
		//Query to insert room number 200
		String insertRoomQuery = "insert into Room values (200, 'Occupied')";
		
		//Execute query to put room into database
		DataBase.executeUpdate(insertRoomQuery, username, password);
		
		//Assign room number 200 the status of clean and ready
		roomManager.setRoomStatusToDirty(rList, 200, username, password);
		
		//Get the actual room status of room number 200
		String actualRoomStatus = roomManager.getRoomStatus(200, rList, username, password);
		
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
		
		//declare needed variables
		int actualAppointmentID = 0;
		int expectedAppointmentID = 200;
		int expectedAppointmentRoom = 200;
		int actualAppointmentRoom = 0;
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Integer> results = new ArrayList<Integer>();

		Scanner input = null;
		
		//create a test room
		Room room = new Room (200, "Clean and Ready");
		
		//create a test appointment
		Appointment appt = new Appointment (200, "123-12-4321", "2019-12-14", "12:30:00", "none", "Approved", "Dr.Jones", 0);
				
		//insert room and appt into ArrayList
		roomList.add(room);
		apptList.add(appt);
		
		//Query to create a test patient and test appointment
		String testPatient = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String testAppt = "insert into appointment values('" + 200 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Checked-in" + "', '" + "Dr.Jones" + "', '" + 200 + "');";
		String testRoom = "insert into room values('" + 200 + "', '" + "Clean and Ready" + "');";
		
		//Execute query to make test patient and test appointment 
		DataBase.executeUpdate(testPatient, username, password);
		DataBase.executeUpdate(testRoom, username, password);		
		DataBase.executeUpdate(testAppt, username, password);
		
		//ByteStream array to simulate user input
		ByteArrayInputStream in = new ByteArrayInputStream((200 + System.lineSeparator() + 200 + System.lineSeparator()).getBytes());
		input = new Scanner(in);
		
		//Create a test Patient Manager
	    RoomManager testRoomManager = new RoomManager(4, "Taylor Tate", "1997-05-03");

		//Call check patient in method
		results = testRoomManager.assignPatientRoom(apptList, roomList, username, password);
		
		//Test to see if method returns correct appt id and room number 
		actualAppointmentRoom = results.get(1);
		actualAppointmentID = results.get(0);
	
		//Check to see if statuses are equal
		assertEquals(expectedAppointmentRoom, actualAppointmentRoom);
		assertEquals(expectedAppointmentID, actualAppointmentID);

		
		//delete for patient, appointment, and room for next test
		String DeleteQuery1 = "delete from Patient where ssn=('" + "123-12-4321" + "');";
		String DeleteQuery2 = "delete from Appointment where Pssn=('" + "123-12-4321" + "');";
		String DeleteQuery3 = "delete from Room where roomNumber=('" + 200 + "');";

		DataBase.executeUpdate(DeleteQuery2, username, password);
		DataBase.executeUpdate(DeleteQuery1, username, password);
		DataBase.executeUpdate(DeleteQuery3, username, password);
	}
}
