package Dungeon.rooms;

import Dungeon.Room;


public class Item extends Room {

	private Dungeon.Item item;

	public Item(int floor) {
		super(floor);
		item = new Dungeon.Item(floor);
	}
	
	public Dungeon.Item getItem() {
		return item;
	}
	
}
