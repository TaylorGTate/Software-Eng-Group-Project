package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Represents an room for an appointment at a doctor's office.
 * A room can have one appointment at a time, but many appointments in a day.
 */

public class Room {
	
	int roomNumber = 0;
	String avaliable;
    Scanner input = new Scanner(System.in);

	
	public Room (int roomNumber, String avaliable) {
		this.roomNumber = roomNumber;
		this.avaliable = avaliable;
	}
	
	//empty constructor
	public Room () {
	}
	/**
	   * Gets the room number of this room.
	   * @return this room's number.
	   */
	public int getRoomNumber() {
		return roomNumber;
	}
	/**
	   * Changes the room number of this room.
	   * @param id This room's new number.  
	   */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	   * Changes the room to available.
	   * @return available.
	   */
	public String isAvaliable() {
		return avaliable;
	}
}
