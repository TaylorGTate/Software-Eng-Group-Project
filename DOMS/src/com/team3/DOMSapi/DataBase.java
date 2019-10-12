package com.team3.DOMSapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	
public class DataBase{
		
	private String username;
	private String password;

	public DataBase(String username, String password) {
		this.username = username;
		this.password = password;
	}
		
	public static ResultSet executeQuery(String Query, String usrname, String pswd) throws SQLException {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		mystmt.executeUpdate(Query);
		return null;
	}
}

