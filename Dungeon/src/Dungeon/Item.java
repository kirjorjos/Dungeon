package Dungeon;

public class Item {
	private String name;
	private String bonusType;
	private int bonusAmount;
	
	public Item(String name, String bonusType, int bonusAmount) {
		this.name = name;
		this.bonusType = bonusType;
		this.bonusAmount = bonusAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBonusType() {
		return bonusType;
	}
	
	public int bonusAmount() {
		return bonusAmount;
	}
}
