package Dungeon;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

import Dungeon.rooms.Entry;
import Dungeon.rooms.Ladder;
import linkedList.CircularlyDoublyLinkedContainer;

public class Floor implements Serializable {
	private static final long serialVersionUID = 4798732347102318721L;
	private Random random = new Random();
	private CircularlyDoublyLinkedContainer<Room> floor = new CircularlyDoublyLinkedContainer<Room>();
	private Hero hero;
	private int level;
	
	public Floor(int level) {
		this.level = level;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
		floor.add(new Entry(level));
		for (int i = 0; i< level; i++) {
			addRoom(level);
		}
		Ladder ladder = new Ladder(level);
		floor.add(ladder);
		for (int i = 0; i< level; i++) {
			addRoom(level);
		}
		hero.setCurrentRoom(getRoom(0));
	}
	
	private void addRoom(int level) {
		switch(random.nextInt(3)) {
			case 0:
				floor.add(new Dungeon.rooms.Item(level, hero));
				break;
			case 1:
				floor.add(new Dungeon.rooms.Monster(level, hero));
				break;
			case 2:
				floor.add(new Dungeon.rooms.Trap(level, hero));
		}
	}
	
	public int getSize() {
		return floor.getSize();
	}
	
	public Room getRoom(int i) {
		return floor.get(i);
	}
	
	public CircularlyDoublyLinkedContainer<Room> getRoomList() {
		return floor;
	}
	
	public boolean removeRoom(Room room) {
		return floor.remove(room);
	}

	@Override
	public int hashCode() {
		return Objects.hash(floor, hero, level);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Floor other = (Floor) obj;
		return Objects.equals(floor, other.floor) && Objects.equals(hero, other.hero) && level == other.level;
	}
}
