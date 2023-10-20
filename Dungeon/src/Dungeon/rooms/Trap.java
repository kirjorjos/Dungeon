package Dungeon.rooms;

import java.util.Random;

import Dungeon.Hero;
import Dungeon.Room;

public class Trap extends Room {
	
	private Random random = new Random();
	private int damage;
	private Hero hero;
	
	public Trap(int floor, Hero hero) {
		super(floor);
		damage = random.nextInt(floor*5, floor*10);
		setDisplayName("  Item  ");
		this.hero = hero;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void interact() {
		hero.setHp(hero.getHp()-damage);
		System.out.printf("You hit a trap and took %d damage!%n", damage);
	}
}
