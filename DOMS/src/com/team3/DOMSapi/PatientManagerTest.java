package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientManagerTest {

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
		String actualName = p.getName();
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
