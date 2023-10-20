package Dungeon;

import java.io.Serializable;

import linkedList.CircularlyDoublyLinkedContainer;

public class Hero implements Serializable {
	
	private static final long serialVersionUID = 8497526073264669892L;
	private int maxHp;
	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	private int level;
	private Room currentRoom;
	private CircularlyDoublyLinkedContainer<Room> roomList;
	
	public Hero(int maxHp, int hp, int attack, int defense, int speed, int money, CircularlyDoublyLinkedContainer<Room> roomList) {
		this.maxHp = maxHp;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.money = money;
		this.roomList = roomList;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
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

	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void attack(Monster monster) {
		monster.setHp(monster.getHp()-attack);
	}
	
	public void increaseLevel() {
		level++;
		hp *= 1.1;
		attack *= 1.1;
		defense *= 1.1;
		speed *= 1.1;
	}
	
	public int getLevel() {
		return level;
	}
	
	public boolean isAlive() {
		return !(hp <= 0);
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public void useItem(Item item) {
		int increaseAmount = item.getBonusAmount();
		if (item.getBonusType().equals("hp")) {
			if (hp + increaseAmount > maxHp) {
				hp = maxHp;
			} else {
				hp += increaseAmount;
			}
		}
		switch(item.getBonusType()) {
			case "maxHp":
				maxHp += increaseAmount;
				break;
			case "attack":
				attack += increaseAmount;
				break;
			case "defense":
				defense += increaseAmount;
				break;
			case "speed":
				speed += increaseAmount;
				break;
			case "money":
				money += increaseAmount;
		}
	}
	
	public Room moveLeft() {
		return roomList.previous().getData();
	}
	
	public Room moveRight() {
		return roomList.next().getData();
	}
}
