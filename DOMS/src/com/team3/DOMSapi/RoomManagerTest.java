package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

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
	void testSetName() {
		String expectedName = "Mitchell";
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");		
		RoomManager.setName("Mitchell");
		assertEquals(expectedName, RoomManager.getName());
	}

	@Test
	void testSetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetRoomStatus() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetRoomStatusToClean() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetRoomStatusToOccupied() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetRoomStatusToDirty() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedName = "Mitchell";
		String actualName = roomManager.getName();
		assertEquals(expectedName, actualName);
	}

}
