package Dungeon;

public abstract class Room {
	
	private String displayName;
	private int floor;
	
	public Room(int floor) {
		this.floor = floor;
	}
	
	public int getFloor() {
		return floor;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public abstract void interact();
}
