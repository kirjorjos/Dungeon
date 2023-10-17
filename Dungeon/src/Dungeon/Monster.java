package Dungeon;

public class Monster {

	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	
	public Monster(int hp, int attack, int defense, int speed, int money) {
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.money = money;
	}

	
	public int getHp() {
		return hp;
	}

	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public void attack(Hero hero) {
		hero.setHp(hero.getHp()-attack);
	}
	
	public int getAttack() {
		return attack;
	}

	
	public int getDefense() {
		return defense;
	}

	
	public int getSpeed() {
		return speed;
	}

	
	public int getMoney() {
		return money;
	}
	
}
