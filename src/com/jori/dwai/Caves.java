package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Caves extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage map;
	private Jori jori;
	private boolean ranOnce = true;

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public Caves(int state) {

	}

	public Caves() {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		jori = Jori.getJori();
		map = new BigImage("res/TMX files/pics/CavesWithKey.png");
		jori.makeGuy();
		this.checkCollision();
	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		map.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (ranOnce) {
			jori.changeX(14 * 32);
			jori.changeY(22 * 32);
			ranOnce = false;
		}
		do {
			jori.takeInArray(mapArray);
		} while (false);
		Input input = gc.getInput();
		jori.takeInInput(input);
		jori.testKeys();
		jori.makeCollisionEasier();

		if (jori.getX() == 14 * 32 && jori.getY() == 23 * 32) {
			jori.changeX(18 * 32);
			jori.changeY(7 * 32);
			jori.changeRan(false);
			s.enterState(4);
		}
		if (jori.getX() == 19 * 32 && jori.getY() == 6 * 32) {
			jori.changeX(14 * 32);
			jori.changeY(22 * 32);
		}
		if (jori.isClose(14 * 32, 10 * 32)) {
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				map = new BigImage("/res/TMX files/pics/CavesWithoutKey.png");

				jori.gotTheKey();
			}

		}
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(6);
			s.enterState(11);
		}

	}

	public int[][] checkCollision() {

		mcc(13, 23);
		mcc(13, 22);
		mcc(13, 21);
		mcc(13, 20);
		mcc(13, 19);
		mcc(12, 19);
		mcc(11, 19);
		mcc(11, 18);
		mcc(10, 18);
		mcc(9, 17);
		mcc(9, 16);
		mcc(9, 15);
		mcc(9, 14);
		mcc(9, 13);
		mcc(9, 12);
		mcc(9, 11);
		mcc(9, 10);
		mcc(10, 10);
		mcc(10, 9);
		mcc(11, 9);
		mcc(11, 8);
		mcc(12, 8);
		mcc(13, 8);
		mcc(14, 8);
		mcc(15, 8);
		mcc(16, 8);
		mcc(17, 8);
		mcc(17, 9);
		mcc(18, 9);
		mcc(19, 10);
		mcc(19, 11);
		mcc(19, 12);
		mcc(19, 13);
		mcc(19, 14);
		mcc(19, 15);
		mcc(19, 16);
		mcc(19, 17);
		mcc(19, 18);
		mcc(18, 18);
		mcc(18, 19);
		mcc(17, 19);
		mcc(16, 19);
		mcc(15, 19);
		mcc(15, 20);
		mcc(15, 21);
		mcc(15, 22);
		mcc(15, 23);
		mcc(18, 11);
		mcc(18, 12);
		mcc(18, 16);
		mcc(18, 17);
		mcc(17, 17);
		mcc(17, 16);
		mcc(17, 12);
		mcc(17, 11);
		mcc(11, 17);
		mcc(11, 16);
		mcc(11, 12);
		mcc(11, 11);
		mcc(17, 18);
		mcc(14, 10);

		return mapArray;
	}

	public int getID() {
		return 6;
	}
}