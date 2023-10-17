package Dungeon.rooms;

import java.util.Random;

import Dungeon.Room;


public class Item extends Room {
	
	private String[] rarities = {"Common", "Uncommon", "Peculiar", "Exquisite", "Rare", "Epic", "Mystical", "Magical", "Otherworldly", "Spectral", "Enchanted", "Radiant", "Ancient", "Divine", "Sacred", "Ethereal", "Mythical", "Luminous", "Supernatural", "Fabled", "Infernal", "Cursed", "Demonic", "Infinite", "Arcane", "Enigmatic", "Celestial", "Pristine", "Sovereign", "Transcendent"};
	private String[] bonusTypes = {"hp", "attack", "defense", "speed", "money"};
	private String[] itemTypes = {"Elixir of Vitality", "Healing Crystal", "Life Essence Potion", "Blade of Eternal Fury", "Thunderstrike Amulet", "Dragonfire Gauntlet", "Shield of the Titan", "Adamantium Plate Mail", "Guardian's Ward", "Boots of Swiftness", "Windrunner Cloak", "Serpent's Sprint Shoes", "Lucky Coin of Prosperity", "Gem of Wealth", "Merchant's Favor Charm"};
	private String itemType;
	private String bonusType;
	private int bonusIntType;
	private int bonusAmount;
	private int floor;
	private Dungeon.Item item;
	private Random random = new Random();

	public Item(int floor) {
		super(floor);
		this.floor = floor;
		bonusIntType = random.nextInt(5);
		bonusType = bonusTypes[bonusIntType];
		bonusAmount = random.nextInt(floor*2);
		itemType = itemTypes[random.nextInt(15)];
		item = new Dungeon.Item(getName(), bonusType, bonusAmount);
	}
	
	/**
	 * Generate the rarity term for an item based on the floor it's on
	 * @param floor The floor the item is on
	 * @return
	 */
	public String getRarity() {
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
	
	public Dungeon.Item getItem() {
		return item;
	}
	
	public String getName() {
		String rarity = getRarity();	//TODO: make weighted based on current floor
		itemType = itemTypes[random.nextInt((bonusIntType+1)*3-2, (bonusIntType+1)*3-1)];
		return rarity + " " + itemType;
	}
}
