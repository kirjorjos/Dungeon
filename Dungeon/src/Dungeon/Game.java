package Dungeon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashSet;

public class Game {
	private Floor floor;
	private Hero hero;
	private Scanner scanner = new Scanner(System.in);
	private File file;
	Object[] objects = {floor, hero};
	
	public Game() {
		
	}
	
	public void runGame() throws ClassNotFoundException, IOException {
		System.out.println("Would you like to (1.)load a game or (2.)start a new one?");
		switch(scanner.next()) {
			case "1":
				String filePath;
				System.out.println("Please input the filepath to your save file or type \"back\" to go back");
				filePath = scanner.nextLine();
				if (filePath.equals("back")) {
					runGame();
				} else {
					loadGame();
				}
				break;
			case "2":
				floor = new Floor(1);
				buildHero();
				runMainLoop();
				break;
			default:
				System.out.println("You need to choose either 1 or 2.");
				runGame();
		}
	}
	
	private void runMainLoop() {
		while (hero.isAlive()) {
			System.out.println("Which do you want to do?");
			System.out.println("1. View the map");
			System.out.println("2. Look at your stats");
			System.out.println("3. Go left");
			System.out.println("4. Go right");
			System.out.println("5. Exit the game");
			
		}
	}
	
	private void exitGame() throws IOException {
		System.out.print("Would you like to save your progess? (Y or N): ");
		if (scanner.next().toLowerCase().equals("y")) {
			if (file == null) {
				getFile();
			}
			saveGame();
		}
	}
	
	private void saveGame() throws IOException {
		if (file == null) {
			getFile();
		}
		FileOutputStream stream = new FileOutputStream(file);
		ObjectOutputStream fileStream = new ObjectOutputStream(stream);
		fileStream.writeObject(objects);
		fileStream.close();
	}
	
	private boolean loadGame() throws IOException, ClassNotFoundException {
		if (file == null) {
			getFile();
		}
		FileInputStream stream = new FileInputStream(file);
		ObjectInputStream fileStream = new ObjectInputStream(stream);
		objects = (Object[]) fileStream.readObject();
		fileStream.close();
		return false;
	}
	
	private void getFile() {
		String filePath;
		System.out.println("What is the file you want to save to?");
		filePath = scanner.nextLine();
		file = new File(filePath);
		if (!file.canRead() || !file.canWrite()) {
			System.out.printf("\"%s\" is not a valid file path, please try entering another.%n", filePath);
			getFile();
		}
	}
	
	private void buildHero() {
		int points = 50;
		int maxHp, hp, attack, defense, speed, money;
		System.out.println("You get 50 points to distribute amoung the hero's attributes: Hp, Attack Power, Defense, Speed, and Starting Money.  Please choose how many points you want to spend on each.");
		hp = getHp(points);
		attack = getAttack(points);
		defense = getDefense(points);
		speed = getSpeed(points);
		money = getMoney(points);
		hero = new Hero(hp, hp, attack, defense, speed, money);	//2 HPs because 1 is max and 1 is current
	}
	
	private int getHp(int points) {
		int hp = 0;
		System.out.print("Hp: ");
		try {
			hp = scanner.nextInt();
		} catch(InputMismatchException e) {
	        String invalidInput = scanner.next(); // Store the invalid input
	        System.out.printf("\"%s\" doesn't appear to be a number. Please try again.%n", invalidInput);
			return getHp(points);
		}
		if (hp > points) {
			System.out.printf("%d isn't a valid number of points to use.  Please try again.%n", points);
			return getHp(points);
		}
		return points;
	}
	
	private int getAttack(int points) {
	    int attack = 0;
	    System.out.print("Attack: ");
	    try {
	        attack = scanner.nextInt();
	    } catch (InputMismatchException e) {
	        String invalidInput = scanner.next(); // Store the invalid input
	        System.out.printf("\"%s\" doesn't appear to be a number. Please try again.%n", invalidInput);
	        return getAttack(points);
	    }
	    if (attack > points) {
	        System.out.printf("%d isn't a valid number of points to use. Please try again.%n", points);
	        return getAttack(points);
	    }
	    return attack;
	}

	private int getDefense(int points) {
	    int defense = 0;
	    System.out.print("Defense: ");
	    try {
	        defense = scanner.nextInt();
	    } catch (InputMismatchException e) {
	        String invalidInput = scanner.next(); // Store the invalid input
	        System.out.printf("\"%s\" doesn't appear to be a number. Please try again.%n", invalidInput);
	        return getDefense(points);
	    }
	    if (defense > points) {
	        System.out.printf("%d isn't a valid number of points to use. Please try again.%n", points);
	        return getDefense(points);
	    }
	    return defense;
	}

	private int getSpeed(int points) {
	    int speed = 0;
	    System.out.print("Speed: ");
	    try {
	        speed = scanner.nextInt();
	    } catch (InputMismatchException e) {
	        String invalidInput = scanner.next(); // Store the invalid input
	        System.out.printf("\"%s\" doesn't appear to be a number. Please try again.%n", invalidInput);
	        return getSpeed(points);
	    }
	    if (speed > points) {
	        System.out.printf("%d isn't a valid number of points to use. Please try again.%n", points);
	        return getSpeed(points);
	    }
	    return speed;
	}

	private int getMoney(int points) {
	    int money = 0;
	    System.out.print("Money: ");
	    try {
	        money = scanner.nextInt();
	    } catch (InputMismatchException e) {
	        String invalidInput = scanner.next(); // Store the invalid input
	        System.out.printf("\"%s\" doesn't appear to be a number. Please try again.%n", invalidInput);
	        return getMoney(points);
	    }
	    if (money > points) {
	        System.out.printf("%d isn't a valid number of points to use. Please try again.%n", points);
	        return getMoney(points);
	    }
	    return money;
	}
}
