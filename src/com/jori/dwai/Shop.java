package com.jori.dwai;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Shop extends BasicGameState {
	private Image shop;
	private Jori jori;

	public Shop(int state) {
		// TODO Auto-generated constructor stub
	}

	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		shop = new Image("/res/TMX files/pics/shop.png");
		jori = Jori.getJori();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		shop.draw(0, 0);
	}

	public void update(GameContainer gc, StateBasedGame s, int delta)
			throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER))
			jori.addPlanks();
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
			s.enterState(jori.getLocationMemory());
	}

	public int getID() {
		return 14;
	}

}
