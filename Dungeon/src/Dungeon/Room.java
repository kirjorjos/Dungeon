package Dungeon;

import java.util.Objects;

public abstract class Room {
	
	private String displayName;
	private int floor;
	
	public Room(int floor) {
		this.floor = floor;
	}
	
	public int getFloor() {
		return floor;
	}

	public String toString() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public abstract void interact();

	@Override
	public int hashCode() {
		return Objects.hash(displayName, floor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(displayName, other.displayName) && floor == other.floor;
	}
}
