package com.team3.DOMSapi;

public class Room {
	
	int roomNumber = 0;
	String avaliable;
	
	public Room (int roomNumber, String avaliable) {
		this.roomNumber = roomNumber;
		this.avaliable = avaliable;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String isAvaliable() {
		return avaliable;
	}
}
