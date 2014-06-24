package com.jori.dwai.states;

import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.jori.dwai.util.Logger;
import com.jori.dwai.util.MapReader;
import com.jori.dwai.util.Tile;

public abstract class BaseState extends BasicGameState {
	protected  int state;
	protected  File imageFile;
	private Tile[][] tiledMap;
	private Image grassBlock;
	private Image wallBlock;
	public BaseState(int state,String fileName){
		File f = new File("maps/" + fileName);
		imageFile = f;
		this.state = state;
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame s)
			throws SlickException {
		try {
			loadBlocks();
		}
		catch(Exception e){
			Logger.logErr("Could not load blocks!",this.getClass());
		}
		Tile[][] tiledMap = MapReader.read(imageFile);
		this.tiledMap = tiledMap;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g)
			throws SlickException {
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		
		
	}
	
	@Override
	public int getID() {
		return state;
	}
	
	public Tile[][] getTiledMap(){
		return tiledMap;
	}
	public File getFile(){
		return imageFile;
	}
	

	public Image getGrassImage(){
		return grassBlock;
	}
	
	public Image getWallImage(){
		return wallBlock;
	}
	
	private void loadBlocks() throws Exception {
		grassBlock = new Image("res/blocks/grass.png");
		wallBlock = new Image("res/blocks/wall.png");
	}
}
