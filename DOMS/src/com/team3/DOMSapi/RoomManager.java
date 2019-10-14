package com.team3.DOMSapi;
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
	   */
	public String getRoomStatus(Room room) {
		return room.avaliable;
	}
	/**
	   * Sets the room status to clean for the specified room.
	   * @param room The room to set the status for
	   */
	public void setRoomStatusToClean(Room room) {
		room.avaliable = status[1];
	}
	/**
	   * Sets the room status to occupied for the specified room.
	   * @param room The room to set the status for
	   */
	public void setRoomStatusToOccupied(Room room) {
		room.avaliable = status[2];
	}
	/**
	   * Sets the room status to dirty for the specified room.
	   * @param room The room to set the status for
	   */
	public void setRoomStatusToDirty(Room room) {
		room.avaliable = status[3];
	}
}
