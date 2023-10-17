package Dungeon;

import java.util.Scanner;

public class Game {
	private Scanner scanner = new Scanner(System.in);
	
	public Game() {
		
	}
	
	public void runGame() {
		System.out.println("Would you like to (1.)load a game or (2.)start a new one?");
		switch(scanner.nextInt()) {
			case 1:
				String filePath;
				System.out.println("Please input the filepath to your save file or type \"back\" to go back");
				filePath = scanner.nextLine();
				if (filePath.equals("back")) {
					runGame();
				}
				break;
			case 2:
				break;
			default:
				System.out.println("You need to choose either 1 or 2.");
				runGame();
		}
	}
	
	public void runGame(String filePath) {
		
	}
	
	private void saveGame() {
		
	}
	
	private void exitGame() {
		System.out.print("Would you like to save your progess? (Y or N): ");
		if (scanner.next().equals("y")) {
			saveGame();
		}
	}
	
	private boolean loadGame() {
		return false;
	}
}
