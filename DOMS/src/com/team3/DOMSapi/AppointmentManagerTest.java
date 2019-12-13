package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AppointmentManagerTest {
	static String statuses[] = {"Requested", "Approved", "Denied", "Edited"};

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
	
	@Test
	void test_denyApptRequest() {
		Appointment currentAppt = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
		
		Appointment actualValue = apptMan.denyApptRequest(currentAppt);
		Appointment expectedValue = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[2], "N/A", 0);
		
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate() + actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate() + expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_approveApptRequest() {
		Appointment currentAppt = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[0], "N/A", 0);
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
		
		Appointment actualValue = apptMan.approveApptRequest(currentAppt);
		Appointment expectedValue = new Appointment(1, "123-01-1234","2000-05-03","12:30:00","N/A",statuses[1], "N/A", 0);
		
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate() + actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate() + expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		
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
		
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
		
		Appointment actualValue = apptMan.selectAppt(apptList);
	    Appointment expectedValue = new Appointment(2, "123-11-1234","2000-05-03","11:30:00","N/A",statuses[0], "N/A", 0);
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate()+ expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate()+ actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
	    
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
		
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
		
		Appointment actualValue = apptMan.editAppt(original);
		String expectedResult = expectedValue.getApptID() + expectedValue.getSSN() + expectedValue.getDate()+ expectedValue.getTime() + expectedValue.getNotes() + expectedValue.getStatus() + expectedValue.getPreferredDoc() + expectedValue.getRoomNum();
		String actualResult = actualValue.getApptID() + actualValue.getSSN() + actualValue.getDate()+ actualValue.getTime() + actualValue.getNotes() + actualValue.getStatus() + actualValue.getPreferredDoc() + actualValue.getRoomNum();
	    
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_viewAppts() {
		
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
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
	        apptMan.viewAppts(apptList);
	        capture.flush();
	        actualResult = os.toString();
	    } finally {
	        System.setOut(originalOut);
	    }

	    assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_viewApprovedAppts() {
		
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
		Appointment a1 = new Appointment(1, "123-11-1234","2000-05-03","12:30:00","N/A",statuses[1], "N/A", 0);
		Appointment a2 = new Appointment(2, "123-11-1234","2000-05-03","11:30:00","N/A",statuses[1], "N/A", 0);
	    Appointment a3 = new Appointment(3, "123-11-1234","2000-05-03","10:30:00","N/A",statuses[0], "N/A", 0);
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		apptList.add(a1);
		apptList.add(a2);
		apptList.add(a3);
		
	    String expectedResult = "";
	    for (int i = 0; i < apptList.size(); i++) {
	    	Appointment appt = apptList.get(i);
			String status = appt.getStatus();
			if (status.equals("Approved")) {
		    	int apptID = apptList.get(i).getApptID();
				String apptDate = apptList.get(i).getDate();
				String apptTime = apptList.get(i).getTime();
				String apptNotes = apptList.get(i).getNotes();
				String apptStatus = apptList.get(i).getStatus();
				String preferredDoc = apptList.get(i).getPreferredDoc();
				expectedResult += "Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus+ "\n\tPreferred Doctor: " + preferredDoc + "\n";
			}
		}
		
		String actualResult = null;
	    PrintStream originalOut = System.out;
	    
	    try {
	        ByteArrayOutputStream os = new ByteArrayOutputStream(100);
	        PrintStream capture = new PrintStream(os);
	        // From this point on, everything printed to System.out will get captured
	        System.setOut(capture);
	        apptMan.viewApprovedAppts(apptList);
	        capture.flush();
	        actualResult = os.toString();
	    } finally {
	        System.setOut(originalOut);
	    }

	    assertEquals(actualResult, expectedResult);
	}
	
	@Test
	void test_viewRequestedAppts() {
		
		AppointmentManager apptMan = new AppointmentManager(0, "Becky Smith", "1984-03-24");
		Appointment a1 = new Appointment(1, "123-11-1234","2000-05-03","12:30:00","N/A",statuses[1], "N/A", 0);
		Appointment a2 = new Appointment(2, "123-11-1234","2000-05-03","11:30:00","N/A",statuses[1], "N/A", 0);
	    Appointment a3 = new Appointment(3, "123-11-1234","2000-05-03","10:30:00","N/A",statuses[0], "N/A", 0);
		ArrayList<Appointment> apptList = new ArrayList<Appointment>();
		apptList.add(a1);
		apptList.add(a2);
		apptList.add(a3);
		
	    String expectedResult = "";
	    for (int i = 0; i < apptList.size(); i++) {
	    	Appointment appt = apptList.get(i);
			String status = appt.getStatus();
			if (status.equals("Requested")) {
		    	int apptID = apptList.get(i).getApptID();
				String apptDate = apptList.get(i).getDate();
				String apptTime = apptList.get(i).getTime();
				String apptNotes = apptList.get(i).getNotes();
				String apptStatus = apptList.get(i).getStatus();
				String preferredDoc = apptList.get(i).getPreferredDoc();
				expectedResult += "Appt ID: " + apptID + "\n\tAppt Date: " + apptDate + "\n\tAppt Time: " + apptTime + "\n\tAppt Notes: " + apptNotes + "\n\tAppt Status: " + apptStatus+ "\n\tPreferred Doctor: " + preferredDoc + "\n";
			}
		}
		
		String actualResult = null;
	    PrintStream originalOut = System.out;
	    
	    try {
	        ByteArrayOutputStream os = new ByteArrayOutputStream(100);
	        PrintStream capture = new PrintStream(os);
	        // From this point on, everything printed to System.out will get captured
	        System.setOut(capture);
	        apptMan.viewRequestedAppts(apptList);
	        capture.flush();
	        actualResult = os.toString();
	    } finally {
	        System.setOut(originalOut);
	    }

	    assertEquals(actualResult, expectedResult);
	}
}