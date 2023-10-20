package Dungeon.rooms;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dungeon.Hero;
import Dungeon.Room;

public class Shop extends Room {
	private int floor;
	private Dungeon.Item[] items = new Dungeon.Item[10];
	private Scanner scanner = new Scanner(System.in);
	private Hero hero;
	
	public Shop(int floor, Hero hero) {
		super(floor);
		this.floor = floor;
		setDisplayName("  Shop  ");
		generateItems();
		this.hero = hero;
	}

	private void generateItems() {
		for (int i = 0; i < 10; i++) {
			items[i] = new Dungeon.Item(floor);
		}
	}
	
	private void displayItems() {
		System.out.println("Welcome to the shop, displayed below are the items and their prices:");
		for (int i = 0; i < 10; i++) {
			Dungeon.Item item = items[i];
			System.out.println(i+1 + ": " + item.getBonusAmount() + " coins: " + item.getName());
		}
		System.out.println("What do you want to buy? (pick a number)");
	}
	
	public void interact() {
		Dungeon.Item item;
		int userChoice;
		displayItems();
		userChoice = getUserInput();
		if (userChoice == -1) {
			return;
		}
		item = items[userChoice];
		hero.useItem(item);
	}
	
	private int getNumber() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			String invalidInput = scanner.nextLine();
			if (invalidInput.equals("back")) {
				return -1;
			}
			System.out.printf("\"%s\" is not a number.", invalidInput);
			return getNumber();
		}
	}
	
	private int getUserInput() {
		int input = getNumber();
		if (input >= hero.getMoney()) {
			System.out.printf("%d is more money than you have.  Either type \"back\" to exit the shop or choose something else.");
			return getUserInput();
		}
		return input;
	}
}
