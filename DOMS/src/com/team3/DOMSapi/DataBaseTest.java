package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DataBaseTest {

	@Test
	void test_executeQuery_get() throws SQLException {//need to fix
		String username = "root";
		String password = "toor";		
		String queryMan = "insert into AppointmentManager values('" + 1 + "','" + "Manger Mandy" + "', '" + "2000-12-12" + "');";
		int expectedID = 1;
		AppointmentManager ap = new AppointmentManager(1, "Manger Mandy", "2000-12-12");
		int actualID = ap.getManID();
		assertEquals(expectedID, actualID);
	}

}






