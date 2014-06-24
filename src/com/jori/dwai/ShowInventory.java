package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ShowInventory extends BasicGameState {
	// So what I'm thinking is an array of places and BigImages
	private int[] indexOfLight = { 128, 128 };
	private BigImage boxes;
	private BigImage lightBox;
	private Image planks;
	private Jori jori;
	// this array will store the indecies of the planks location
	private int[][] whereTheyAt = new int[6][6];

	public ShowInventory(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		lightBox = new BigImage("/res/inventory/boxHover.png");
		//

		boxes = new BigImage("/res/inventory/boxNormal.png");
		jori = Jori.getJori();
		planks = new Image("/res/inventory/Plank.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		int numOfPlanks = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < 5; i++) {
			y += 128;
			for (int j = 0; j < 5; j++) {
				x += 128;
				boxes.draw(x, y);

			}
			x = 0;
		}
		// since the render method works in "layers" the middle layer should be
		// the light box so that planks are on top of it and not overdrawn
		// and boxes are under it and are overdrawn
		lightBox.draw(indexOfLight[0], indexOfLight[1]);
		x = 0;
		y = 0;
		for (int i = 0; i < 5; i++) {
			y += 128;
			for (int j = 0; j < 5; j++) {
				x += 128;

				if (numOfPlanks < jori.getPlanks()) {
					planks.draw(x, y);
					// 1 means occupied
					whereTheyAt[i][j] = 1;
					numOfPlanks++;

				}

			}
			x = 0;
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_LEFT) && indexOfLight[0] != 128)
			indexOfLight[0] -= 128;

		if (input.isKeyPressed(Input.KEY_RIGHT) && indexOfLight[0] != 128 * 5)
			indexOfLight[0] += 128;

		if (input.isKeyPressed(Input.KEY_DOWN) && indexOfLight[1] != 128 * 5)
			indexOfLight[1] += 128;

		if (input.isKeyPressed(Input.KEY_UP) && indexOfLight[1] != 128)
			indexOfLight[1] -= 128;

		System.out.println((indexOfLight[0] / 128 - 1) + " "
				+ (indexOfLight[1] / 128 - 1));
		if (input.isKeyPressed(Input.KEY_ENTER)
				&& whereTheyAt[indexOfLight[0] / 128 - 1][indexOfLight[1] / 128 - 1] == 1) {
			whereTheyAt[indexOfLight[0] / 128][indexOfLight[1] / 128] = 0;
			jori.subPlanks();

		}
		if (input.isKeyPressed(Input.KEY_ESCAPE))
			s.enterState(jori.getLocationMemory());

	}

	@Override
	public int getID() {
		return 11;
	}
}
