package Dungeon;

import java.util.Random;

import Dungeon.rooms.Entry;
import Dungeon.rooms.Ladder;
import linkedList.CircularlyDoublyLinkedContainer;

public class Floor {
	private Random random = new Random();
	private CircularlyDoublyLinkedContainer<Room> floor = new CircularlyDoublyLinkedContainer<Room>();
	
	public Floor(int level) {
		floor.add(new Entry(level));
		for (int i = 0; i< Math.floor(level/2); i++) {
			addRoom(level);
		}
		floor.add(new Ladder(level));
		for (int i = 0; i< Math.ceil(level/2); i++) {
			addRoom(level);
		}
	}
	
	private void addRoom(int level) {
		switch(random.nextInt(3)) {
			case 0:
				floor.add(new Dungeon.rooms.Item(level));
				break;
			case 1:
				floor.add(new Dungeon.rooms.Monster(level));
				break;
			case 2:
				floor.add(new Dungeon.rooms.Trap(level));
		}
	}
	
	
}
