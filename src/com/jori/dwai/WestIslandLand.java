package com.jori.dwai;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WestIslandLand extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	BigImage map;
	private Jori jori;
	private boolean ranOnce = true;

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public WestIslandLand(int state) {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		jori = Jori.getJori();
		map = new BigImage("res/TMX files/pics/1WestIslandLand.png");
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
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(4);
			s.enterState(11);
		}
		if (ranOnce) {
			jori.changeX(12 * 32);
			jori.changeY(20 * 32);
			ranOnce = false;
		}
		do {
			jori.takeInArray(mapArray);

		} while (false);

		Input input = gc.getInput();
		jori.takeInInput(input);
		jori.testKeys();
		jori.makeCollisionEasier();
		if (jori.getX() / 32 == 3 && jori.getY() / 32 == 17) {
			jori.changeLocationMemory(4);
			jori.changeRan(false);
			s.enterState(12);
		}
		if (jori.getX() / 32 == 18 && jori.getY() / 32 == 6) {
			jori.changeX(19 * 32);
			jori.changeY(6 * 32);
			s.enterState(6);

		}

	}

	public int[][] checkCollision() {
		mcc(5, 15);
		mcc(4, 15);
		mcc(3, 15);
		mcc(3, 14);
		mcc(3, 13);
		mcc(3, 12);
		mcc(4, 12);
		mcc(5, 12);
		mcc(6, 12);
		mcc(7, 12);
		mcc(7, 11);
		mcc(7, 10);
		mcc(7, 9);
		mcc(7, 8);
		mcc(7, 7);
		mcc(7, 6);
		mcc(8, 6);
		mcc(9, 7);
		mcc(10, 7);
		mcc(11, 7);
		mcc(12, 7);
		mcc(12, 9);
		mcc(12, 10);
		mcc(12, 11);
		mcc(13, 11);
		mcc(14, 11);
		mcc(15, 11);
		mcc(16, 11);
		mcc(17, 11);
		mcc(18, 11);
		mcc(19, 11);
		mcc(19, 10);
		mcc(18, 10);
		mcc(17, 10);
		mcc(16, 10);
		mcc(15, 10);
		mcc(14, 10);
		mcc(14, 9);
		mcc(14, 8);
		mcc(8, 15);
		mcc(9, 15);
		mcc(10, 15);
		mcc(11, 15);
		mcc(12, 15);
		mcc(13, 15);
		mcc(14, 15);
		mcc(14, 16);
		mcc(14, 17);
		mcc(14, 18);
		mcc(14, 19);
		mcc(15, 19);
		mcc(15, 20);
		mcc(17, 17);
		mcc(17, 16);
		mcc(17, 14);
		mcc(16, 14);
		mcc(16, 13);
		mcc(17, 13);
		mcc(18, 13);
		mcc(19, 13);
		mcc(19, 12);
		mcc(14, 6);
		mcc(13, 6);
		mcc(13, 5);
		mcc(13, 4);
		mcc(14, 4);
		mcc(15, 4);
		mcc(16, 4);
		mcc(16, 5);
		mcc(16, 6);
		mcc(22, 3);
		mcc(22, 4);
		mcc(22, 5);
		mcc(22, 6);
		mcc(22, 7);
		mcc(22, 8);
		mcc(22, 9);
		mcc(22, 10);
		mcc(22, 11);
		mcc(21, 3);
		mcc(20, 3);
		mcc(19, 3);
		mcc(18, 3);
		mcc(17, 3);
		mcc(16, 3);
		mcc(15, 3);
		mcc(14, 3);
		mcc(13, 3);
		mcc(9, 14);
		mcc(10, 14);
		mcc(11, 14);
		mcc(10, 13);
		mcc(10, 12);
		mcc(10, 11);
		mcc(10, 10);
		mcc(23, 11);
		mcc(24, 11);
		mcc(24, 12);
		mcc(24, 13);
		mcc(24, 14);
		mcc(24, 15);
		mcc(24, 16);
		mcc(23, 16);
		mcc(22, 16);
		mcc(22, 17);
		mcc(21, 17);
		mcc(20, 17);
		mcc(19, 17);
		mcc(18, 17);
		mcc(18, 16);
		mcc(21, 15);
		mcc(21, 16);
		mcc(22, 13);
		mcc(23, 13);
		mcc(15, 15);
		mcc(15, 16);
		mcc(15, 17);
		mcc(15, 18);
		mcc(16, 18);
		mcc(16, 19);
		mcc(16, 20);
		mcc(15, 21);
		mcc(16, 21);
		mcc(17, 21);
		mcc(18, 21);
		mcc(19, 21);
		mcc(20, 21);
		mcc(21, 21);
		mcc(22, 20);
		mcc(21, 20);
		mcc(23, 20);
		mcc(4, 16);
		mcc(4, 19);
		mcc(5, 19);
		mcc(5, 20);
		mcc(5, 21);
		mcc(6, 21);
		mcc(7, 21);
		mcc(8, 21);
		mcc(9, 21);
		mcc(10, 21);
		mcc(11, 21);
		mcc(12, 21);
		mcc(13, 21);
		mcc(14, 21);
		mcc(3, 19);
		mcc(2, 19);
		mcc(2, 18);
		mcc(2, 17);
		mcc(2, 16);
		mcc(3, 16);
		return mapArray;

	}

	public int getID() {
		return 4;
	}
}