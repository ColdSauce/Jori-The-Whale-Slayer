package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HomeTownLand extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private Jori jori;
	private BigImage map;
	private PandaEE pan;
	private boolean ranOnce = true;

	public HomeTownLand(int state) {

	}

	public HomeTownLand() {

	}

	// This method was created just so mapArray[w][h] didn't have to be typed a
	// million times
	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	// this is a method of the basicGameState super class that is over writtern.
	// What happens in this
	// method is that when the game state starts, it runs this method once so if
	// there is anything
	// needed to initialize, this method is for it.
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		pan = new PandaEE(11 * 32, 2);
		jori = Jori.getJori();
		pan.createPandaBigImage();
		gc.setTargetFrameRate(60);
		map = new BigImage("res/TMX files/pics/1HomeTown.png");
		// It is needed to call this method because
		jori.makeGuy();
		this.checkCollision();
	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		map.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
		pan.returnPandaBigImage().draw(pan.pandaMove(), 2 * 32);
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (ranOnce) {
			jori.changeX(16 * 32);
			jori.changeY(10 * 32);
			ranOnce = false;
		}
		if (!jori.didRun()) {

		}
		jori.changeRan(true);
		do {
			jori.takeInArray(mapArray);
		} while (false);
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(2);
			s.enterState(11);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			jori.changeLocationMemory(2);
			s.enterState(14);
		}
		// Jori's house
		if (jori.getX() == 19 * 32 && jori.getY() == 8 * 32) {
			jori.changeRan(false);
			s.enterState(8);
		}

		// When jori touches the door of grandpa's house, he will enter it.
		if (jori.getX() == 8 * 32 && jori.getY() == 17 * 32) {
			jori.changeRan(false);
			s.enterState(9);
		}
		// when jori touches the door of the dock's manager's house, he will
		// enter it.
		if (jori.getX() == 21 * 32 && jori.getY() == 19 * 32) {
			jori.changeRan(false);
			s.enterState(10);
			// dock's manager
		}
		// Because input can only be accessed from this class, a method was
		// created in jori's class
		// to transfer input into it. Think of this as a violent cannon that
		// sends input to classes.
		Input input = gc.getInput();
		jori.takeInInput(input);

		// The update method here runs as a loop so testing the keys should be
		// done with this method.
		// To make the proccess more organized, another method was made in the
		// jori class and it runs
		// whenever the update method runs.
		jori.testKeys();

		// This method was created so that it could System.out.println() the
		// coordinates of the tiles that
		// need to be blocked. Add these coordinates to the checkCollision
		// method in this class and baby you got
		// a stew cookin'
		jori.makeCollisionEasier();

		if (jori.getX() == 26 * 32 && jori.getY() == 18 * 32
				&& input.isKeyPressed(Input.KEY_ENTER)) {
			jori.changeRan(false);
			jori.changeLocationMemory(2);
			s.enterState(12);
		}
	}

	// This method was created so that there was an easy way to put everything
	// in the blocked array.
	public int[][] checkCollision() {
		System.out.println("this works");
		for (int i = 9; i < 23; i++) {
			mcc(i, 7);
		}
		for (int i = 6; i < 17; i++) {
			mcc(8, i);
		}

		for (int i = 14; i < 23; i++) {
			mcc(15, i);
		}
		for (int i = 7; i < 16; i++) {
			mcc(i, 22);

		}
		for (int i = 7; i < 8; i++) {
			mcc(i, 17);

		}
		for (int i = 20; i < 24; i++) {
			mcc(i, 9);
		}
		mcc(9, 17);
		mcc(10, 17);
		mcc(11, 17);
		mcc(27, 7);
		mcc(27, 6);
		mcc(27, 5);
		mcc(27, 7);
		mcc(23, 6);
		mcc(14, 15);
		mcc(14, 21);
		mcc(16, 8);
		mcc(18, 8);
		mcc(16, 14);
		mcc(17, 14);
		mcc(17, 13);
		mcc(17, 12);
		mcc(17, 11);
		mcc(18, 12);
		mcc(19, 13);
		mcc(20, 13);
		mcc(21, 14);
		mcc(22, 14);
		mcc(21, 15);
		mcc(21, 16);
		mcc(22, 17);

		mcc(22, 18);
		mcc(21, 18);
		mcc(20, 18);
		mcc(20, 19);
		mcc(20, 20);
		mcc(21, 21);
		mcc(22, 20);
		mcc(23, 20);
		mcc(24, 21);
		mcc(25, 20);
		mcc(26, 19);
		mcc(27, 19);

		mcc(27, 13);
		mcc(24, 12);
		mcc(24, 11);
		mcc(25, 11);
		mcc(25, 12);
		mcc(26, 10);
		mcc(26, 9);
		mcc(23, 7);
		mcc(23, 8);
		mcc(20, 8);
		mcc(18, 7);
		mcc(20, 7);
		mcc(14, 8);
		mcc(9, 14);
		mcc(10, 14);
		mcc(11, 14);
		mcc(11, 15);
		mcc(11, 16);
		mcc(7, 18);
		mcc(7, 19);
		mcc(7, 20);
		mcc(8, 19);
		mcc(22, 5);
		mcc(23, 4);
		mcc(24, 3);
		mcc(25, 2);
		mcc(26, 2);
		mcc(27, 2);
		mcc(6, 21);
		return mapArray;
	}

	public int getID() {
		return 2;
	}
}