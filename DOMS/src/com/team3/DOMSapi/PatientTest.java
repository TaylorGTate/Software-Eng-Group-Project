package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
	void test_EmptyPatient() {
		Patient emptyPatient = new Patient();
		String actualValue = emptyPatient.getSSN();
		String expectedValue = null;
		
		assertEquals(actualValue, expectedValue);
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
	void test_setAllergies() {
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
		//ByteStream array to simulate user input
		String userInput = "2000-05-03\n12:30\nN/A\nN/A";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
	    
		int numOfAppts = 1;
		
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-01-1234", "pollen", "Dr. Williams", "A+");
		
		Appointment actualValue = p.requestAppt(numOfAppts);
	    Appointment expectedValue = new Appointment(2, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate()+ expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate()+ actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
	    
		assertEquals(actualResult, expectedResult);
	}
	@Test
	void test_selectAppt() {
		//ByteStream array to simulate user input
		String userInput = "2";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
		
		Appointment a1 = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		Appointment a2 = new Appointment(2, "123-11-1234","2000-05-03","11:30:00","N/A",statuses[0], "N/A", 0);
	    Appointment a3 = new Appointment(3, "123-10-1234","2000-05-03","10:30:00","N/A",statuses[0], "N/A", 0);

		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		apptList.add(a1);
		apptList.add(a2);
		apptList.add(a3);
		
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-11-1234", "pollen", "Dr. Williams", "A+");
		
		Appointment actualValue = p.selectAppt(apptList);
	    Appointment expectedValue = new Appointment(2, "123-11-1234","2000-05-03","11:30:00","N/A",statuses[0], "N/A", 0);
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate()+ expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate()+ actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
	    
		assertEquals(actualResult, expectedResult);
	}
	@Test
	void test_viewAppts() {
		
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-11-1234", "pollen", "Dr. Williams", "A+");
		Appointment a1 = new Appointment(1, "123-11-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		Appointment a2 = new Appointment(2, "123-11-1234","2000-05-03","11:30:00","N/A",statuses[0], "N/A", 0);
	    Appointment a3 = new Appointment(3, "123-11-1234","2000-05-03","10:30:00","N/A",statuses[0], "N/A", 0);
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		apptList.add(a1);
		apptList.add(a2);
		apptList.add(a3);
		
	    String expectedResult = "";
	    for (int i = 0; i < apptList.size(); i++) {
	    	int apptID = apptList.get(i).getApptID();
			String apptDate = apptList.get(i).getDate();
			String apptTime = apptList.get(i).getTime();
			String apptNotes = apptList.get(i).getNotes();
			String apptStatus = apptList.get(i).getStatus();
			String preferredDoc = apptList.get(i).getPreferredDoc();
			expectedResult += "Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus+ "\n\tPreferred Doctor: " + preferredDoc + "\n";
	    }
		
		String actualResult = null;
	    PrintStream originalOut = System.out;
	    
	    try {
	        ByteArrayOutputStream os = new ByteArrayOutputStream(100);
	        PrintStream capture = new PrintStream(os);
	        // From this point on, everything printed to System.out will get captured
	        System.setOut(capture);
	        p.viewAppts(apptList);
	        capture.flush();
	        actualResult = os.toString();
	    } finally {
	        System.setOut(originalOut);
	    }

	    assertEquals(actualResult, expectedResult);
	}
	@Test
	void test_editAppt() {
		//ByteStream array to simulate user input
		String userInput = "3\nEdited";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
		
		Appointment original = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		Appointment expectedValue = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","Edited",statuses[0], "N/A", 0);
		
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-11-1234", "pollen", "Dr. Williams", "A+");
		
		Appointment actualValue = p.editAppt(original);
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate()+ expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate()+ actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
	    
		assertEquals(actualResult, expectedResult);
	}
	@Test
	void test_cancelAppt() {
		//ByteStream array to simulate user input
		String userInput = "y";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
		
		Appointment expectedValue = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		
		Patient p = new Patient(1, "Mandy Seasholtz", "1998-01-01", "123-11-1234", "pollen", "Dr. Williams", "A+");
		
		Appointment actualValue = p.editAppt(expectedValue);
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate()+ expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate()+ actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
	    
		assertEquals(actualResult, expectedResult);
	}
	@Test
	void test_editProfile() {
		//ByteStream array to simulate user input
		String userInput = "1\nTristan Walk\n";
	    InputStream in = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(in);
				
		Patient originalValue = new Patient(1, "Amanda Seasholtz", "1998-01-01", "123-11-1234", "pollen", "Dr. Williams", "A+");
		Patient expectedValue = new Patient(1, "Tristan Walk", "1998-01-01", "123-11-1234", "pollen", "Dr. Williams", "A+");
		
		Patient actualValue = originalValue.editProfile();
		String expectedResult = expectedValue.getPatientID() + expectedValue.getName() + expectedValue.getBirthDate()+ expectedValue.getSSN() + expectedValue.getAllergies() + expectedValue.getDoctor() + expectedValue.getBloodType();
		String actualResult = actualValue.getPatientID() + actualValue.getName() + actualValue.getBirthDate()+ actualValue.getSSN() + actualValue.getAllergies() + actualValue.getDoctor() + actualValue.getBloodType();
	    
		assertEquals(actualResult, expectedResult);
	}
}
