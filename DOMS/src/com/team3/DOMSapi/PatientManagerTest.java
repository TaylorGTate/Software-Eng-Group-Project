package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientManagerTest {

	@Test
	void test_PatientManager() {
		int expectedID = 1;
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		int actualID = p.getID();
		assertEquals(expectedID, actualID);
	}
	@Test
	void test_getID() {
		int expectedID = 1;
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		int actualID = p.getID();
		assertEquals(expectedID, actualID);
	}
	@Test
	void test_setID() {
		int expectedID = 2;
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		p.setID(expectedID);
		assertEquals(expectedID, p.getID());
	}
	@Test
	void test_getName() {
		String expectedName = "Mandy Seasholtz";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		String actualName = p.getName();
		assertEquals(expectedName, actualName);
	}
	@Test
	void test_setName() {
		String expectedName = "Cindy Jones";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		p.setName(expectedName);
		assertEquals(expectedName, p.getName());
	}
	@Test
	void test_getBirthDate() {
		String expectedBD = "1998-01-01";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		String actualBD = p.getBirthDate();
		assertEquals(expectedBD, actualBD);
	}
	@Test
	void test_setBirthDate() {
		String expectedBD = "1998-02-02";
		PatientManager p = new PatientManager(1, "Mandy Seasholtz", "1998-01-01");
		p.setBirthDate(expectedBD);
		assertEquals(expectedBD, p.getBirthDate());
	}
}
