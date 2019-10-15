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
	void testSetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedBirthday = "1996-4-14";
		String actualBirthday = roomManager.getBirthday();
		assertEquals(expectedBirthday, actualBirthday);
	}
	
	//****************************************************
	//****************************************************
	//Methods below this line do not run correctly

	@Test
	void testSetName() {
		String expectedName = "Mitchell";
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");		
		RoomManager.setName("Mitchell");
		assertEquals(expectedName, RoomManager.getName());
	}
	

	@Test
	void testGetBirthday() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedBirthDay = "1996-4-14";
		String actualBirthday = roomManager.setBirthday["1996-4-14"]();
		assertEquals(expectedBirthDay, actualBirthday);
	}

	@Test
	void testGetRoomStatus() {
		room.avaliable = status[1];
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedRoomStatus = roomManager.getRoomStatus(1);
		String actualRoomStatus = roomManager.getRoomStatus();
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

	@Test
	void testSetRoomStatusToClean() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedRoomStatus = "Clean";
		String actualRoomStatus = roomManager.getRoomStatus(Room room();
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

	@Test
	void testSetRoomStatusToOccupied() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedRoomStatus = "Occupied";
		String actualRoomStatus = roomManager.setRoomStatus[2]();
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

	@Test
	void testSetRoomStatusToDirty() {
		RoomManager roomManager = new RoomManager (1, "Mitchell", "1996-4-14");
		String expectedRoomStatus = "Dirty";
		String actualRoomStatus = roomManager.setRoomStatus[3]();
		assertEquals(expectedRoomStatus, actualRoomStatus);
	}

}
