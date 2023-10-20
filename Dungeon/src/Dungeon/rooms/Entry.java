package Dungeon.rooms;

import Dungeon.Room;

public class Entry extends Room {

	public Entry(int floor) {
		super(floor);
		setDisplayName("  Entry  ");
	}

	@Override
	public void interact() {
		// nothing to do here, just need to define the method
	}

}
