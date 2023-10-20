package Dungeon.rooms;

import java.util.Random;

import Dungeon.Hero;
import Dungeon.Room;

public class Monster extends Room {

	private Random random = new Random();
	private Dungeon.Monster monster;
	private int hp, attack, defense, speed, money;
	private Hero hero;
	
	
	public Monster(int floor, Hero hero) {
		super(floor);
		hp = random.nextInt(floor*10, floor*20);
		attack = random.nextInt(floor*10, floor*20);
		defense = random.nextInt(floor*10, floor*20);
		speed = random.nextInt(floor*10, floor*20);
		money = random.nextInt(floor*10, floor*20);
		monster = new Dungeon.Monster(hp, attack, defense, speed, money);
		setDisplayName("Monster");
		this.hero = hero;
	}

	public Dungeon.Monster getMonster() {
		return monster;
	}

	@Override
	public void interact() {
		System.out.printf("You come across a monster that does %d damage and has %d health.%n", monster.getAttack(), monster.getHp());
		do {
			if (hero.getSpeed() > monster.getSpeed()) {
				monster.setHp(monster.getHp()-hero.getAttack());
				System.out.printf("You deal %d damage to the monster.%n", hero.getAttack());
				if (!monster.isAlive()) {
					System.out.printf("The monster drops %d coins for you to pick up", monster.getMoney());
					hero.setMoney(hero.getMoney() + monster.getMoney());
					return;
				}
			} else if (hero.getSpeed() < monster.getSpeed()) {
				hero.setHp(hero.getHp()-monster.getAttack());
				System.out.printf("The monster deals %d damage to you.%n", monster.getAttack());
				if (!hero.isAlive()) {
					return;
				}
			} else {
				if (random.nextInt(1) == 1) {
					monster.setHp(monster.getHp()-hero.getAttack());
					System.out.printf("You deal %d damage to the monster.%n", hero.getAttack());
					if (!monster.isAlive()) {
						System.out.printf("The monster drops %d coins for you to pick up", monster.getMoney());
						hero.setMoney(hero.getMoney() + monster.getMoney());
						return;
					}
				} else {
					hero.setHp(hero.getHp()-monster.getAttack());
					System.out.printf("The monster deals %d damage to you.%n", monster.getAttack());
					if (!hero.isAlive()) {
						return;
					}
				}
			}
		} while (monster.isAlive() && hero.isAlive());
	}
}