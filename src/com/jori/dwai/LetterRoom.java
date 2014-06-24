package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LetterRoom extends BasicGameState {
	private BigImage letterRoom;
	private Jori jori;
	private int[][] mapArray = new int[28][24];

	public LetterRoom(int state) {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		letterRoom = new BigImage("/res/Maps/LetterRoomWithLetter.png");
		jori = Jori.getJori();
		jori.makeGuy();
		this.checkCollision();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		letterRoom.draw(0, 0);
		jori.getGuy().draw(jori.getX(), jori.getY());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if (!jori.didRun()) {
			jori.changeX(14 * 32);
			jori.changeY(22 * 32);
		}
		jori.changeRan(true);
		do {
			jori.takeInArray(mapArray);
		} while (false);
		jori.takeInInput(input);
		jori.testKeys();
		jori.makeCollisionEasier();
		if (jori.isClose(14 * 32, 9 * 32)) {
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				letterRoom = new BigImage(
						"/res/Maps/LetterRoomWithoutLetter.png");

				jori.yupHeStoleIt();
			}

		}
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(13);
			s.enterState(11);
		}
		if (jori.getX() / 32 == 14 && jori.getY() / 32 == 23) {
			jori.changeRan(true);
			s.enterState(3);
		}

	}

	public void checkCollision() {
		mcc(17, 16);
		mcc(17, 15);
		mcc(17, 14);
		mcc(17, 13);
		mcc(17, 19);
		mcc(17, 20);
		mcc(17, 21);
		mcc(17, 20);
		mcc(12, 19);
		mcc(12, 20);
		mcc(12, 21);
		mcc(11, 19);
		mcc(11, 20);
		mcc(10, 20);
		mcc(9, 20);
		mcc(9, 19);
		mcc(8, 19);
		mcc(8, 20);
		mcc(7, 19);
		mcc(7, 20);
		mcc(6, 20);
		mcc(5, 20);
		mcc(4, 20);
		mcc(5, 19);
		mcc(5, 20);
		mcc(4, 20);
		mcc(3, 19);
		mcc(2, 19);
		mcc(2, 18);
		mcc(2, 17);
		mcc(3, 16);
		mcc(4, 16);
		mcc(4, 17);
		mcc(4, 18);
		mcc(6, 17);
		mcc(7, 17);
		mcc(8, 17);
		mcc(9, 17);
		mcc(9, 16);
		mcc(9, 15);
		mcc(8, 15);
		mcc(7, 15);
		mcc(6, 15);
		mcc(6, 16);
		mcc(7, 13);
		mcc(3, 14);
		mcc(3, 15);
		mcc(3, 16);
		mcc(3, 17);
		mcc(3, 10);
		mcc(3, 9);
		mcc(3, 8);
		mcc(3, 7);
		mcc(3, 7);
		mcc(4, 7);
		mcc(5, 7);
		mcc(5, 6);
		mcc(6, 6);
		mcc(7, 6);
		mcc(7, 7);
		mcc(8, 7);
		mcc(9, 7);
		mcc(9, 6);
		mcc(10, 6);
		mcc(11, 7);
		mcc(11, 6);
		mcc(12, 6);
		mcc(13, 5);
		mcc(14, 5);
		mcc(15, 5);
		mcc(16, 5);
		mcc(17, 6);
		mcc(17, 7);
		mcc(18, 7);
		mcc(18, 6);
		mcc(19, 6);
		mcc(19, 7);
		mcc(20, 7);
		mcc(20, 6);
		mcc(21, 6);
		mcc(22, 6);
		mcc(23, 6);
		mcc(24, 6);
		mcc(24, 7);
		mcc(25, 5);
		mcc(26, 6);
		mcc(26, 7);
		mcc(26, 8);
		mcc(26, 9);
		mcc(26, 10);
		mcc(26, 11);
		mcc(26, 12);
		mcc(26, 13);
		mcc(26, 14);
		mcc(26, 15);
		mcc(26, 17);
		mcc(26, 17);
		mcc(26, 18);
		mcc(26, 17);
		mcc(26, 16);
		mcc(26, 15);
		mcc(26, 14);
		mcc(26, 13);
		mcc(26, 12);
		mcc(25, 13);
		mcc(26, 13);
		mcc(25, 13);
		mcc(24, 13);
		mcc(24, 12);
		mcc(24, 11);
		mcc(24, 10);
		mcc(25, 10);
		mcc(26, 10);
		mcc(23, 11);
		mcc(22, 11);
		mcc(21, 11);
		mcc(20, 11);
		mcc(20, 11);
		mcc(20, 10);
		mcc(20, 9);
		mcc(21, 9);
		mcc(22, 9);
		mcc(23, 9);
		mcc(23, 10);
		mcc(21, 13);
		mcc(25, 14);
		mcc(25, 15);
		mcc(25, 16);
		mcc(25, 17);
		mcc(24, 19);
		mcc(21, 19);
		mcc(20, 19);
		mcc(19, 19);
		mcc(20, 20);
		mcc(17, 20);
		mcc(18, 20);
		mcc(19, 20);
		mcc(20, 20);
		mcc(21, 20);
		mcc(22, 20);
		mcc(23, 20);
		mcc(24, 20);
		mcc(25, 20);
		mcc(26, 19);
		mcc(14, 9);
		mcc(14, 8);
		mcc(15, 8);

		mcc(2, 16);
		mcc(2, 15);
		mcc(2, 14);
		mcc(2, 13);
		mcc(2, 12);
		mcc(2, 11);
		mcc(2, 9);
		mcc(2, 10);
		mcc(2, 9);
		mcc(2, 8);
		mcc(2, 7);
		mcc(2, 6);
		mcc(3, 6);
		mcc(6, 11);
		mcc(7, 11);
		mcc(8, 11);
		mcc(9, 11);
		mcc(9, 10);
		mcc(9, 9);
		mcc(9, 8);
		mcc(8, 8);
		mcc(7, 8);
		mcc(6, 8);
		mcc(5, 8);
		mcc(11, 10);
		mcc(12, 10);
		mcc(11, 9);
		mcc(11, 8);
		mcc(11, 8);
		mcc(12, 8);
		mcc(12, 9);
		mcc(17, 9);
		mcc(17, 10);
		mcc(17, 8);
		mcc(20, 17);
		mcc(20, 16);
		mcc(20, 15);
		mcc(21, 15);
		mcc(22, 15);
		mcc(23, 15);
		mcc(23, 16);
		mcc(23, 17);
		mcc(22, 17);
		mcc(17, 22);
		mcc(17, 23);
		mcc(17, 22);
		mcc(12, 22);
		mcc(12, 23);
	}

	public void mcc(int x, int y) {
		mapArray[x][y] = 1;
	}

	@Override
	public int getID() {
		return 13;
	}

}
