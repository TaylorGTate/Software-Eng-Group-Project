package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class DoctorTest {
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

	@Test
	void test_Doctor() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedName = "Taylor";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void test_getName() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedName = "Taylor";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void test_setName() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setName("Tristan");
		String expectedName = "Tristan";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void test_getBirthDate() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedBirthday = "1997-03-05";
		String actualBirthday = doctor.getBirthDate();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void test_setBirthDate() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setBirthDate("2001-04-06");
		String expectedBirthday = "2001-04-06";
		String actualBirthday = doctor.getBirthDate();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void test_getSSN() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedSSN = "123-45-6789";
		String actualSSN = doctor.getSSN();
		assertEquals(expectedSSN, actualSSN);
	}

	@Test
	void test_setSSN() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setSSN("123-45-6788");
		String expectedSSN = "123-45-6788";
		String actualSSN = doctor.getSSN();
		assertEquals(expectedSSN, actualSSN);	
	}
	
	@Test
	void test_setDocID() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setDocID(2);
		int expectedID = 2;
		int actualID = doctor.getDocID();
		assertEquals(expectedID, actualID);	
	}
	
	@Test
	void test_getDocID() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		int expectedID = 1;
		int actualID = doctor.getDocID();
		assertEquals(expectedID, actualID);	
	}
	
	@Test
	void test_editUserProfile() {
		Doctor currentDoctor = new Doctor(1, "Dr.Jones", "1970-12-10", "189-12-1237");
		Patient originalPatient = new Patient(1, "Mandy", "1998-12-12", "123-12-5432", "none", "Dr.Jones", "A+");
		Patient editedPatient = new Patient(1, "Tristan", "1998-12-12", "123-12-5432", "none", "Dr.Jones", "A+");
		
		//ByteStream array to simulate user input
		String userInput = "1\nTristan\n";
		InputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		
		Patient actualPatient = currentDoctor.editUserProfile(originalPatient);
		
		String actualResult = actualPatient.getPatientID() + actualPatient.getName() + actualPatient.getBirthDate() + actualPatient.getSSN() + actualPatient.getAllergies() + actualPatient.getDoctor() + actualPatient.getBloodType();
		String expectedResult = editedPatient.getPatientID() + editedPatient.getName() + editedPatient.getBirthDate() + editedPatient.getSSN() + editedPatient.getAllergies() + editedPatient.getDoctor() + editedPatient.getBloodType();

		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_editApptNotes() {
		Doctor currentDoctor = new Doctor(1, "Dr.Jones", "1970-12-10", "189-12-1237");
		Appointment appt = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		
		//ByteStream array to simulate user input
		String userInput = "\nEdited\n";
		InputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		
		Appointment actualValue = currentDoctor.editApptNotes(appt);
		Appointment expectedValue = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","Edited",statuses[0], "N/A", 0);
		
		
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate() + actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate() + expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();

		assertEquals(actualResult, expectedResult);
	}
}