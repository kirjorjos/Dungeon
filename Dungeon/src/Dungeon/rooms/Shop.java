package Dungeon.rooms;

import Dungeon.Room;

public class Shop extends Room {
	private int floor;
	private Dungeon.Item[] items = new Dungeon.Item[10];
	
	public Shop(int floor) {
		super(floor);
		this.floor = floor;
	}

	private void generateItems() {
		for (int i = 0; i < 10; i++) {
			items[i] = new Dungeon.Item(floor);
		}
	}
	
	public void displayItems() {
		
	}
}
