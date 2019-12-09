package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientTest {
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

	@Test
	void test_Patient() {
		String expectedSSN = "123-01-1234";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualSSN = p.getSSN();
		assertEquals(expectedSSN, actualSSN);
	}
	@Test
	void test_getName() {
		String expectedName = "Mandy Seasholtz";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualName = p.getName();
		assertEquals(expectedName, actualName);
	}
	@Test
	void test_setName() {
		String expectedName = "Cindy Jones";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setName(expectedName);
		String actualName = p.getName();
		assertEquals(expectedName, actualName);
	}
	@Test
	void test_getPatientID() {
		int expectedID = 1;
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		int actualID = p.getPatientID();
		assertEquals(expectedID, actualID);
	}
	@Test
	void test_setPatientID() {
		int expectedID = 2;
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setPatientID(2);
		int actualID = p.getPatientID();
		assertEquals(expectedID, actualID);
	}
	@Test
	void test_getBirthDate() {
		String expectedBD = "1998-01-01";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualBD = p.getBirthDate();
		assertEquals(expectedBD, actualBD);
	}
	@Test
	void test_setBirthDate() {
		String expectedBD = "1998-02-02";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setBirthDate(expectedBD);
		assertEquals(expectedBD, p.getBirthDate());
	}
	@Test
	void test_getSSN() {
		String expectedSSN = "123-01-1234";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualSSN = p.getSSN();
		assertEquals(expectedSSN, actualSSN);
	}
	@Test
	void test_setSSN() {
		String expectedSSN = "123-01-1111";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setSSN(expectedSSN);
		assertEquals(expectedSSN, p.getSSN());
	}
	@Test
	void test_getAllergies() {
		String expectedAllergies = "pollen";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualAllergies = p.getAllergies();
		assertEquals(expectedAllergies, actualAllergies);
	}
	void test_setAllergies() { //special case update
		String expectedAllergies = "pizza";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setAllergies(expectedAllergies);
		assertEquals(expectedAllergies, p.getAllergies());
	}
	@Test
	void test_getDoctor() {
		String expectedDoctor = "Dr. Williams";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualDoctor = p.getDoctor();
		assertEquals(expectedDoctor, actualDoctor);
	}
	@Test
	void test_setDoctor() {
		String expectedDoctor = "Dr. Smith";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setDoctor(expectedDoctor);
		assertEquals(expectedDoctor, p.getDoctor());
	}
	@Test
	void test_getBloodType() {
		String expectedBloodType = "A+";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		String actualBloodType = p.getBloodType();
		assertEquals(expectedBloodType, actualBloodType);
	}
	@Test
	void test_setBloodType() {
		String expectedBT = "B-";
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		p.setBloodType(expectedBT);
		assertEquals(expectedBT, p.getBloodType());
	}
	@Test
	void test_requestAppt() {
	    Appointment expectedValue = new Appointment(13, "222-33-4444","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
	}

}
