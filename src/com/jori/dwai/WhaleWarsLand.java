package com.jori.dwai;

import org.newdawn.slick.BigImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WhaleWarsLand extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage map;
	private Image wwG;
	private Jori jori;
	private Music whaleWarsTalk;
	private boolean ranOnce = true;

	public WhaleWarsLand(int state) {

	}

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		wwG = new Image("/res/pics of chars/wwCDown.png");
		jori = Jori.getJori();
		jori.changeX(14 * 32);
		jori.changeY(3 * 32);
		whaleWarsTalk = new Music("/res/sounds/voices/void.wav");
		map = new BigImage("/res/maps/1WhaleWarsTown.png");
		jori.makeGuy();
		this.checkCollision();

	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		map.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
		wwG.draw(21 * 32, 4 * 32);
		wwG.draw(10 * 32, 16 * 32);
		wwG.draw(11 * 32, 12 * 32);
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(3);
			s.enterState(11);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {
			jori.changeLocationMemory(3);
			s.enterState(14);
		}
		if (jori.isClose(21 * 32, 4 * 32)
				&& gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			whaleWarsTalk = new Music("/res/sounds/voices/WWC1.wav");
			whaleWarsTalk.play();
		}

		else if (jori.isClose(10 * 32, 16 * 32)
				&& gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			whaleWarsTalk = new Music("/res/sounds/voices/WWC2.wav");
			whaleWarsTalk.play();
		}

		else if (jori.isClose(11 * 32, 12 * 32)
				&& gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			whaleWarsTalk = new Music("/res/sounds/voices/WWC3.wav");
			whaleWarsTalk.play();
		}

		if (ranOnce) {
			jori.changeX(14 * 32);
			jori.changeY(3 * 32);
			ranOnce = false;
		}
		do {
			jori.takeInArray(mapArray);
		} while (false);
		Input input = gc.getInput();
		jori.takeInInput(input);
		if (!whaleWarsTalk.playing())
			jori.testKeys();
		jori.makeCollisionEasier();
		if (jori.getX() / 32 == 14 && jori.getY() / 32 == 1) {
			jori.changeLocationMemory(3);
			jori.changeRan(false);
			s.enterState(12);
		}
		if (jori.getX() / 32 == 14 && jori.getY() / 32 == 12) {
			if(jori.getWhaleMeat() > 100){
				jori.changeRan(false);
				s.enterState(13);
			}
		}
	}

	public int[][] checkCollision() {
		mcc(10, 3);
		mcc(9, 3);
		mcc(8, 3);
		mcc(7, 2);
		mcc(8, 2);
		mcc(6, 3);
		mcc(5, 3);
		mcc(5, 4);
		mcc(5, 5);
		mcc(5, 6);
		mcc(5, 7);
		mcc(5, 8);
		mcc(5, 9);
		mcc(5, 10);
		mcc(5, 11);
		mcc(5, 12);
		mcc(5, 13);
		mcc(5, 14);
		mcc(5, 15);
		mcc(5, 16);
		mcc(5, 17);
		mcc(5, 18);
		mcc(5, 19);
		mcc(5, 18);
		mcc(6, 18);
		mcc(7, 18);
		mcc(8, 18);
		mcc(9, 18);
		mcc(10, 18);
		mcc(11, 18);
		mcc(12, 18);
		mcc(13, 18);
		mcc(14, 18);
		mcc(15, 18);
		mcc(16, 18);
		mcc(17, 18);
		mcc(18, 18);
		mcc(19, 18);
		mcc(20, 18);
		mcc(21, 18);
		mcc(22, 18);
		mcc(23, 18);
		mcc(23, 17);
		mcc(23, 16);
		mcc(23, 15);
		mcc(23, 14);
		mcc(23, 13);
		mcc(23, 12);
		mcc(23, 11);
		mcc(23, 10);
		mcc(23, 9);
		mcc(23, 8);
		mcc(23, 7);
		mcc(23, 6);
		mcc(23, 5);
		mcc(23, 4);
		mcc(23, 3);
		mcc(22, 2);
		mcc(21, 2);
		mcc(20, 2);
		mcc(19, 2);
		mcc(18, 2);
		mcc(17, 2);
		mcc(16, 2);
		mcc(16, 1);
		mcc(15, 1);
		mcc(13, 12);
		mcc(13, 1);
		mcc(13, 2);
		mcc(8, 9);
		mcc(7, 8);
		mcc(7, 7);
		mcc(8, 7);
		mcc(9, 7);
		mcc(10, 7);
		mcc(10, 8);
		mcc(9, 8);
		mcc(10, 9);
		mcc(10, 8);
		mcc(10, 9);
		mcc(11, 10);
		mcc(11, 9);
		mcc(12, 8);
		mcc(13, 8);
		mcc(14, 7);
		mcc(15, 8);
		mcc(16, 9);
		mcc(17, 10);
		mcc(17, 11);
		mcc(16, 11);
		mcc(15, 11);
		mcc(13, 11);
		mcc(12, 11);
		mcc(11, 11);
		mcc(8, 14);
		mcc(7, 14);
		mcc(7, 15);
		mcc(7, 16);
		mcc(9, 16);
		mcc(9, 15);
		mcc(9, 14);
		mcc(11, 14);
		mcc(11, 15);
		mcc(11, 16);
		mcc(12, 16);
		mcc(14, 16);
		mcc(15, 16);
		mcc(16, 16);
		mcc(17, 16);
		mcc(19, 16);
		mcc(20, 16);
		mcc(21, 16);
		mcc(21, 15);
		mcc(21, 14);
		mcc(20, 14);
		mcc(19, 14);
		mcc(18, 14);
		mcc(17, 14);
		mcc(16, 14);
		mcc(15, 14);
		mcc(14, 14);
		mcc(13, 14);
		mcc(12, 14);

		mcc(10, 4);
		mcc(11, 4);
		mcc(12, 3);
		mcc(13, 4);
		mcc(13, 5);
		mcc(19, 8);
		mcc(20, 8);
		mcc(21, 7);
		mcc(20, 7);
		mcc(19, 7);
		mcc(18, 7);
		mcc(18, 11);
		mcc(19, 11);
		mcc(20, 11);
		mcc(21, 11);
		mcc(21, 12);
		mcc(19, 12);
		mcc(17, 12);

		mcc(13, 3);
		mcc(10, 11);
		mcc(9, 11);
		mcc(8, 11);
		mcc(7, 11);
		mcc(8, 12);
		mcc(10, 12);
		mcc(10, 11);
		mcc(17, 8);
		mcc(21, 8);
		mcc(18, 15);
		mcc(19, 15);
		mcc(13, 15);
		mcc(12, 15);
		mcc(14, 15);
		return mapArray;
	}

	public int getID() {
		return 3;
	}
}
