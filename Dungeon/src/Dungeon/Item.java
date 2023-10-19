package Dungeon;

import java.util.Random;

public class Item {
	private String name;
	private String bonusType;
	private String itemType;
	private String[] rarities = {"Common", "Uncommon", "Peculiar", "Exquisite", "Rare", "Epic", "Mystical", "Magical", "Otherworldly", "Spectral", "Enchanted", "Radiant", "Ancient", "Divine", "Sacred", "Ethereal", "Mythical", "Luminous", "Supernatural", "Fabled", "Infernal", "Cursed", "Demonic", "Infinite", "Arcane", "Enigmatic", "Celestial", "Pristine", "Sovereign", "Transcendent"};
	private String[] bonusTypes = {"hp", "attack", "defense", "speed", "money"};
	private String[] itemTypes = {"Elixir of Vitality", "Healing Crystal", "Life Essence Potion", "Blade of Eternal Fury", "Thunderstrike Amulet", "Dragonfire Gauntlet", "Shield of the Titan", "Adamantium Plate Mail", "Guardian's Ward", "Boots of Swiftness", "Windrunner Cloak", "Serpent's Sprint Shoes", "Lucky Coin of Prosperity", "Gem of Wealth", "Merchant's Favor Charm"};
	private int bonusIntType;
	private int bonusAmount;
	private int floor;
	private Random random = new Random();
	
	public Item(int floor) {
		this.floor = floor;
		name = generateName();
		bonusIntType = random.nextInt(5);
		bonusType = bonusTypes[bonusIntType];
		bonusAmount = random.nextInt(floor*2);
		itemType = itemTypes[random.nextInt(15)];
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
	
	private String generateRarity() {
		if (floor < 1000) {
			int baseIndex = (floor - 1) * rarities.length/1000;
			if (baseIndex < 2) {
				return rarities[random.nextInt(2)];
			} else if (baseIndex > rarities.length-3) {
				return rarities[random.nextInt(baseIndex-2, rarities.length)];
			} else {
				return rarities[random.nextInt(baseIndex-2, baseIndex+2)];
			}
		} else {
			return rarities[rarities.length-1];
		}
	}
	
	private String generateName() {
		String rarity = generateRarity();
		itemType = itemTypes[random.nextInt((bonusIntType+1)*3-2, (bonusIntType+1)*3-1)];	//bonusIntType is the index in the array bonusTypes of the type, then a calculation is done to make it work with groups of 3 instead of groups of 1
		return rarity + " " + itemType;
	}
}
