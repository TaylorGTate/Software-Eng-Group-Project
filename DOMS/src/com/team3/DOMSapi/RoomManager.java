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
	
	/**
	   * Gets the room status for the specified room.
	   * @param room The room to check the status for
	   * @return this room's status
	 * @throws SQLException 
	   */
	public String getRoomStatus(int roomNumber, ArrayList<Room> rList, String username, String password) throws SQLException {
		
		//declare variables 
		String roomStatus = null;
  		
		//iterating through the room ArrayList
  		for (Room r: rList) {
  			if (r.getRoomNumber() == roomNumber) {
  				roomStatus = r.isAvaliable();
  			}
  		}
		
		//Return roomStatus
		return roomStatus;
		
	}
	/**
	   * Sets the room status to clean for the specified room.
	   * @param room The room to set the status for
	 * @throws SQLException 
	   */
	public ArrayList<Room> setRoomStatusToClean( ArrayList<Room> rList, int roomNum, String username, String password) throws SQLException {
		
		//iterating through the room ArrayList
  		for (Room r: rList) {
  			if (r.getRoomNumber() == roomNum) {
  				r.setAvaliablity("Clean and Ready");
  			}
  		}
		
		//Query to update the room being passed to clean
		String cleanQuery = "update room set avaliable = 'Clean and Ready' where roomNumber = ('" + roomNum + "')";
		
		//Execute update query on database
		DataBase.executeUpdate(cleanQuery, username, password);
		
		return rList;
		
	}
	/**
	   * Sets the room status to occupied for the specified room.
	   * @param room The room to set the status for
	   * @throws SQLException
	   */
	public ArrayList<Room> setRoomStatusToOccupied(ArrayList<Room> rList, int roomNum, String username, String password) throws SQLException {
		
		//iterating through the room ArrayList
  		for (Room r: rList) {
  			if (r.getRoomNumber() == roomNum) {
  				r.setAvaliablity("Occupied");
  			}
  		}
		
		//Query to update the room being passed to clean
		String occupiedQuery = "update room set avaliable = 'Occupied' where roomNumber = ('" + roomNum + "')";
		
		//Execute update query on database
		DataBase.executeUpdate(occupiedQuery, username, password);
		
		return rList;
	}
	/**
	   * Sets the room status to dirty for the specified room.
	   * @param room The room to set the status for
	   * @throws SQLException
	   */
	public ArrayList<Room> setRoomStatusToDirty( ArrayList<Room> rList, int roomNum, String username, String password) throws SQLException {
		
		//iterating through the room ArrayList
  		for (Room r: rList) {
  			if (r.getRoomNumber() == roomNum) {
  				r.setAvaliablity("Empty and Dirty");
  			}
  		}
		
		//Query to update the room being passed to clean
		String dirtyQuery = "update room set avaliable = 'Empty and Dirty' where roomNumber = ('" + roomNum + "')";
		
		//Execute update query on database
		DataBase.executeUpdate( dirtyQuery, username, password);
		
		return rList;
	}
	
	public ArrayList<Integer> assignPatientRoom(Scanner input, ArrayList<Appointment> aList, ArrayList<Room> rList, String username, String password) throws SQLException {
		
		//Make ArrayList for appt id and room number
  		ArrayList <Integer> apptIDRoomNum = new ArrayList<Integer>();
		
		//Headers for all checked-in appointments
  		System.out.println();
		System.out.println("All checked-in appointments:");
		System.out.println("Appointment ID" + "\t" + " Room Number" + "\t"+ " Patient SSN" + "\t" + " Appointment Date" + "\t" + " Appointment Time" + "\t" + " Appointment Status");	    	  		
		
		//iterating through appointment ArrayList to get all checked-in appointments
		for (Appointment a: aList) {
			if(a.getStatus() == "Approved") {
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
  		apptIDRoomNum.add(input.nextInt());
  		
  		//get apppointmentID
  		int appointmentID = apptIDRoomNum.get(0);
  		
  		System.out.println("Enter the room number you would like to assign to appointment ID " + appointmentID + ".");
  		apptIDRoomNum.add(input.nextInt());
  		
  		//get room number
  		int roomNumber = apptIDRoomNum.get(1);
  		
  		//Query to assign room number to appointment
  		String assignRoomNumToAppointment = ("UPDATE Appointment SET roomNum = " + "'" + roomNumber + "'" + "WHERE appt_id = " + "'" + appointmentID +"'");
  		
  		//Query to assign Checked-in status to appointment
  		String assignStatusToAppointment = ("UPDATE Appointment SET status = " + "'" + "Checked-in" + "'" + "WHERE appt_id = " + "'" + appointmentID +"'");
  		
  		//Query to assign room status to occupied
  		String assignStatusToRoom = ("UPDATE Room SET avaliable = " + "'" + "Occupied" + "'" + "WHERE roomNumber = " + "'" + roomNumber +"'");
  		
  		//Execute updates on appointment and room tables 
  		DataBase.executeUpdate(assignRoomNumToAppointment, username, password);
  		DataBase.executeUpdate(assignStatusToAppointment, username, password);
  		DataBase.executeUpdate(assignStatusToRoom, username, password);


				
  		//Return the appointment ArrayList
  		return apptIDRoomNum;	
	}
}