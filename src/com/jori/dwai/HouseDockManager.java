package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HouseDockManager extends BasicGameState {
	private int[][] mapArray = new int[28][24];
	private BigImage docks;
	private Jori jori;
	private BigImage docksManager;
	private int currentXDocksManager = 7 * 32;
	private int currentYDocksManager = 9 * 32;
	private boolean shouldTalk = false;
	private BigImage docksManagerHead;
	private Music docksTalk;
	private boolean lockMovement = false;

	public HouseDockManager(int state) {

	}

	public HouseDockManager() {

	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		docksManager = new BigImage("/res/pics of chars/DocksDown.png");
		docks = new BigImage("/res/TMX files/pics/dockmanagerHouse.png");
		docksManagerHead = new BigImage(
				"/res/pics of chars/DocksManagerHead.png");
		jori = Jori.getJori();

		jori.makeGuy();
		docksTalk = new Music("/res/sounds/Voices/void.wav");
		this.checkCollision();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		docks.draw(0, 0);
		if (!lockMovement) {
			jori.getGuy().draw(jori.getX(), jori.getY());
		} else {
			jori.getGuy().draw(7 * 32, 10 * 32);
		}
		docksManager.draw(currentXDocksManager, currentYDocksManager);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		if (!jori.didRun()) {

			jori.changeX(12 * 32);
			jori.changeY(17 * 32);
		}
		jori.changeRan(true);
		do {
			jori.takeInArray(mapArray);
		} while (false);

		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_I)) {
			jori.changeLocationMemory(10);
			game.enterState(11);
		}
		jori.takeInInput(input);
		if (!lockMovement)
			jori.testKeys();
		jori.makeCollisionEasier();
		if (jori.getX() == 12 * 32 && jori.getY() == 18 * 32) {
			jori.changeX(22 * 32);
			jori.changeY(19 * 32);
			jori.changeRan(false);
			game.enterState(2);
		}
		if (input.isKeyPressed(Input.KEY_ENTER)
				&& jori.isClose(currentXDocksManager, currentYDocksManager)) {
			shouldTalk = true;
		}
		System.out.println(jori.getWhaleMeat());
		if (shouldTalk) {
			if (jori.isPitBlue()) {
				docksTalk = new Music("/res/sounds/Voices/Quest4Begin.wav");
			}
			if (jori.doesHaveKey()) {
				docksTalk = new Music("/res/sounds/Voices/Quest6Begin.wav");
			}
			if (jori.didSteal()) {
				jori.giveLetter();

				docksTalk = new Music("/res/sounds/Voices/Quest5Begin.wav");

			}
			if (jori.getWhaleMeat() >= 100) {
				jori.makePossibleChangePit();
				docksTalk = new Music("/res/sounds/Voices/Quest3Begin.wav");
			}

			docksTalk = new Music("/res/sounds/Voices/Quest"
					+ jori.getTimesTalked() + "_Begin.wav");
			docksTalk.play();
			shouldTalk = false;
		}
		lockMovement = docksTalk.playing();
	}

	public void mcc(int w, int h) {
		mapArray[w][h] = 1; // 1 means blocked
	}

	public int[][] checkCollision() {
		mcc(currentXDocksManager / 32, currentYDocksManager / 32);
		mcc(5, 19);
		mcc(6, 19);
		mcc(7, 19);
		mcc(8, 19);
		mcc(9, 19);
		mcc(10, 19);
		mcc(11, 19);
		mcc(12, 19);
		mcc(13, 19);
		mcc(14, 19);
		mcc(15, 19);
		mcc(16, 19);
		mcc(17, 19);
		mcc(18, 19);
		mcc(19, 19);
		mcc(20, 19);
		mcc(21, 19);
		mcc(21, 18);
		mcc(20, 18);
		mcc(21, 17);
		mcc(21, 16);
		mcc(21, 15);
		mcc(20, 15);
		mcc(20, 14);
		mcc(19, 14);
		mcc(18, 14);
		mcc(18, 15);
		mcc(18, 13);
		mcc(18, 12);
		mcc(18, 11);
		mcc(19, 11);
		mcc(20, 11);
		mcc(21, 11);
		mcc(21, 10);
		mcc(21, 9);
		mcc(21, 8);
		mcc(21, 7);
		mcc(21, 6);
		mcc(20, 6);
		mcc(19, 6);
		mcc(19, 7);
		mcc(19, 8);
		mcc(19, 9);
		mcc(18, 9);
		mcc(18, 8);
		mcc(18, 7);
		mcc(17, 6);
		mcc(16, 6);
		mcc(15, 6);
		mcc(15, 7);
		mcc(15, 8);
		mcc(14, 9);
		mcc(14, 10);
		mcc(14, 11);
		mcc(14, 12);
		mcc(14, 13);
		mcc(14, 14);
		mcc(11, 14);
		mcc(10, 14);
		mcc(9, 14);
		mcc(8, 14);
		mcc(7, 14);
		mcc(6, 14);
		mcc(6, 15);
		mcc(5, 15);
		mcc(11, 13);
		mcc(11, 12);
		mcc(11, 11);
		mcc(10, 11);
		mcc(9, 11);
		mcc(8, 11);
		mcc(7, 11);
		mcc(6, 11);
		mcc(5, 11);
		mcc(5, 10);
		mcc(5, 9);
		mcc(5, 8);
		mcc(5, 7);
		mcc(6, 7);
		mcc(7, 7);
		mcc(8, 7);
		mcc(9, 7);
		mcc(10, 7);
		mcc(11, 7);
		mcc(11, 6);
		mcc(12, 6);
		mcc(13, 6);
		mcc(14, 6);
		mcc(8, 16);
		mcc(14, 7);
		mcc(14, 8);
		mcc(5, 18);
		mcc(5, 17);
		mcc(5, 16);
		return mapArray;

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 10;
	}

}
