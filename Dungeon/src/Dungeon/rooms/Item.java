package Dungeon.rooms;

import Dungeon.Hero;
import Dungeon.Room;


public class Item extends Room {

	private Dungeon.Item item;
	private Hero hero;

	public Item(int floor, Hero hero) {
		super(floor);
		item = new Dungeon.Item(floor);
		setDisplayName("  Item  ");
		this.hero = hero;
	}
	
	public Dungeon.Item getItem() {
		return item;
	}

	@Override
	public void interact() {
		hero.useItem(item);
	}
	
}
