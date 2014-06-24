package com.jori.dwai;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HouseJori extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage house;
	private Jori jori;

	public HouseJori(int state) {

	}

	public HouseJori() {

	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		house = new BigImage("/res/TMX files/pics/1JoriHouse.png");
		jori = Jori.getJori();
		jori.makeGuy();
		this.checkCollision();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		house.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		if (!jori.didRun()) {
			jori.changeX(18 * 32);
			jori.changeY(17 * 32);
		}
		jori.changeRan(true);
		do {
			jori.takeInArray(mapArray);
		} while (false);
		Input input = container.getInput();
		jori.takeInInput(input);
		jori.testKeys();
		jori.makeCollisionEasier();
		if (container.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(8);
			game.enterState(11);
		}
		if (jori.getX() == 18 * 32 && jori.getY() == 18 * 32) {
			jori.changeX(19 * 32);
			jori.changeY(9 * 32);
			jori.changeRan(false);
			game.enterState(2);
			// jori.changeY(18*32);
		}
	}

	public Jori getJori() {
		return jori;
	}

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public int[][] checkCollision() {
		mcc(17, 18);
		mcc(16, 18);
		mcc(15, 18);
		mcc(14, 18);
		mcc(13, 18);
		mcc(12, 18);
		mcc(12, 17);
		mcc(12, 16);
		mcc(12, 15);
		mcc(11, 15);
		mcc(10, 15);
		mcc(9, 15);
		mcc(8, 15);
		mcc(7, 15);
		mcc(6, 15);
		mcc(6, 14);
		mcc(6, 13);
		mcc(6, 12);
		mcc(6, 11);
		mcc(6, 10);
		mcc(6, 9);
		mcc(7, 9);
		mcc(8, 9);
		mcc(9, 9);
		mcc(9, 10);
		mcc(9, 8);
		mcc(18, 19);
		mcc(19, 18);
		mcc(20, 18);
		mcc(21, 18);
		mcc(22, 18);
		mcc(23, 18);
		mcc(24, 18);
		mcc(24, 17);
		mcc(24, 16);
		mcc(24, 15);
		mcc(24, 14);
		mcc(24, 13);
		mcc(24, 12);
		mcc(24, 11);
		mcc(24, 10);
		mcc(23, 10);
		mcc(22, 10);
		mcc(21, 10);
		mcc(20, 10);
		mcc(19, 10);
		mcc(19, 9);
		mcc(18, 9);
		mcc(17, 9);
		mcc(16, 9);
		mcc(15, 9);
		mcc(14, 9);
		mcc(13, 9);
		mcc(13, 8);
		mcc(12, 7);
		mcc(11, 7);
		mcc(10, 7);
		mcc(18, 15);
		mcc(18, 14);
		mcc(18, 13);
		mcc(18, 12);
		return mapArray;

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 8;
	}

}
