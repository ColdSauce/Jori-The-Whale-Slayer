package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EastIslandLand extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage map;
	private Jori jori;
	private boolean ranOnce = true;

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public EastIslandLand(int state) {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		jori = Jori.getJori();
		map = new BigImage("res/TMX files/pics/1EastIsland.png");
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

		if (!jori.didRun()) {
			System.out.println("this works");
			jori.changeX(15 * 32);
			jori.changeY(21 * 32);
			jori.changeRan(true);
		}
		do {
			jori.takeInArray(mapArray);
		} while (false);
		Input input = gc.getInput();
		jori.takeInInput(input);
		jori.testKeys();
		jori.makeCollisionEasier();
		if (jori.getX() / 32 == 15 && jori.getY() / 32 == 23) {
			jori.changeRan(false);
			jori.changeLocationMemory(5);
			s.enterState(12);
		}
		if (jori.doesHaveKey())
			if (jori.getX() / 32 == 15 && jori.getY() / 32 == 8)
				s.enterState(17);
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(5);
			s.enterState(11);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			jori.changeLocationMemory(5);
			s.enterState(14);
		}
	}

	public int[][] checkCollision() {
		mcc(14, 23);
		mcc(14, 22);
		mcc(14, 21);
		mcc(13, 21);
		mcc(13, 20);
		mcc(12, 20);
		mcc(11, 19);
		mcc(11, 18);
		mcc(11, 17);
		mcc(12, 16);
		mcc(13, 16);
		mcc(13, 16);
		mcc(14, 16);
		mcc(14, 15);
		mcc(13, 15);
		mcc(13, 14);
		mcc(13, 13);
		mcc(13, 12);
		mcc(13, 11);
		mcc(14, 11);
		mcc(16, 11);
		mcc(17, 11);
		mcc(18, 11);
		mcc(19, 11);
		mcc(18, 11);
		mcc(18, 10);
		mcc(19, 10);
		mcc(18, 9);
		mcc(19, 8);
		mcc(20, 9);
		mcc(20, 9);
		mcc(20, 8);
		mcc(19, 8);
		mcc(19, 7);
		mcc(19, 6);
		mcc(18, 5);
		mcc(17, 5);
		mcc(16, 4);
		mcc(15, 4);
		mcc(14, 4);
		mcc(13, 4);
		mcc(12, 5);
		mcc(11, 6);
		mcc(12, 5);
		mcc(11, 6);
		mcc(11, 7);
		mcc(11, 8);
		mcc(11, 9);
		mcc(12, 10);
		mcc(11, 9);
		mcc(13, 11);
		mcc(11, 10);
		mcc(12, 10);
		mcc(13, 12);
		mcc(14, 11);
		mcc(17, 14);
		mcc(17, 13);
		mcc(18, 13);
		mcc(19, 13);
		mcc(17, 14);
		mcc(16, 15);
		mcc(16, 16);
		mcc(17, 16);
		mcc(18, 16);
		mcc(19, 16);
		mcc(19, 17);
		mcc(20, 17);
		mcc(21, 17);
		mcc(21, 18);
		mcc(21, 19);
		mcc(21, 20);
		mcc(21, 21);
		mcc(21, 22);
		mcc(20, 21);
		mcc(19, 21);
		mcc(18, 21);
		mcc(17, 21);
		mcc(16, 21);
		mcc(16, 22);
		mcc(16, 23);
		mcc(16, 23);
		mcc(16, 23);
		mcc(14, 21);
		mcc(14, 22);
		mcc(14, 23);
		mcc(13, 22);
		mcc(13, 21);
		mcc(13, 20);
		mcc(12, 20);
		mcc(11, 20);
		mcc(20, 13);
		mcc(20, 12);
		mcc(20, 11);
		mcc(20, 10);
		mcc(13, 12);
		mcc(13, 13);
		mcc(13, 14);
		mcc(13, 15);
		mcc(13, 16);
		mcc(13, 16);
		mcc(12, 16);
		mcc(11, 16);
		mcc(11, 17);
		mcc(11, 18);
		mcc(11, 19);
		mcc(11, 20);
		mcc(15, 7);
		mcc(14, 8);
		mcc(16, 8);
		return mapArray;
	}

	public int getID() {
		return 5;
	}
}
