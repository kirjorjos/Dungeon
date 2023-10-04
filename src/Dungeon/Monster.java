package Dungeon;

public class Monster {

	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	
	public Monster(int hp, int attack, int defense, int speed, int money) {
		this.hp = hp;
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

	
	public int getAttack() {
		return attack;
	}

	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	
	public int getDefense() {
		return defense;
	}

	
	public void setDefense(int defense) {
		this.defense = defense;
	}

	
	public int getSpeed() {
		return speed;
	}

	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	public int getMoney() {
		return money;
	}
	
}
