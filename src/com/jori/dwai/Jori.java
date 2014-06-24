package com.jori.dwai;

import java.util.ArrayList;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Jori {
	private int karma = 1;
	public int whaleMeat = 0;
	private int health = 100;
	private int level = 1;
	private int[][] blockedIndex = new int[28][24];
	private int currentX = 16 * 32;
	private int currentY = 10 * 32;
	private Input input;
	private BigImage guy;
	private int attack = 10;
	private boolean ran = false;
	private int blubber = 0;
	private boolean letterAtHand = false;
	private boolean firstWhaleHasBeenKilled = false;
	private boolean isPitBlue = false;
	private boolean didStealSecretPlans = false;
	private boolean didGetKey = false;
	private boolean isBlockingPath = false;
	private int locationMemory = 0;
	private boolean isMutant = false;
	private boolean mIsDead = false;
	private boolean posToChangePit = false;
	private int timesTalkedToDocksManager = 1; // needs to start at one because
												// the quests are numbered 1-6
	private int planks = 4;
	private boolean mWhaleDefeated = false;

	private Jori() {

	}

	public void changeLifeM() {
		mIsDead = true;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void changeMutant() {
		isMutant = true;
	}

	public boolean getmWhale() {
		return mWhaleDefeated;
	}

	public void mWhaleDefeated() {
		mWhaleDefeated = true;
	}

	public int getTimesTalked() {
		return timesTalkedToDocksManager;
	}

	public void incrementTimesTalked() {
		timesTalkedToDocksManager++;
	}

	// QUEST 1
	public void changeKilling() {
		if (!firstWhaleHasBeenKilled)
			this.incrementTimesTalked();
		firstWhaleHasBeenKilled = true;

	}

	// QUEST 2

	public void changeWhaleMeat(int thing) {
		whaleMeat += thing;
		// this.incrementTimesTalked();
	}

	public int getWhaleMeat() {
		if (whaleMeat == 100)
			this.incrementTimesTalked();
		return whaleMeat;
	}

	public boolean hasLetter() {
		return letterAtHand;
	}

	public void changeLetter() {
		letterAtHand = !letterAtHand;
		// this.incrementTimesTalked();
	}

	public void giveLetter() {
		this.incrementTimesTalked();
	}

	// QUEST 7
	public boolean canChangePit() {
		return posToChangePit;
	}

	public void makePossibleChangePit() {
		posToChangePit = true;
	}

	public void changePit() {
		isPitBlue = true;
		this.incrementTimesTalked();
	}

	public boolean isPitBlue() {
		return isPitBlue;
	}

	// QUEST 8
	public void yupHeStoleIt() {
		didStealSecretPlans = true;
		this.incrementTimesTalked();
	}

	public Boolean didSteal() {
		return didStealSecretPlans;
	}

	// QUEST 9
	public void gotTheKey() {
		this.didGetKey = true;
		this.incrementTimesTalked();
	}

	public boolean doesHaveKey() {
		return didGetKey;
	}

	// QUEST 10
	public void stopBlockingShipWithWaves() {
		this.isBlockingPath = false;
	}

	public boolean isBlockingPath() {
		return isBlockingPath;
	}

	// DONE WITH QUESTS

	public int getBlubber() {
		return blubber;
	}

	// blubber is the currency. This method just changes it
	public void decreaseBlubber(int changeTo) {
		blubber -= changeTo;
	}

	public void increaseBlubber(int changeTo) {
		blubber += changeTo;
	}

	// This method is just here so that we can see if the startup variables
	// in the lands need to be run again
	public boolean didRun() {
		return ran;
	}

	public void changeRan(boolean x) {
		ran = x;
	}

	// If jori made a bad decision, this method will run with a certain amount
	// to decrease his karma.
	public void decreaseKarma(int amount) {
		karma -= amount;
	}

	public void increaseKarma(int amount) {
		karma += amount;
	}

	public int getKarma() {
		return karma;
	}

	public int getAttack() {
		return attack;
	}

	// This is created so that there is only one instance of Jori in the entire
	// game.
	// It's called the Singleton Pattern.
	private static Jori jori = null;

	public static Jori getJori() {
		if (jori == null)
			jori = new Jori();

		return jori;
	}

	// The following method is used when Jori goes into the sea, since it would
	// look really weird if Jori
	// Was swimming really fast in the ocean, converting his BigImage to a ship
	// is a good idea.
	public void turnIntoAShip() throws SlickException {
		guy = new BigImage("PUT THE SHIP LOCATION IN HERE!!!!!!!!!!!");
	}

	// This method figures out what key a person pressed and runs the
	// appropriate method to go along with it.
	public void testKeys() {
		if (input.isKeyPressed(Input.KEY_UP)) {
			moveUp();
		} else if (input.isKeyPressed(Input.KEY_DOWN)) {
			moveDown();
		} else if (input.isKeyPressed(Input.KEY_LEFT)) {
			moveLeft();
		} else if (input.isKeyPressed(Input.KEY_RIGHT)) {
			moveRight();
		}

	}

	// Without this method that ^^^^ method couldn't get the input because it
	// would be Null.
	public void takeInInput(Input input) {
		this.input = input;
	}

	// This just creates a new BigImage of Jori.
	public void makeGuy() {
		try {
			guy = new BigImage("res/pics of chars/JDown.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	// using the distance formula, this method checks to see if the coordinates
	// in the parameters
	// are close to jori(meaning they're 2*32 pixels away.
	public boolean isClose(int x, int y) {
		return (Math.sqrt(Math.abs((x / 32 - this.getX() / 32)
				* (x / 32 - this.getX() / 32)
				+ ((y / 32 - this.getY() / 32) * (y / 32 - this.getY() / 32)))) < 2);

	}

	// This method was written to transfer the contents of the map array from
	// the houses and towns into this method
	// so that collision would be more organized.
	public void takeInArray(int[][] array) {
		blockedIndex = array;
	}

	// Self explanatory
	public int getX() {
		return currentX;
	}

	public int getY() {
		return currentY;
	}

	public BigImage getGuy() {
		return guy;
	}

	public void moveDown() {
		try {
			guy = new BigImage("res/pics of chars/JDown.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// The first part of this if statement tests whether or not Jori is
		// going over the bounds of
		// the map. The second part of the if statement tests the tile below
		// jori and sees if it is 0
		// meaning that it is empty. If it is empty, jori will move down. If
		// not, nothing is done.
		if (currentY + 32 < 768
				&& blockedIndex[currentX / 32][(currentY / 32) + 1] == 0) {
			currentY += 32;
		}
	}

	public void moveUp() {
		try {
			guy = new BigImage("res/pics of chars/JUp.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// The first part of this if statement tests whether or not Jori is
		// going over the bounds of
		// the map. The second part of the if statement tests the tile above
		// jori and sees if it is 0
		// meaning that it is empty. If it is empty, jori will move up. If not,
		// nothing is done.
		if (currentY - 32 > 0
				&& blockedIndex[currentX / 32][(currentY / 32) - 1] == 0) {
			currentY -= 32;
		}
	}

	public void moveLeft() {
		try {
			guy = new BigImage("res/pics of chars/JLeft.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// The first part of this if statement tests whether or not Jori is
		// going over the bounds of
		// the map. The second part of the if statement tests the tile to the
		// left of jori and sees if it is 0
		// meaning that it is empty. If it is empty, jori will move left. If
		// not, nothing is done.
		if (currentX - 32 > 0
				&& blockedIndex[(currentX / 32) - 1][(currentY / 32)] == 0) {

			currentX -= 32;
		}
	}

	public void moveRight() {
		try {
			guy = new BigImage("res/pics of chars/JRight.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// The first part of this if statement tests whether or not Jori is
		// going over the bounds of
		// the map. The second part of the if statement tests the tile to the
		// right of jori and sees if it is 0
		// meaning that it is empty. If it is empty, jori will move right. If
		// not, nothing is done.
		if (currentX + 32 < 896
				&& blockedIndex[(currentX / 32) + 1][(currentY / 32)] == 0) {

			currentX += 32;
		}
	}

	// All this method does is print the coordinates of where jori is located so
	// that it can be copied/pasted
	// int the checkCollision() method of the corresponding map/house.
	public void makeCollisionEasier() {
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			System.out.println("mcc(" + currentX / 32 + "," + currentY / 32
					+ ");");
		}

	}

	public void changeLocationMemory(int state) {
		locationMemory = state;
	}

	public int getLocationMemory() {
		return locationMemory;
	}

	public void changeX(int changeTo) {
		currentX = changeTo;
	}

	public void changeY(int changeTo) {
		currentY = changeTo;
	}

	public void decreaseHealth(int amountToDecrease) {
		health -= amountToDecrease;
	}

	public int getHealth() {
		return health;
	}

	public void addPlanks() {
		planks++;
	}

	public int getPlanks() {
		return planks;
	}

	public void increaseAttack(int amount) {
		attack += amount;
	}

	public void increaseHealth(int amount) {
		health += amount;
	}

	public void subPlanks() {
		this.health = 100;
		planks--;
	}

}
