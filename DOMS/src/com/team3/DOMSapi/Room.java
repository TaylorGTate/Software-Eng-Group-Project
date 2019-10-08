package com.team3.DOMSapi;

public class Room {
	
	int roomNumber = 0, buildingNumber = 0;
	String avaliable, patientSSN;
	
	public Room (int roomNumber, int buildingNumber, String avaliable, String patientSSN) {
		this.roomNumber = roomNumber;
		this.buildingNumber = buildingNumber;
		this.avaliable = avaliable;
		this.patientSSN = patientSSN;
	}
	
	public String getPatientSSN() {
		return patientSSN;
	}
	
	public void setPatientSSN(String patientSSN) {
		this.patientSSN = patientSSN;
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
	
	public String isAvaliable() {
		return avaliable;
	}
}
