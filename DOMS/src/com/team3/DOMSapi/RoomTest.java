package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testRoom() {
		Room room = new Room(1, "Clean and Ready");
		int expectedRoomNumber = 1;
		int actualRoomNumber = room.getRoomNumber();
		assertEquals(expectedRoomNumber, actualRoomNumber);
	}

	@Test
	void testGetRoomNumber() {
		Room room = new Room(1, "Clean and Ready");
		int expectedRoomNumber = 1;
		int actualRoomNumber = room.getRoomNumber();
		assertEquals(expectedRoomNumber, actualRoomNumber);
	}

	@Test
	void testSetRoomNumber() {
		Room room = new Room(1, "Clean and Ready");
		room.setRoomNumber(2);
		int expectedRoomNumber = 2;
		int actualRoomNumber = room.getRoomNumber();
		assertEquals(expectedRoomNumber, actualRoomNumber);
	}

	@Test
	void testIsAvaliable() {
		Room room = new Room(1, "Clean and Ready");
		String expectedAvaliblity = "Clean and Ready";
		String actualAvaliblity = room.isAvaliable();
		assertEquals(expectedAvaliblity, actualAvaliblity);
	}

}
