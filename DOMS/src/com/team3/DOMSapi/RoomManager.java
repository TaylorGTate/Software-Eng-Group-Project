package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an room manager at a doctor's office.
 * A room manager can set the room status.
 */
 
public class RoomManager {
	
	int id;
	String name, birthDate;
	String status[] = {"Clean and Ready", "Occupied", "Empty and Dirty"};
	
	public RoomManager (int id, String name, String birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public RoomManager() {
	}
	
	/**
	   * Gets the manager ID of this room manager.
	   * @return this room manager's ID.
	   */
	public int getID() {
		return id;
	}
	/**
	   * Changes the manager ID of this room manager.
	   * @param id This room manager's new manager ID.  
	   */
	public void setID(int id) {
		this.id = id;
	}
	/**
	   * Gets the first and last name of this room manager.
	   * @return this room manager's name.
	   */
	public String getName() {
		return name;
	}
	/**
	   * Changes the name of this room manager.
	   * @param name This room manager's new name.  
	   *                Should include both first
	   *                and last name.
	   */
	public void setName(String name) {
		this.name = name;
	}
	/**
	   * Changes the room manager's birthday.
	   * @param birthDate This room manager's birthday.  
	   */
	public void setBirthday(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	   * Gets the birthday of this room manager.
	   * @return this room manager's birthday.
	   */
	public String getBirthday() {
		return birthDate;
	}
	
	/*public Boolean isBirthday() {
		return false;
	}*/
	/**
	   * Gets the room status for the specified room.
	   * @param room The room to check the status for
	   * @return this room's status
	 * @throws SQLException 
	   */
	public String getRoomStatus(String roomNum, String username, String password) throws SQLException {
		
		//declare variables 
		String roomStatus = null;
		Scanner input = new Scanner(System.in);
		
		//Query to find room with specify roomNumber
		String queryForRoom = "select * from room where roomNumber = ('" + roomNum + "');";
		
		//Execute query to find room in database
		ResultSet rs = DataBase.executeQuery(queryForRoom, username, password);
		
		//Iterate through ResultSet to get status of room
		while(rs.next()) {
			roomStatus = rs.getString(2);
		}
		
		//Close scanner
		input.close();
		
		//Return roomStatus
		return roomStatus;
		
	}
	/**
	   * Sets the room status to clean for the specified room.
	   * @param room The room to set the status for
	 * @throws SQLException 
	   */
	public void setRoomStatusToClean(String roomNum, String username, String password) throws SQLException {
		
		//Query to update the room being passed to clean
		String cleanQuery = "update room set avaliable = 'Clean and Ready' where roomNumber = ('" + roomNum + "')";
		
		//Execute update query on database
		DataBase.executeUpdate(cleanQuery, username, password);
		
	}
	/**
	   * Sets the room status to occupied for the specified room.
	   * @param room The room to set the status for
	   * @throws SQLException
	   */
	public void setRoomStatusToOccupied(String roomNum, String username, String password) throws SQLException {
		//Query to update the room being passed to clean
		String cleanQuery = "update room set avaliable = 'Occupied' where roomNumber = ('" + roomNum + "')";
		
		//Execute update query on database
		DataBase.executeUpdate(cleanQuery, username, password);
	}
	/**
	   * Sets the room status to dirty for the specified room.
	   * @param room The room to set the status for
	   * @throws SQLException
	   */
	public void setRoomStatusToDirty(String roomNum, String username, String password) throws SQLException {
		//Query to update the room being passed to clean
		String cleanQuery = "update room set avaliable = 'Empty and Dirty' where roomNumber = ('" + roomNum + "')";
		
		//Execute update query on database
		DataBase.executeUpdate(cleanQuery, username, password);	}
	
	public ArrayList<Appointment> assignPatientRoom(ArrayList<Appointment> aList, ArrayList<Room> rList, String username, String password) throws SQLException {
		
		//Declare need variables
		Scanner input = new Scanner(System.in);
		
		//Headers for all checked-in appointments
  		System.out.println();
		System.out.println("All checked-in appointments:");
		System.out.println("Appointment ID" + "\t" + " Room Number" + "\t"+ " Patient SSN" + "\t" + " Appointment Date" + "\t" + " Appointment Time" + "\t" + " Appointment Status");	    	  		
		
		//iterating through appointment ArrayList to get all checked-in appointments
		for (Appointment a: aList) {
			if(a.getStatus() == "Checked-in") {
				System.out.format("%s\t\t %s\t\t %s\t %s\t\t %s\t\t %s\t\n", a.getApptID(), a.getRoomNum(), a.getSSN(), a.getDate(), a.getTime(), a.getStatus());
			}
		}
		
		//Headers for clean and ready Room list
  		System.out.println();
		System.out.println("All avaliable rooms:");
		System.out.println("Room Number" + "\t" + " Room Status");
		
		//iterating through room ArrayList to get all clean and ready rooms
		for (Room r: rList) {
			if(r.isAvaliable().equals("Clean and Ready")) {
	  			System.out.format("%s\t\t %s\t \n", r.getRoomNumber(), r.isAvaliable());
			}
		}
		
		//Get the appointment ID of the appointment to assign it to a room
  		System.out.println();
  		System.out.println("Enter appointment ID to assign to a room.");
  		int appointmentID = input.nextInt();
  		System.out.println("Enter the room number you would like to assign to appointment ID " + appointmentID + ".");
  		int roomNumber = input.nextInt();
		
		//iterating through the appointment ArrayList to find the ID entered and assign it to the room number entered
  		for (Appointment a: aList) {
  			if(a.getApptID() == appointmentID) {
  				a.setRoomNum(roomNumber);
  			}
  		}
  		
  		//Query to assign room number to appointment
  		String assignRoomNumToAppointment = ("UPDATE Appointment SET roomNum = " + "'" + roomNumber + "'" + "WHERE appt_id = " + "'" + appointmentID +"'");
  		
  		//Execute update on appointment table to assign room number to appointment
  		DataBase.executeUpdate(assignRoomNumToAppointment, username, password);
		
  		//close the scanner
  		input.close();
  		
  		//Return the appointment ArrayList
  		return aList;	
		
  		/*Query for all the appointments that are currently checked-in
  		String checkedInPatients = "SELECT * From Appointment WHERE status = 'Checked-in'";
  		//ResultSet of all the checked in the appointments
  		ResultSet rs = DataBase.executeQuery(checkedInPatients, username, password);
  		//iterate through the ResultSet
  		while (rs.next()) {
  			int id = rs.getInt("appt_id");
  			String Pssn = rs.getString("Pssn");
  			String apptDate = rs.getString("apptDate");
  			String apptTime = rs.getString("apptTime");
  			String status = rs.getString("status");
  			
  			//Print the results
  			System.out.format("%s\t\t %s\t %s\t\t %s\t\t %s\t\n", id, Pssn, apptDate, apptTime, status);
  		}
  		
  		//Headers for clean and ready Room list
  		System.out.println();
			System.out.println("All avaliable rooms:");
			System.out.println("Room Number" + "\t" + " Room Status");

  		//Query for all the rooms that are currently clean and ready
  		String avaliableRooms = "SELECT * From Room WHERE avaliable = 'Clean and Ready'";
  		//ResultSet of all the checked in the appointments
  		ResultSet rs1 = DataBase.executeQuery(avaliableRooms, username, password);
  		//iterate through the ResultSet
  		while (rs1.next()) {
  			int id = rs1.getInt("roomNumber");
  			String avaliable = rs1.getString("avaliable");
  			
  			//Print the results
  			System.out.format("%s\t\t %s\t \n", id, avaliable);
  		}
  		
  		//Get the appointment ID of the appointment to assign it to a room
  		System.out.println();
  		System.out.println("Enter appointment ID to assign to a room.");
  		int appointmentID = input.nextInt();
  		System.out.println("Enter the room number you would like to assign to appointment ID " + appointmentID + ".");
  		int roomNumber = input.nextInt();
  		
  		//Query to assign room number to appointment
  		String assignRoomNumToAppointment = ("UPDATE Appointment SET roomNum = " + "'" + roomNumber + "'" + "WHERE appt_id = " + "'" + appointmentID +"'");
  		
  		//Execute update on appointment table to assign room number to appointment
  		DataBase.executeUpdate(assignRoomNumToAppointment, username, password);
  		input.close();
  		
  		//Print statement confirming appointment has been assigned to a room
  		System.out.println("Appointment " + appointmentID + " has been assigned to room " + roomNumber);*/
	}
}