package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppointmentManagerTest {

	@Test
	void testAppointmentManager() {
		int expectedValue = 0;
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    assertEquals(expectedValue, testApptMan.getManID());
	}

	@Test
	void testGetName() {
		String expectedName = "Becky Smith";
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    String actualName = testApptMan.getName();
	    assertEquals(expectedName, actualName);
	}

	@Test
	void testSetManID() {
		int expectedManID = 1;
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    testApptMan.setManID(1);
	    assertEquals(expectedManID, testApptMan.getManID());
	}

	@Test
	void testGetManID() {
		int expectedManID = 0;
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    int actualManID = testApptMan.getManID();
	    assertEquals(expectedManID, actualManID);
	}

	@Test
	void testSetName() {
		String expectedManName = "Becky With The Good Hair";
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    testApptMan.setName("Becky With The Good Hair");
	    assertEquals(expectedManName, testApptMan.getName());
	}

	@Test
	void testGetBirthDate() {
		String expectedBirthDate = "1984-03-24";
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    String actualBirthDate = testApptMan.getBirthDate();
	    assertEquals(expectedBirthDate, actualBirthDate);
	}

	@Test
	void testSetBirthDate() {
		String expectedBirthDate = "1985-12-11";
	    AppointmentManager testApptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
	    testApptMan.setBirthDate("1985-12-11");
	    assertEquals(expectedBirthDate, testApptMan.getBirthDate());
	}
}
