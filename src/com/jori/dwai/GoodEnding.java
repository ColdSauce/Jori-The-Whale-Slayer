package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GoodEnding extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage map;
	private Jori jori;
	private Image pw;
	private boolean ranOnce = true;
	private boolean secondTimeSpeaking = false;
	private Music pwTalk;

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public GoodEnding(int state) {

	}

	public GoodEnding() {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		jori = Jori.getJori();
		map = new BigImage("res/TMX files/pics/FinalCaveAliveWhale.png");
		jori.makeGuy();
		pw = new Image("/res/pics of chars/PaulWatsonUp.png");
		// need to create empty sound first so that a null pointer isn't thrown
		pwTalk = new Music("/res/sounds/Voices/void.wav");
		this.checkCollision();
	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		map.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
		// if the mutant whale has died, paul watson should show up on the
		// screen
		if (jori.getmWhale())
			pw.draw(13 * 32, 13 * 32);
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (jori.isClose(13 * 32, 11 * 32)) {

			if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
				secondTimeSpeaking = true;
				pwTalk = new Music(
						"/res/sounds/Voices/PaulWatsonGoodEnding.wav");
				pwTalk.play();
			}
			if (secondTimeSpeaking && !pwTalk.playing()) {
				// go to the treasure room
				jori.changeLocationMemory(30);
				s.enterState(17);
			}

		}

		if ((jori.getX() / 32 == 13 && jori.getY() / 32 == 10)) {
			jori.changeMutant();
			s.enterState(7);
		}
		if (ranOnce) {
			jori.changeX(13 * 32);
			jori.changeY(21 * 32);
			ranOnce = false;
		}
		do {
			jori.takeInArray(mapArray);
		} while (false);
		Input input = gc.getInput();
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(16);
			s.enterState(11);
		}
		jori.takeInInput(input);
		jori.testKeys();
		jori.makeCollisionEasier();
	}

	public int[][] checkCollision() {

		mcc(15, 16);
		mcc(15, 15);
		mcc(15, 17);
		mcc(15, 18);
		mcc(16, 18);
		mcc(16, 7);
		mcc(15, 7);
		mcc(17, 18);
		mcc(17, 19);
		mcc(18, 19);
		mcc(18, 20);
		mcc(18, 21);
		mcc(17, 21);
		mcc(16, 21);
		mcc(15, 21);
		mcc(15, 22);
		mcc(14, 22);
		mcc(13, 22);
		mcc(12, 22);
		mcc(11, 22);
		mcc(10, 22);
		mcc(10, 21);
		mcc(9, 21);
		mcc(8, 21);
		mcc(8, 20);
		mcc(8, 19);
		mcc(9, 19);
		mcc(10, 19);
		mcc(10, 18);
		mcc(11, 17);
		mcc(10, 17);
		mcc(11, 16);
		mcc(12, 16);
		mcc(12, 15);
		mcc(12, 14);
		mcc(12, 13);
		mcc(12, 12);
		mcc(12, 11);
		mcc(12, 10);
		mcc(12, 9);
		mcc(12, 8);
		mcc(11, 8);
		mcc(11, 7);
		mcc(10, 7);
		mcc(9, 7);
		mcc(9, 6);
		mcc(9, 5);
		mcc(9, 4);
		mcc(10, 3);
		mcc(11, 3);
		mcc(12, 2);
		mcc(13, 2);
		mcc(14, 2);
		mcc(15, 2);
		mcc(15, 3);
		mcc(16, 3);
		mcc(17, 4);
		mcc(17, 5);
		mcc(17, 6);
		mcc(17, 7);
		mcc(17, 8);
		mcc(16, 8);
		mcc(15, 8);
		mcc(15, 9);
		mcc(15, 10);
		mcc(15, 11);
		mcc(15, 12);
		mcc(15, 13);
		mcc(15, 14);

		return mapArray;
	}

	public int getID() {
		return 16;
	}
}