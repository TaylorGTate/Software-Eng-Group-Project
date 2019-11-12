package com.team3.DOMSapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Represents a doctor's office database.
 */
public class DataBase{
		
	private String username;
	private String password;

	public DataBase(String username, String password) {
		this.username = username;
		this.password = password;
	}
		
  	/**
	   * Executes the query in the database.
	   * @param Query Database Query to be executed.
	   * @param usrname Database connection user name.
	   * @param pswd Database connection password.
	   */
  
	public static ResultSet executeUpdate(String Query, String usrname, String pswd) throws SQLException {

		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		mystmt.executeUpdate(Query);
		return null;
	}
	
	public static ResultSet executeQuery(String Query, String usrname, String pswd) throws SQLException {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
		Statement mystmt = myconn.createStatement();
		return mystmt.executeQuery(Query);
	}
}

