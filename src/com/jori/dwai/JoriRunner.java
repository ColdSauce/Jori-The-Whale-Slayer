/**
 * 
 */
package com.jori.dwai;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Stefan Aleksic and Eson M. __ __ __ ___ __ ___ __ | / \ |__) | | \ /\
 *         | | |__| /\ | |__ /__` | /\ \ / |__ |__) \__/ \__/ | \ | |__/ /~~\
 *         |/\| | | /~~\ |___ |___ .__/ |___ /~~\ | |___ | \
 * 
 * 
 * 
 * 
 * 
 */
public class JoriRunner extends StateBasedGame {
	private static final int HOMETOWNLAND = 0;
	private static final int MENU = 2;
	private static final int WHALEWARSLAND = 3;
	private static final int WESTISLANDLAND = 4;
	private static final int EASTISLANDLAND = 5;
	private static final int CAVES = 6;
	private static final int BATTLESCENE = 7;
	private static final int HOUSEJORI = 8;
	private static final int HOUSEGRANDPA = 9;
	private static final int DOCKS = 10;
	private static final int SHOWINVENTORY = 11;
	private static final int FULLMAP = 12;
	private static final int LETTERROOM = 13;
	private static final int SHOP = 14;
	private static final int BADENDING = 15;
	private static final int GOODENDING = 16;
	private static final int TREASUREROOM = 17;

	public JoriRunner(String title) {
		super(title);
		addState(new Menu(MENU));
		addState(new HomeTownLand(HOMETOWNLAND));
		addState(new WhaleWarsLand(WHALEWARSLAND));
		addState(new WestIslandLand(WESTISLANDLAND));
		addState(new EastIslandLand(EASTISLANDLAND));
		addState(new Caves(CAVES));
		addState(new BattleScene(BATTLESCENE));
		addState(new HouseJori(HOUSEJORI));
		addState(new HouseGrandpa(HOUSEGRANDPA));
		addState(new HouseDockManager(DOCKS));
		addState(new ShowInventory(SHOWINVENTORY));
		addState(new FullMap(FULLMAP));
		addState(new LetterRoom(LETTERROOM));
		addState(new Shop(SHOP));
		addState(new BadEnding(BADENDING));
		addState(new GoodEnding(GOODENDING));
		addState(new TreasureRoom(TREASUREROOM));
	}

	public static void main(String[] args) throws SlickException {
		Jori.getJori();
		AppGameContainer thing = new AppGameContainer(new JoriRunner(
				"Jori The Whale Slayer!"));
		thing.setDisplayMode(896, 768, false);
		thing.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		// This is a state based game. Meaning that this game will
		// be constituted of "states" that are kind like screens.
		// each "state" will be a different screen in game.
		getState(MENU).init(gc, this);
		getState(HOMETOWNLAND).init(gc, this);
		getState(WHALEWARSLAND).init(gc, this);
		getState(WESTISLANDLAND).init(gc, this);
		getState(EASTISLANDLAND).init(gc, this);
		getState(BATTLESCENE).init(gc, this);
		getState(HOUSEJORI).init(gc, this);
		getState(HOUSEGRANDPA).init(gc, this);
		getState(DOCKS).init(gc, this);
		getState(SHOWINVENTORY).init(gc, this);
		getState(FULLMAP).init(gc, this);
		getState(LETTERROOM).init(gc, this);
		getState(SHOP).init(gc, this);
		getState(BADENDING).init(gc, this);
		getState(GOODENDING).init(gc, this);
		getState(TREASUREROOM).init(gc, this);
	}
}
