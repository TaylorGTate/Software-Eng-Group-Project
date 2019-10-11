package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoctorManagerTest {

	@Test
	void testDoctorManager() {
		int expectedValue = 0;
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    assertEquals(expectedValue, testDocMan.getID());
	}

	@Test
	void testGetName() {
		String expectedName = "Becky Smith";
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    String actualName = testDocMan.getName();
	    assertEquals(expectedName, actualName);
	}

	@Test
	void testSetID() {
		int expectedID = 1;
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    testDocMan.setID(1);
	    assertEquals(expectedID, testDocMan.getID());
	}

	@Test
	void testGetID() {
		int expectedID = 0;
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    int actualID = testDocMan.getID();
	    assertEquals(expectedID, actualID);
	}

	@Test
	void testSetName() {
		String expectedManName = "Becky With The Good Hair";
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    testDocMan.setName("Becky With The Good Hair");
	    assertEquals(expectedManName, testDocMan.getName());
	}

	@Test
	void testGetBirthDate() {
		String expectedBirthDate = "1984-03-24";
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    String actualBirthDate = testDocMan.getBirthDate();
	    assertEquals(expectedBirthDate, actualBirthDate);
	}

	@Test
	void testSetBirthDate() {
		String expectedBirthDate = "1985-12-11";
	    DoctorManager testDocMan = new DoctorManager(0, "Becky Smith", "1984-03-24");
	    testDocMan.setBirthDate("1985-12-11");
	    assertEquals(expectedBirthDate, testDocMan.getBirthDate());
	}

}
