package Dungeon.rooms;

import java.util.Random;

import Dungeon.Room;

public class Monster extends Room {

	private Random random = new Random();
	private Dungeon.Monster monster;
	private int hp, attack, defense, speed, money;
	
	
	public Monster(int floor) {
		super(floor);
		hp = random.nextInt(floor*10, floor*20);
		attack = random.nextInt(floor*10, floor*20);
		defense = random.nextInt(floor*10, floor*20);
		speed = random.nextInt(floor*10, floor*20);
		money = random.nextInt(floor*10, floor*20);
		monster = new Dungeon.Monster(hp, attack, defense, speed, money);
	}

	public Dungeon.Monster getMonster() {
		return monster;
	}
}