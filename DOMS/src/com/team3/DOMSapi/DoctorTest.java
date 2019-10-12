package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoctorTest {

	@Test
	void testDoctor() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		String expectedName = "Taylor";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetName() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		String expectedName = "Taylor";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetName() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		doctor.setName("Tristan");
		String expectedName = "Tristan";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetBirthDate() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		String expectedBirthday = "1997-03-05";
		String actualBirthday = doctor.getBirthDate();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testSetBirthDate() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		doctor.setBirthDate("2001-04-06");
		String expectedBirthday = "2001-04-06";
		String actualBirthday = doctor.getBirthDate();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testGetSSN() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		String expectedSSN = "123-45-6789";
		String actualSSN = doctor.getSSN();
		assertEquals(expectedSSN, actualSSN);
	}

	@Test
	void testSetSSN() {
		Doctor doctor = new Doctor("Taylor", "1997-03-05", "123-45-6789");
		doctor.setSSN("123-45-6788");
		String expectedSSN = "123-45-6788";
		String actualSSN = doctor.getSSN();
		assertEquals(expectedSSN, actualSSN);	
	}

}
