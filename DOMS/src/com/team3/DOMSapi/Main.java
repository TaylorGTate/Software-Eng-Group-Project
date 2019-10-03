package com.team3.DOMSapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException{
	    //Load MySql JDBC Driver
	    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (Exception e) {
	        System.out.println ("Could not load the driver");
		}

	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter DB user name: ");
	    String usrname = input.next();
	    System.out.println("Enter password: ");
	    String pswd = input.next();
	    
	    Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOMSdb?useSSL=false&useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", usrname, pswd);
	    System.out.println("DB connected..");

	    Statement mystmt = myconn.createStatement();
	    
	    Patient testPatient = new Patient("John Smith", "1996-03-02", "123-45-6789", "N/A", "Dr. Smith", "O+");
	    String query1 = "insert into Patient values('" + testPatient.name + "', '" + testPatient.birthDate + "', '" + testPatient.ssn + "', '" + testPatient.allergies + "', '" + testPatient.preferredDoctor + "', '" + testPatient.bloodType + "');";
	    //System.out.print(query1);
	    
	    mystmt.executeUpdate(query1);
	    /*
	    System.out.println("Would you like to:\n\t1. Schedule an appointment.\n\t2. View my appointments.\n\t3. Edit my appointment.\n\t4. Cancel my appointment");
	    int choice = input.nextInt();
	    
	    if (choice == 1) {
	    	System.out.println("Please enter SSN:");
	    	String ssn = input.next();
	    	try {
	    		String query2 = ""
	    	}
	    	catch {
	    		
	    	}
	    	System.out.println("Please print name:");
	    	String patientName = input.next();
	    	//System.out.println("Please print name:");
	    	//String patientName = input.next();
	    }
	    */
	     //Close objects
	     mystmt.close();
	     myconn.close();
	     input.close();
	}

}
