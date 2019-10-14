package com.team3.DOMSapi;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class DataBaseTest {

	@Test
	void int_test_executeUpdate_executeQuery_newPatient() throws SQLException {
        String patientSSN = null;
		String usrname = "root";
		String pswd = "toor";		
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		String queryMan = "insert into Patient values('" + "Mandy" + "', '" + "2000-12-12" + "', '" + "123-12-4321" + "', '" + "none" + "', '" + "none" + "', '" + "A+" + "');";
		DataBase.executeUpdate(queryMan, usrname, pswd);
		String deadSSN = "123-12-4321";
        try {
          String deadSSNquery = "select * from Patient where ssn=('" + deadSSN + "');";
          ResultSet deadResult = mystmt.executeQuery(deadSSNquery);
		  while (deadResult.next ()) {
			  patientSSN = deadResult.getString(3);
          }      
        }
        catch (Exception e) {
          System.out.println(e);
        }
		assertEquals(deadSSN, patientSSN);
		
		//delete for patient next test
		String deadDeleteQuery = "delete from Patient where ssn=('" + deadSSN + "');";
		mystmt.executeUpdate(deadDeleteQuery);
	}
}






