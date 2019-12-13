package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class DoctorManagerTest {
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

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

	@Test
	void test_createDoctor() {
		//ByteStream array to simulate user input
		String userInput = "Taylor\n1997-03-05\n123-45-6789\n";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
	    
		int numOfDoctors = 1;
		
	    DoctorManager doctorMan = new DoctorManager(1, "Becky Smith", "1984-03-24");
		
		Doctor actualValue = doctorMan.createDoctor(numOfDoctors);
		Doctor expectedValue = new Doctor(2, "Taylor", "1997-03-05", "123-45-6789");

		String expectedResult = expectedValue.getDocID() + expectedValue.getName() + expectedValue.getBirthDate() + expectedValue.getSSN();
		String actualResult = actualValue.getDocID() + actualValue.getName() + actualValue.getBirthDate() + actualValue.getSSN();
	    
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_editProfile() {
		//ByteStream array to simulate user input
		String userInput = "2\n1996-03-05\n";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
	    		
	    DoctorManager doctorMan = new DoctorManager(1, "Becky Smith", "1984-03-24");
		Doctor currentDoctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		
		Doctor actualValue = doctorMan.editProfile(currentDoctor);
		Doctor expectedValue = new Doctor(1, "Taylor", "1996-03-05", "123-45-6789");

		String expectedResult = expectedValue.getDocID() + expectedValue.getName() + expectedValue.getBirthDate() + expectedValue.getSSN();
		String actualResult = actualValue.getDocID() + actualValue.getName() + actualValue.getBirthDate() + actualValue.getSSN();
	    
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_assignDoctorToAppt() {
		//ByteStream array to simulate user input
		//String userInput = "\n";
	    //InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    //System.setIn(in);
	    
		Appointment currentAppt = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		
	    DoctorManager doctorMan = new DoctorManager(1, "Becky Smith", "1984-03-24");
		Doctor currentDoctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		
		Appointment actualValue = doctorMan.assignDoctorToAppt(currentAppt, currentDoctor);
		Appointment expectedValue = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], currentDoctor.getName(), 0);
		
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate() + actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate() + expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();

		assertEquals(actualResult, expectedResult);
	}
}
