package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppointmentTest {

	@Test
	void testAppointment() {
		int expectedValue = 1;
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        assertEquals(expectedValue, testAppt.getApptID());
	}

	@Test
	void testGetApptID() {
		int expectedApptID = 1;
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        int actualApptID = testAppt.getApptID();
        assertEquals(expectedApptID, actualApptID);
	}

	@Test
	void testSetApptID() {
		int expectedApptID = 2;
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        testAppt.setApptID(2);
        assertEquals(expectedApptID, testAppt.getApptID());
	}

	@Test
	void testGetSSN() {
		String expectedSSN = "111-22-3333";
        Appointment testAppt = new Appointment(1, "111-22-3333", "2019-05-13", "02:30:00", "Checkup", "Requested");
        String actualSSN = testAppt.getSSN();
        assertEquals(expectedSSN, actualSSN);
	}

	@Test
	void testSetSSN() {
		String expectedSSN = "111-22-3333";
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        Appointment.setSSN("111-22-3333");
        assertEquals(expectedSSN, testAppt.getSSN());
	}

	@Test
	void testGetTime() {
		String expectedTime = "12:30:00";
        Appointment testAppt = new Appointment(1, "111-22-3333", "2019-05-13", "12:30:00", "Checkup", "Requested");
        String actualTime = testAppt.getTime();
        assertEquals(expectedTime, actualTime);
	}

	@Test
	void testSetTime() {
		String expectedTime = "03:00:00";
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        testAppt.setTime("03:00:00");
        assertEquals(expectedTime, testAppt.getTime());
	}

	@Test
	void testGetDate() {
		String expectedDate = "2019-06-23";
        Appointment testAppt = new Appointment(1, "111-22-3333", "2019-06-23", "02:30:00", "Checkup", "Requested");
        String actualDate = testAppt.getDate();
        assertEquals(expectedDate, actualDate);
	}

	@Test
	void testSetDate() {
		String expectedDate = "2020-01-03";
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        testAppt.setDate("2020-01-03");
        assertEquals(expectedDate, testAppt.getDate());
	}

	@Test
	void testGetNotes() {
		String expectedNotes = "Checkup";
        Appointment testAppt = new Appointment(1, "111-22-3333", "2019-06-23", "02:30:00", "Checkup", "Requested");
        String actualNotes = testAppt.getNotes();
        assertEquals(expectedNotes, actualNotes);
	}

	@Test
	void testSetNotes() {
		String expectedNotes = "Have flu symptoms.";
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        testAppt.setNotes("Have flu symptoms.");
        assertEquals(expectedNotes, testAppt.getNotes());
	}

	@Test
	void testGetStatus() {
		String expectedStatus = "Requested";
        Appointment testAppt = new Appointment(1, "111-22-3333", "2019-06-23", "02:30:00", "Checkup", "Requested");
        String actualStatus = testAppt.getStatus();
        assertEquals(expectedStatus, actualStatus);
	}

	@Test
	void testSetStatus() {
		String expectedStatus = "Approved";
        Appointment testAppt = new Appointment(1, "123-45-6789", "2019-05-13", "02:30:00", "Checkup", "Requested");
        testAppt.setStatus("Approved");
        assertEquals(expectedStatus, testAppt.getStatus());
	}
}