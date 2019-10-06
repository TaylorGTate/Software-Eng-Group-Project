package com.team3.DOMSapi;

public class Room {
	
	int roomNumber = 0, buildingNumber = 0;
	boolean avaliable = true;
	
	public Room (int roomNumber, int buildingNumber, boolean avaliable) {
		this.roomNumber = roomNumber;
		this.buildingNumber = buildingNumber;
		this.avaliable = avaliable;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	
	public boolean isAvaliable() {
		return avaliable;
	}
}
