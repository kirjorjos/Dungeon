package Dungeon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {
	private Floor floor;
	private Hero hero;
	private Scanner scanner = new Scanner(System.in);
	private File file;
	private Object[] objects = {floor, hero};
	private boolean endGame = false;
	
	public Game() {
		
	}
	
	public void runGame() throws ClassNotFoundException, IOException {
		System.out.println("Would you like to (1.)load a game or (2.)start a new one?");
		switch(scanner.nextLine()) {
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
				floor.setHero(hero);
				runMainLoop();
				break;
			default:
				System.out.println("You need to choose either 1 or 2.");
				runGame();
		}
	}
	
	private void runMainLoop() throws IOException {
		while (hero.isAlive() && !endGame) {
			System.out.println("Which do you want to do?");
			System.out.println("1. View the map");
			System.out.println("2. Look at your stats");
			System.out.println("3. Go left");
			System.out.println("4. Go right");
			System.out.println("5. Exit the game");
			switch(scanner.next()) {
			case "1":
				viewMap();
				break;
			case "2":
				displayStats();
				break;
			case "3":
				moveLeft();
				break;
			case "4":
				moveRight();
				break;
			case "5":
				exitGame();
				break;
			default:
				System.out.println("Please enter a number 1-5.");
			}
		}
		System.out.println(hero.getHp());
	}
	
	private void viewMap() {
	    int floorSize = floor.getSize();
	    int centerX = floorSize / 2;
	    int centerY = floorSize / 2;
	    double radius = Math.min(centerX, centerY) * 0.8; // calculate the radius based on a scaling factor found through trial and error
	    String[][] displayGrid = new String[floorSize][floorSize];

	    for (int i = 0; i < floor.getSize(); i++) {
	        double angle = 2 * Math.PI * i / floor.getSize();
	        int x = (int) Math.round(centerX + radius * Math.cos(angle));
	        int y = (int) Math.round(centerY + radius * Math.sin(angle));

	        // Error checking
	        x = Math.min(Math.max(x, 0), floorSize - 1);
	        y = Math.min(Math.max(y, 0), floorSize - 1);

	        displayGrid[x][y] = floor.getRoom(i).toString();
	    }

	    // Print the circular grid
	    for (int i = 0; i < floorSize; i++) {
	        for (int j = 0; j < floorSize; j++) {
	            System.out.print(displayGrid[i][j] != null ? displayGrid[i][j] : "       ");
	        }
	        System.out.println();
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
		endGame = true;
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
		int hp, attack, defense, speed, money;
		System.out.println("You get 50 points to distribute amoung the hero's attributes: Hp, Attack Power, Defense, Speed, and Starting Money.  Please choose how many points you want to spend on each.");
		hp = getHp(points);
		points -= hp;
		attack = getAttack(points);
		points -= attack;
		defense = getDefense(points);
		points -= defense;
		speed = getSpeed(points);
		points -= speed;
		money = getMoney(points);
		hero = new Hero(hp, hp, attack, defense, speed, money, floor.getRoomList());	//2 HPs because 1 is max and 1 is current
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
	        System.out.printf("%d isn't a valid number of points to use. You have %d points left. Please try again.%n",hp, points);
			return getHp(points);
		}
		return hp;
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
	        System.out.printf("%d isn't a valid number of points to use. You have %d points left. Please try again.%n",attack, points);
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
	        System.out.printf("%d isn't a valid number of points to use. You have %d points left. Please try again.%n",defense, points);
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
	        System.out.printf("%d isn't a valid number of points to use. You have %d points left. Please try again.%n",speed, points);
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
	        System.out.printf("%d isn't a valid number of points to use. You have %d points left. Please try again.%n",money, points);
	        return getMoney(points);
	    }
	    return money;
	}
	
	private void displayStats() {
		System.out.println("Max HP: " + hero.getMaxHp());
		System.out.println("Current HP: " + hero.getHp());
		System.out.println("Attack: " + hero.getAttack());
		System.out.println("Defense: " + hero.getDefense());
		System.out.println("Speed: " + hero.getSpeed());
		System.out.println("Money: " + hero.getMoney());
	}
	
	private void moveLeft() {
		Room oldRoom = hero.getCurrentRoom();
		Room room = hero.moveLeft();
		room.interact();
		System.out.println(floor.removeRoom(oldRoom));
	}
	
	private void moveRight() {
		Room oldRoom = hero.getCurrentRoom();
		Room room = hero.moveRight();
		room.interact();
		System.out.println(floor.removeRoom(oldRoom));
	}
}
