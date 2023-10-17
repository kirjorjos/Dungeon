package Dungeon.rooms;

import java.util.Random;

import Dungeon.Room;

public class Trap extends Room {
	
	private Random random = new Random();
	private int damage;
	
	public Trap(int floor) {
		super(floor);
		damage = random.nextInt(floor*5, floor*10);
	}
	
	public int getDamage() {
		return damage;
	}
}
