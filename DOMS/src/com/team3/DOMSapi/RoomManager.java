package com.team3.DOMSapi;

public class RoomManager {
	
	int id;
	String name, birthDate;
	String status[] = {"Clean and Ready", "Occupied", "Empty and Dirty"};
	
	public RoomManager (int id, String name, String birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBirthday() {
		return birthDate;
	}
	
	public Boolean isBirthday() {
		return false;
	}
	
	public String getRoomStatus(Room room) {
		return room.avaliable;
	}
	
	public void setRoomStatusToClean(Room room) {
		room.avaliable = status[1];
	}
	
	public void setRoomStatusToOccupied(Room room) {
		room.avaliable = status[2];
	}
	
	public void setRoomStatusToDirty(Room room) {
		room.avaliable = status[3];
	}
}
