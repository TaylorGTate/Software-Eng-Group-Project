package com.team3.DOMSapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DateBase {
	public static ResultSet executeQuery(String Query, String usrname, String pswd) throws SQLException {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		mystmt.executeUpdate(Query);
		return null;
	}
}
