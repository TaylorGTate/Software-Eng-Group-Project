package com.team3.DOMSapi;
/**
 * Represents an room for an appointment at a doctor's office.
 * A room can have one appointment at a time, but many appointments in a day.
 */
public class Room {
	
	int roomNumber = 0;
	String avaliable;
	
	public Room (int roomNumber, String avaliable) {
		this.roomNumber = roomNumber;
		this.avaliable = avaliable;
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
