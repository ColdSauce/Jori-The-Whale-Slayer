/**
 * 
 */
package com.jori.dwai;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.jori.dwai.states.TestLevel;

/**
 * @author Stefan Aleksic and Eson M. __ __ __ ___ __ ___ 
 * 
 * 
 * 
 * 
 * 
 */
public class JoriRunner extends StateBasedGame {
	public final static int TESTLEVEL = 1;
	public JoriRunner(String title) {
		super(title);
		addState(new TestLevel(TESTLEVEL, "testMap.png"));

	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer thing = new AppGameContainer(new JoriRunner("Jori The Whale Slayer!"));
		thing.setDisplayMode(1280, 768, false);
		thing.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		getState(TESTLEVEL).init(gc, this);
		
	}
}
