package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class RoomManagerTest {

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
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}
	
	@Test
	void testSetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		roomManager.setBirthday("1997-03-05");
		String expectedBirthday = "1997-03-05";
		String actualBirthday = roomManager.getBirthday();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testSetName() {
		String expectedName = "Mitchell";
		RoomManager roomManager = new RoomManager (1, "Taylor", "1996-4-14");		
		roomManager.setName("Mitchell");
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");

		String expectedBirthday = "1996-4-14";
		String actualBirthday = roomManager.getBirthday();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testGetRoomStatus() {
		Room room = new Room (1, "Clean and Ready");
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedRoomStatus = "Clean and Ready";
		String actualRoomStatus = roomManager.getRoomStatus(room);
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

	@Test
	void testSetRoomStatusToClean() {
		Room room = new Room (1, "Empty and Dirty");
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		roomManager.setRoomStatusToClean(room);
		String expectedRoomStatus = "Clean and Ready";
		String actualRoomStatus = roomManager.getRoomStatus(room);
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

	@Test
	void testSetRoomStatusToOccupied() {
		Room room = new Room (1, "Clean and Ready");
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		roomManager.setRoomStatusToOccupied(room);
		String expectedRoomStatus = "Occupied";
		String actualRoomStatus = roomManager.getRoomStatus(room);
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

	@Test
	void testSetRoomStatusToDirty() {
		Room room = new Room (1, "Occupied");
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		roomManager.setRoomStatusToDirty(room);
		String expectedRoomStatus = "Empty and Dirty";
		String actualRoomStatus = roomManager.getRoomStatus(room);
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}
	
	@Test
	void testassignPatientRoom() throws SQLException {
		
		//declare variables 
		String username = "root";
		String password = "toor";
		String expectedAppointmentRoom = "8";
		String actualAppointmentRoom = null;
		int apptID = 0;
				
		//Query to create a test patient and test appointment
		String queryMan = "insert into Patient values('" + "Taylor" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		String queryManAppt = "insert into appointment values('" + 0 + "', '" + "123-12-4321" + "', '" + "2000-12-12" + "', '" + "12:30:00" + "', '" + "none" + "', '" + "Approved" + "', '" + 9 + "');";
		String queryManFakeRoom = "insert into room values('" + 9 + "', '" + "Clean and Ready" + "');";
		String queryManRoom = "insert into room values('" + 8 + "', '" + "Clean and Ready" + "');";
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
		
		//Call check patient in method
		RoomManager.assignPatientRoom();
		
		//Get new status of appointment after test patient has been checked in
		ResultSet rs1 = DataBase.executeQuery(queryManApptID, username, password);
		
		//Get id of appointment
		while (rs1.next()) {
			actualAppointmentRoom = rs1.getString(7);
		}
		
		//Check to see if statuses are equal
		assertEquals(expectedAppointmentRoom, actualAppointmentRoom);
		
		//delete for patient, appointment, and room for next test
		String DeleteQuery = "delete from Patient where ssn=('" + "123-12-4321" + "');";
		String DeleteQuery2 = "delete from Appointment where Pssn=('" + "123-12-4321" + "');";
		String DeleteQuery3 = "delete from Room where roomNumber=('" + "8" + "');";
		String DeleteQuery4 = "delete from Room where roomNumber=('" + "9" + "');";

		DataBase.executeUpdate(DeleteQuery2, username, password);
		DataBase.executeUpdate(DeleteQuery, username, password);
		DataBase.executeUpdate(DeleteQuery3, username, password);
		DataBase.executeUpdate(DeleteQuery4, username, password);

	}

}
