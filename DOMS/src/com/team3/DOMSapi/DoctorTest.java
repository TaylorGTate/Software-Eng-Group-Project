package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DoctorTest {

	@Test
	void testDoctor() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedName = "Taylor";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetName() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedName = "Taylor";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetName() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setName("Tristan");
		String expectedName = "Tristan";
		String actualName = doctor.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetBirthDate() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedBirthday = "1997-03-05";
		String actualBirthday = doctor.getBirthDate();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testSetBirthDate() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setBirthDate("2001-04-06");
		String expectedBirthday = "2001-04-06";
		String actualBirthday = doctor.getBirthDate();
		assertEquals(expectedBirthday, actualBirthday);
	}

	@Test
	void testGetSSN() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		String expectedSSN = "123-45-6789";
		String actualSSN = doctor.getSSN();
		assertEquals(expectedSSN, actualSSN);
	}

	@Test
	void testSetSSN() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setSSN("123-45-6788");
		String expectedSSN = "123-45-6788";
		String actualSSN = doctor.getSSN();
		assertEquals(expectedSSN, actualSSN);	
	}
	
	@Test
	void testSetDocID() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		doctor.setDocID(2);
		int expectedID = 2;
		int actualID = doctor.getDocID();
		assertEquals(expectedID, actualID);	
	}
	
	@Test
	void testGetDocID() {
		Doctor doctor = new Doctor(1, "Taylor", "1997-03-05", "123-45-6789");
		int expectedID = 1;
		int actualID = doctor.getDocID();
		assertEquals(expectedID, actualID);	
	}
	
	@Test
	void testEditUserProfile() {
		Doctor currentDoctor = new Doctor(1, "Dr.Jones", "1970-12-10", "189-12-1237");
		Patient currentPatient = new Patient(1, "Mandy", "1998-12-12", "123-12-5432", "none", "Dr.Jones", "A+");
		ByteArrayInputStream in = new ByteArrayInputStream((1 + System.lineSeparator() + 1 + System.lineSeparator()).getBytes());
		Scanner input = new Scanner(in);
		currentDoctor.editUserProfile(currentPatient, input);
		ByteArrayInputStream in2 = new ByteArrayInputStream((1 + System.lineSeparator() + "Mandy" + System.lineSeparator()).getBytes());
		Scanner input2 = new Scanner(in2);
		ByteArrayInputStream in3 = new ByteArrayInputStream((1 + System.lineSeparator() + "Max" + System.lineSeparator()).getBytes());
		Scanner input3 = new Scanner(in3);
		Patient updatedPatient = currentPatient.editProfile(input2);
		assertEquals(currentPatient, updatedPatient);
		
		
		
	}

}
