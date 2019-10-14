package com.team3.DOMSapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Room {
	
	int roomNumber = 0;
	String avaliable;
    Scanner input = new Scanner(System.in);

	
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
