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

public class TreasureRoom extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage map;
	private Jori jori;
	private boolean ranOnce = true;
	private Image skeleton;
	private Music skel;

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public TreasureRoom(int state) {

	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		skeleton = new Image("/res/pics of chars/SkeletonUp.png");
		jori = Jori.getJori();
		map = new BigImage("res/TMX files/pics/SkeletonRoom.png");
		jori.makeGuy();
		this.checkCollision();
		skel = new Music("/res/sounds/Voices/void.wav");
	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		map.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
		skeleton.draw(13 * 32, 14 * 32);
		skel = new Music("/res/sounds/Voices/Skeleton.wav");
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (jori.getLocationMemory() == 30) {
			skel.play();
		} else {
			if (gc.getInput().isKeyPressed(Input.KEY_I)) {
				jori.changeLocationMemory(17);
				s.enterState(11);
			}
			// if the user is near the skeleton and presses the enter key,
			// the skeleton will start to talk
			if (jori.isClose(13 * 32, 14 * 32))
				if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
					skel = new Music("/res/sounds/Voices/Skeleton.wav");
					skel.play();
				}
			// no movement when talking
			if (!skel.playing())
				jori.testKeys();
			// once the user has entered the room, he will go to the 13 21
			// coordinates
			if (ranOnce) {
				jori.changeX(13 * 32);
				jori.changeY(21 * 32);
				ranOnce = false;
			}
			do {
				jori.takeInArray(mapArray);
			} while (false);
			Input input = gc.getInput();
			jori.takeInInput(input);
			jori.makeCollisionEasier();
		}
	}

	public int[][] checkCollision() {
		mcc(14, 23);
		mcc(14, 22);
		mcc(14, 21);
		mcc(15, 21);
		mcc(16, 21);
		mcc(17, 21);
		mcc(18, 21);
		mcc(19, 21);
		mcc(20, 21);
		mcc(20, 20);
		mcc(21, 20);
		mcc(22, 20);
		mcc(22, 19);
		mcc(22, 18);
		mcc(22, 17);
		mcc(22, 16);
		mcc(22, 15);
		mcc(22, 14);
		mcc(22, 13);
		mcc(22, 12);
		mcc(22, 11);
		mcc(22, 10);
		mcc(22, 9);
		mcc(22, 8);
		mcc(22, 7);
		mcc(22, 6);
		mcc(22, 5);
		mcc(21, 5);
		mcc(20, 4);
		mcc(20, 5);
		mcc(21, 6);
		mcc(19, 5);
		mcc(18, 5);
		mcc(17, 5);
		mcc(16, 5);
		mcc(15, 5);
		mcc(14, 5);
		mcc(13, 5);
		mcc(12, 5);
		mcc(11, 5);
		mcc(10, 5);
		mcc(9, 5);
		mcc(8, 5);
		mcc(7, 5);
		mcc(6, 5);
		mcc(6, 5);
		mcc(5, 6);
		mcc(4, 6);
		mcc(4, 7);
		mcc(4, 8);
		mcc(4, 9);
		mcc(4, 10);
		mcc(4, 11);
		mcc(4, 12);
		mcc(4, 13);
		mcc(4, 14);
		mcc(4, 15);
		mcc(4, 16);
		mcc(4, 17);
		mcc(4, 18);
		mcc(4, 19);
		mcc(4, 20);
		mcc(5, 20);
		mcc(5, 21);
		mcc(6, 21);
		mcc(6, 22);
		mcc(7, 22);
		mcc(7, 21);
		mcc(8, 21);
		mcc(9, 21);
		mcc(10, 21);
		mcc(11, 21);
		mcc(12, 21);
		mcc(12, 22);
		mcc(12, 23);
		mcc(11, 9);
		mcc(11, 8);
		mcc(11, 7);
		mcc(10, 7);
		mcc(9, 7);
		mcc(9, 8);
		mcc(8, 8);
		mcc(8, 9);
		mcc(8, 10);
		mcc(8, 11);
		mcc(8, 12);
		mcc(8, 13);
		mcc(8, 14);
		mcc(8, 15);
		mcc(8, 16);
		mcc(8, 17);
		mcc(8, 18);
		mcc(9, 18);
		mcc(9, 19);
		mcc(10, 19);
		mcc(11, 19);
		mcc(12, 19);
		mcc(13, 19);
		mcc(14, 19);
		mcc(15, 19);
		mcc(16, 19);
		mcc(17, 19);
		mcc(17, 18);
		mcc(18, 18);
		mcc(18, 17);
		mcc(18, 16);
		mcc(18, 15);
		mcc(18, 14);
		mcc(18, 13);
		mcc(18, 12);
		mcc(18, 11);
		mcc(18, 10);
		mcc(17, 10);
		mcc(17, 9);
		mcc(16, 9);
		mcc(15, 9);
		mcc(15, 8);
		mcc(15, 7);
		mcc(16, 7);
		mcc(17, 7);
		mcc(18, 8);
		mcc(10, 9);
		mcc(10, 18);
		mcc(11, 18);
		mcc(12, 18);
		mcc(13, 18);
		mcc(14, 18);
		mcc(15, 18);
		mcc(16, 18);
		mcc(16, 16);
		mcc(16, 11);
		mcc(10, 11);
		mcc(10, 16);
		mcc(9, 9);
		mcc(18, 9);
		mcc(17, 14);
		mcc(16, 14);
		mcc(10, 14);
		mcc(9, 14);
		mcc(5, 7);
		mcc(5, 8);
		mcc(5, 9);
		mcc(5, 10);
		mcc(5, 12);
		mcc(5, 12);
		mcc(5, 13);
		mcc(5, 14);
		mcc(5, 15);
		mcc(5, 16);
		mcc(5, 17);
		mcc(5, 18);
		mcc(5, 19);
		mcc(5, 19);
		mcc(5, 19);
		mcc(19, 18);
		mcc(19, 17);
		mcc(19, 16);
		mcc(19, 15);
		mcc(19, 14);
		mcc(19, 13);
		mcc(19, 12);
		mcc(19, 11);
		mcc(19, 10);
		mcc(19, 9);
		mcc(19, 8);
		mcc(19, 7);
		mcc(11, 11);
		mcc(11, 16);
		mcc(17, 13);
		mcc(13, 14);
		return mapArray;
	}

	public int getID() {
		return 17;
	}
}